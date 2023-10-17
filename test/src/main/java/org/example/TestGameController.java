package org.example;

import sdl.*;
import sdl.events.GeneralInputStateDefinitions;
import sdl.events.button.MouseButtonDown;
import sdl.events.button.MouseButtonUp;
import sdl.events.controllerdevice.ControllerDeviceAdded;
import sdl.events.controllerdevice.ControllerDeviceRemoved;
import sdl.events.Event;
import sdl.events.controllersensor.ControllerSensorUpdate;
import sdl.events.controllertouchpad.ControllerTouchpadDown;
import sdl.events.controllertouchpad.ControllerTouchpadMotion;
import sdl.events.controllertouchpad.ControllerTouchpadUp;
import sdl.events.key.KeyDown;
import sdl.events.motion.MouseMotion;
import sdl.events.quit.Quit;
import sdl.gamecontroller.GameController;
import sdl.gamecontroller.GameControllerType;
import sdl.gamecontroller.JoystickId;
import sdl.gamecontroller.SensorType;
import sdl.hints.Hints;
import sdl.joystick.Joystick;
import sdl.joystick.VirtualJoystickDesc;
import sdl.keyboard.Keyboard;
import sdl.keycode.Keymod;
import sdl.render.Renderer;
import sdl.video.Window;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.util.FormatProcessor.FMT;
import static org.example.TestUtils.loadTexture;
import static sdl.jextract.sdl_h.*;

/*
  Copyright (C) 1997-2023 Sam Lantinga <slouken@libsdl.org>

  This software is provided 'as-is', without any express or implied
  warranty.  In no event will the authors be held liable for any damages
  arising from the use of this software.

  Permission is granted to anyone to use this software for any purpose,
  including commercial applications, and to alter it and redistribute it
  freely.
*/

/* Simple program to test the SDL game controller routines */
public class TestGameController {

    private static boolean VERBOSE_SENSORS = false;
    private static boolean VERBOSE_AXES = false;

    private static final int SCREEN_WIDTH = 512;
    private static final int SCREEN_HEIGHT = 320;

    private static final int BUTTON_SIZE = 50;
    private static final int AXIS_SIZE = 50;

    /* This is indexed by SDL_GameControllerButton. */
    record ButtonPosition(int x, int y) {}
    final static ButtonPosition[] BUTTON_POSITIONS = {
            new ButtonPosition(387, 167), /* SDL_CONTROLLER_BUTTON_A */
            new ButtonPosition(431, 132), /* SDL_CONTROLLER_BUTTON_B */
            new ButtonPosition(342, 132), /* SDL_CONTROLLER_BUTTON_X */
            new ButtonPosition(389, 101), /* SDL_CONTROLLER_BUTTON_Y */
            new ButtonPosition(174, 132), /* SDL_CONTROLLER_BUTTON_BACK */
            new ButtonPosition(232, 128), /* SDL_CONTROLLER_BUTTON_GUIDE */
            new ButtonPosition(289, 132), /* SDL_CONTROLLER_BUTTON_START */
            new ButtonPosition(75, 154),  /* SDL_CONTROLLER_BUTTON_LEFTSTICK */
            new ButtonPosition(305, 230), /* SDL_CONTROLLER_BUTTON_RIGHTSTICK */
            new ButtonPosition(77, 40),   /* SDL_CONTROLLER_BUTTON_LEFTSHOULDER */
            new ButtonPosition(396, 36),  /* SDL_CONTROLLER_BUTTON_RIGHTSHOULDER */
            new ButtonPosition(154, 188), /* SDL_CONTROLLER_BUTTON_DPAD_UP */
            new ButtonPosition(154, 249), /* SDL_CONTROLLER_BUTTON_DPAD_DOWN */
            new ButtonPosition(116, 217), /* SDL_CONTROLLER_BUTTON_DPAD_LEFT */
            new ButtonPosition(186, 217), /* SDL_CONTROLLER_BUTTON_DPAD_RIGHT */
            new ButtonPosition(232, 174), /* SDL_CONTROLLER_BUTTON_MISC1 */
            new ButtonPosition(132, 135), /* SDL_CONTROLLER_BUTTON_PADDLE1 */
            new ButtonPosition(330, 135), /* SDL_CONTROLLER_BUTTON_PADDLE2 */
            new ButtonPosition(132, 175), /* SDL_CONTROLLER_BUTTON_PADDLE3 */
            new ButtonPosition(330, 175), /* SDL_CONTROLLER_BUTTON_PADDLE4 */
            new ButtonPosition(0, 0),     /* SDL_CONTROLLER_BUTTON_TOUCHPAD */
    };
    static {
        assert(BUTTON_POSITIONS.length == GameControllerButton.Max.value());
    }

    /* This is indexed by SDL_GameControllerAxis. */
    record AxisPosition(int x, int y, double angle) {}
    final static AxisPosition[] AXIS_POSITIONS = {
            new AxisPosition(74, 153, 270.0), /* LEFTX */
            new AxisPosition( 74, 153, 0.0 ),   /* LEFTY */
            new AxisPosition( 306, 231, 270.0 ),/* RIGHTX */
            new AxisPosition( 306, 231, 0.0 ),  /* RIGHTY */
            new AxisPosition( 91, -20, 0.0),    /* TRIGGERLEFT */
            new AxisPosition( 375, -20, 0.0)   /* TRIGGERRIGHT */
    };
    static {
        assert(AXIS_POSITIONS.length == GameControllerAxis.Max.value());
    }

    /* This is indexed by SDL_JoystickPowerLevel + 1. */
    final static String[] POWER_LEVEL_STRINGS = {
        "unknown", /* SDL_JOYSTICK_POWER_UNKNOWN */
                "empty",   /* SDL_JOYSTICK_POWER_EMPTY */
                "low",     /* SDL_JOYSTICK_POWER_LOW */
                "medium",  /* SDL_JOYSTICK_POWER_MEDIUM */
                "full",    /* SDL_JOYSTICK_POWER_FULL */
                "wired"   /* SDL_JOYSTICK_POWER_WIRED */
    };
    static {
        // todo: SDL_COMPILE_TIME_ASSERT(POWER_LEVEL_STRINGS, SDL_arraysize(POWER_LEVEL_STRINGS) == SDL_JOYSTICK_POWER_MAX + 1);
    }

    private Window window = null;
    private Renderer screen = null;
    private boolean retval = false;
    private boolean done = false;
    private boolean set_LED = false;
    static int triggerEffect = 0;
    static Texture backgroundFront, backgroundBack, buttonTexture, axisTexture;
    private GameController gameController;
    private List<GameController> gameControllers = new ArrayList<>();
    private Joystick virtualJoystick = null;
    static GameControllerAxis virtualAxisActive = GameControllerAxis.Invalid;
    private int virtualAxisStartX;
    private int virtualAxisStartY;
    static GameControllerButton virtualButtonActive = GameControllerButton.Invalid;

    void updateWindowTitle()
    {
        if (window == null) {
            return;
        }

        if (gameController != null) {
            String name = gameController.name();
            String serial = gameController.getSerial();
            String baseTitle = "Game Controller Test: ";
            String title;
            retval = false;
            done = false;

            title = baseTitle;
            if (name != null) {
                title += name;
            }
            if (serial != null) {
                title += " (";
                title += serial;
                title += ")";
            }

            window.setWindowTitle(title);
        } else {
            window.setWindowTitle("Waiting for controller...");
        }
    }

    static String getSensorName(SensorType sensor)
    {
        return switch (sensor) {
            case Accel -> "accelerometer";
            case Gryo -> "gyro";
            case AccelL -> "accelerometer (L)";
            case GyroL -> "gyro (L)";
            case AccelR -> "accelerometer (R)";
            case GyroR -> "gyro (R)";
            default -> "UNKNOWN";
        };
    }

    int findController(JoystickId controller_id)
    {
        int i;

        for (i = 0; i < gameControllers.size(); ++i) {
            if (controller_id.equals(gameControllers.get(i).getJoystick().instanceId())) {
                return i;
            }
        }
        return -1;
    }

    void addController(int deviceIndex, boolean verbose)
    {
        JoystickId controllerId = Joystick.getDeviceInstanceId(deviceIndex);
        GameController controller;
        GameController[] controllers;
        short firmwareVersion;
        Set<SensorType> sensors = Set.of(
                SensorType.Accel,
                SensorType.Gryo,
                SensorType.AccelL,
                SensorType.GyroL,
                SensorType.AccelR,
                SensorType.GyroR
        );
        int i;

        controllerId = Joystick.getDeviceInstanceId(deviceIndex);

        if (findController(controllerId) >= 0) {
            /* We already have this controller */
            return;
        }

        controller = GameController.open(deviceIndex);

        gameControllers.add(controller);
        gameController = controller;
        triggerEffect = 0;

        if (verbose) {
            String name = gameController.name();
            String path = gameController.path();
            System.out.println(STR."Opened game controller \{name}\{path != null ? ", " : ""}\{path != null ? path : ""}");
        }

        firmwareVersion = gameController.getFirmwareVersion();
        if (firmwareVersion > 0) {
            if (verbose) {
                System.out.println(FMT."Firmware version: 0x\{firmwareVersion} (\{firmwareVersion}})");
            }
        }

        for (var sensor : sensors) {
            if (gameController.hasSensor(sensor)) {
                if (verbose) {
                    System.out.println(FMT."Enabling %\{getSensorName(sensor)} at %.2\{gameController.getSensorDataRate(sensor)} Hz");
                }
                gameController.setSensorEnabled(sensor, true);
            }
        }

        if (gameController.hasRumble()) {
            SDL_Log("Rumble supported");
        }

        if (gameController.hasRumbleTriggers()) {
            SDL_Log("Trigger rumble supported");
        }

        updateWindowTitle();
    }

    void setController(JoystickId controller)
    {
        int i = findController(controller);

        if (i < 0) {
            return;
        }

        if (!gameController.equals(gameControllers.get(i))) {
            gameController = gameControllers.get(i);
            updateWindowTitle();
        }
    }

    void delController(JoystickId controller)
    {
        int i = findController(controller);

        if (i < 0) {
            return;
        }

        gameControllers.remove(i).close();

        if (!gameControllers.isEmpty()) {
            gameController = gameControllers.getFirst();
        } else {
            gameController = null;
        }
        updateWindowTitle();
    }

    short convertAxisToRumble(short axisval)
    {
        /* Only start rumbling if the axis is past the halfway point */
        short half_axis = (short) Math.ceil(Joystick.AXIS_MAX / 2.0f);
        if (axisval > half_axis) {
            return (short) ((axisval - half_axis) * 4);
        } else {
            return 0;
        }
    }

    /* PS5 trigger effect documentation:
       https://controllers.fandom.com/wiki/Sony_DualSense#FFB_Trigger_Modes
    */
    static final StructLayout ds5EffectsState = MemoryLayout.structLayout(
            JAVA_BYTE.withName("ucEnableBits1"),
            JAVA_BYTE.withName("ucEnableBits2"),
            JAVA_BYTE.withName("ucRumbleRight"),
            JAVA_BYTE.withName("ucRumbleLeft"),
            JAVA_BYTE.withName("ucHeadphoneVolume"),
            JAVA_BYTE.withName("ucSpeakerVolume"),
            JAVA_BYTE.withName("ucMicrophoneVolume"),
            JAVA_BYTE.withName("ucAudioEnableBits"),
            JAVA_BYTE.withName("ucMicLightMode"),
            JAVA_BYTE.withName("ucAudioMuteBits"),
            MemoryLayout.sequenceLayout(11, JAVA_BYTE).withName("rgucRightTriggerEffect"),
            MemoryLayout.sequenceLayout(11, JAVA_BYTE).withName("rgucLeftTriggerEffect"),
            MemoryLayout.sequenceLayout(6, JAVA_BYTE).withName("rgucUnknown1"),
            JAVA_BYTE.withName("ucLedFlags"),
            MemoryLayout.sequenceLayout(2, JAVA_BYTE).withName("rgucUnknown2"),
            JAVA_BYTE.withName("ucLedAnim"),
            JAVA_BYTE.withName("ucLedBrightness"),
            JAVA_BYTE.withName("ucPadLights"),
            JAVA_BYTE.withName("ucLedRed"),
            JAVA_BYTE.withName("ucLedGreen"),
            JAVA_BYTE.withName("ucLedBlue")
    ).withName("DS5EffectsState");

    void cyclePS5TriggerEffect()
    {
        try (var arena = Arena.ofConfined()) {
            var state = arena.allocate(ds5EffectsState);
            // DS5EffectsState_t state;

            byte effects[ 3][11] ={
                /* Clear trigger effect */
                {
                    0x05, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                },
                /* Constant resistance across entire trigger pull */
                {
                    0x01, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0
                },
                /* Resistance and vibration when trigger is pulled */
                {
                    0x06, 15, 63, 128, 0, 0, 0, 0, 0, 0, 0
                },
            } ;

            triggerEffect = (triggerEffect + 1) % effects.length;

            VarHandle ucEnableBits1 = ds5EffectsState.varHandle(MemoryLayout.PathElement.groupElement("ucEnableBits1"));
            VarHandle rgucRightTriggerEffect = ds5EffectsState.varHandle(MemoryLayout.PathElement.groupElement("rgucRightTriggerEffect"));
            VarHandle rgucLeftTriggerEffect = ds5EffectsState.varHandle(MemoryLayout.PathElement.groupElement("rgucLeftTriggerEffect"));

            ucEnableBits1.set((byte) (((byte)ucEnableBits1.get(state)) | (byte)(0x04 | 0x08))); /* Modify right and left trigger effect respectively */
            // state.ucEnableBits1 |= (0x04 | 0x08); /* Modify right and left trigger effect respectively */
            // SDL_memcpy(state.rgucRightTriggerEffect, effects[triggerEffect], sizeof(effects[triggerEffect]));
            // SDL_memcpy(state.rgucLeftTriggerEffect, effects[triggerEffect], sizeof(effects[triggerEffect]));
            gameController.sendEffect(state);
        }
    }

    boolean showingFront()
    {
        boolean showingFront = true;
        int i;

        if (gameController != null) {
            /* Show the back of the controller if the paddles are being held */
            for (i = GameControllerButton.Paddle1.value(); i <= GameControllerButton.Paddle4.value(); ++i) {
                if (gameController.getButton(GameControllerButton.valueOf(i)) == GeneralInputStateDefinitions.Pressed) {
                    showingFront = false;
                    break;
                }

            }
        }
        if (Keyboard.getModState().contains(Keymod.Shift)) {
            showingFront = false;
        }
        return showingFront;
    }

    VirtualJoystickDesc.SetPlayerIndex virtualControllerSetPlayerIndex = (MemorySegment userData, int playerIndex) ->
    {
        System.out.println(STR."Virtual Controller: player index set to \{playerIndex}");
    };

    VirtualJoystickDesc.Rumble virtualControllerRumble = (MemorySegment userData, short lowFrequencyRumble, short highFrequencyRumble) -> {
        System.out.println(STR."Virtual Controller: rumble set to \{lowFrequencyRumble}/\{highFrequencyRumble}");
        return 0;
    };

    VirtualJoystickDesc.RumbleTriggers virtualControllerRumbleTriggers = (MemorySegment userData, short leftRumble, short rightRumble) -> {
        System.out.println(STR."Virtual Controller: trigger rumble set to \{leftRumble}/\{rightRumble}");
        return 0;
    };

    VirtualJoystickDesc.SetLED virtualControllerSetLED = (MemorySegment userData, byte red, byte green, byte blue) -> {
        System.out.println(STR."Virtual Controller: LED set to RGB \{red},\{green},\{blue}");
        return 0;
    };

    void openVirtualController()
    {
        VirtualJoystickDesc desc = new VirtualJoystickDesc(
                // auto-set? SDL_VIRTUAL_JOYSTICK_DESC_VERSION(),
                (short) SDL_JOYSTICK_TYPE_GAMECONTROLLER(),
                (short) SDL_CONTROLLER_AXIS_MAX(),
                (short) SDL_CONTROLLER_AXIS_MAX(),
                (short) 0,
                (short) 0,
                (short) 0,
                0,
                0,
                null,
                MemorySegment.NULL,
                null,
                virtualControllerSetPlayerIndex,
                virtualControllerRumble,
                virtualControllerRumbleTriggers,
                virtualControllerSetLED,
                null
        );
        int virtualIndex = Joystick.attachVirtual(desc);
        virtualJoystick = Joystick.open(virtualIndex);
    }

    void closeVirtualController()
    {
        int i;

        for (i = Joystick.numJoysticks(); i == 0; i--) {
            if (Joystick.isVirtual(i)) {
                Joystick.detachVirtual(i);
            }
        }

        if (virtualJoystick != null) {
            virtualJoystick.close();
            virtualJoystick = null;
        }
    }

    GameControllerButton findButtonAtPosition(int x, int y)
    {
        Point point;
        int i;
        boolean showingFront = showingFront();

        point = new Point(x, y);
        for (i = 0; i < GameControllerButton.Touchpad.value(); ++i) {
            boolean onFront = (i < GameControllerButton.Paddle1.value() || i > GameControllerButton.Paddle4.value());
            if (onFront == showingFront) {
                Rect rect = new Rect(BUTTON_POSITIONS[i].x, BUTTON_POSITIONS[i].y, BUTTON_SIZE, BUTTON_SIZE);
                if (point.in(rect)) {
                    return GameControllerButton.valueOf(i);
                }
            }
        }
        return GameControllerButton.Invalid;
    }

    GameControllerAxis findAxisAtPosition(int x, int y)
    {
        Point point;
        int i;
        boolean showing_front = showingFront();

        point = new Point(x, y);
        for (i = 0; i < GameControllerAxis.Max.value(); ++i) {
            if (showing_front) {
                Rect rect = new Rect(AXIS_POSITIONS[i].x, AXIS_POSITIONS[i].y, AXIS_SIZE, AXIS_SIZE);
                if (point.in(rect)) {
                    return GameControllerAxis.valueOf(i);
                }
            }
        }
        return GameControllerAxis.Invalid;
    }

    void virtualControllerMouseMotion(int x, int y)
    {
        if (virtualButtonActive != GameControllerButton.Invalid) {
            if (virtualAxisActive != GameControllerAxis.Invalid) {
                int MOVING_DISTANCE = 2;
                if (Math.abs(x - virtualAxisStartX) >= MOVING_DISTANCE ||
                    Math.abs(y - virtualAxisStartY) >= MOVING_DISTANCE) {
                    virtualJoystick.setVirtualButton(virtualButtonActive, GeneralInputStateDefinitions.Released);
                    virtualButtonActive = GameControllerButton.Invalid;
                }
            }
        }

        if (virtualAxisActive != GameControllerAxis.Invalid) {
            if (virtualAxisActive == GameControllerAxis.TriggerLeft ||
                virtualAxisActive == GameControllerAxis.TriggerRight) {
                int range = (Joystick.AXIS_MAX - Joystick.AXIS_MIN);
                float distance = Math.clamp(((float)y - virtualAxisStartY) / AXIS_SIZE, 0.0f, 1.0f);
                short value = (short)(Joystick.AXIS_MIN + (distance * range));
                virtualJoystick.setVirtualAxis(virtualAxisActive, value);
            } else {
                float distanceX = Math.clamp(((float)x - virtualAxisStartX) / AXIS_SIZE, -1.0f, 1.0f);
                float distanceY = Math.clamp(((float)y - virtualAxisStartY) / AXIS_SIZE, -1.0f, 1.0f);
                short valueX, valueY;

                if (distanceX >= 0) {
                    valueX = (short)(distanceX * Joystick.AXIS_MAX);
                } else {
                    valueX = (short)(distanceX * -Joystick.AXIS_MIN);
                }
                if (distanceY >= 0) {
                    valueY = (short)(distanceY * Joystick.AXIS_MAX);
                } else {
                    valueY = (short)(distanceY * -Joystick.AXIS_MIN);
                }
                virtualJoystick.setVirtualAxis(virtualAxisActive, valueX);
                virtualJoystick.setVirtualAxis(GameControllerAxis.valueOf(virtualAxisActive.value() + 1), valueY);
            }
        }
    }

    void virtualControllerMouseDown(int x, int y)
    {
        GameControllerButton button;
        GameControllerAxis axis;

        button = findButtonAtPosition(x, y);
        if (button != GameControllerButton.Invalid) {
            virtualButtonActive = button;
            virtualJoystick.setVirtualButton(virtualButtonActive, GeneralInputStateDefinitions.Pressed)
        }

        axis = findAxisAtPosition(x, y);
        if (axis != GameControllerAxis.Invalid) {
            virtualAxisActive = axis;
            virtualAxisStartX = x;
            virtualAxisStartY = y;
        }
    }

    void virtualControllerMouseUp(int x, int y)
    {
        if (virtualButtonActive != GameControllerButton.Invalid) {
            virtualJoystick.setVirtualButton(virtualButtonActive, GeneralInputStateDefinitions.Released);
            virtualButtonActive = GameControllerButton.Invalid;
        }

        if (virtualAxisActive != GameControllerAxis.Invalid) {
            if (virtualAxisActive == GameControllerAxis.TriggerLeft ||
                virtualAxisActive == GameControllerAxis.TriggerRight) {
                virtualJoystick.setVirtualAxis(virtualAxisActive, Joystick.AXIS_MIN);
            } else {
                virtualJoystick.setVirtualAxis(virtualAxisActive, (short) 0);
                virtualJoystick.setVirtualAxis(GameControllerAxis.valueOf(virtualAxisActive.value() + 1), (short) 0);
            }
            virtualAxisActive = GameControllerAxis.Invalid;
        }
    }

    void loop() throws InterruptedException {
        Event event;
        int i;
        boolean showingFront;

        /* Update to get the current event state */
        Event.pumpEvents();

        List<Event> events;
        /* Process all currently pending events */
        while ((events = Event.peepEvents(1, SDL_GETEVENT(), SDL_FIRSTEVENT(), SDL_LASTEVENT())).size() == 1) {
            event = events.getFirst();
            switch (event) {
                case ControllerDeviceAdded(int which) -> {
                    System.out.println(STR."Game controller device \{Joystick.getDeviceInstanceId(which)} added.");
                    addController(which, true);
                }
                case ControllerDeviceRemoved(JoystickId which) -> {
                    System.out.println(STR."Game controller device \{which} removed.");
                    delController(which);
                }
                case ControllerTouchpadDown(int which, int touchpad, int finger, float x, float y, float pressure) -> {
                    System.out.println(STR."Controller \{which} touchpad \{touchpad} finger \{finger} pressed at \{x}, \{y}, \{pressure}");
                }
                case ControllerTouchpadMotion(int which, int touchpad, int finger, float x, float y, float pressure) -> {
                    System.out.println(STR."Controller \{which} touchpad \{touchpad} finger \{finger} moved to \{x}, \{y}, \{pressure}");
                }
                case ControllerTouchpadUp(int which, int touchpad, int finger, float x, float y, float pressure) -> {
                    System.out.println(STR."Controller \{which} touchpad \{touchpad} finger \{finger} released at \{x}, \{y}, \{pressure}");
                }
                case ControllerSensorUpdate(int which, SensorType sensor, float[] data, long timestampUs) when VERBOSE_SENSORS -> {
                    System.out.println(FMT."Controller \{which} sensor \{getSensorName(sensor)}: %.2\{data[0]}, %.2\{data[1]}, %.2\{data[2]} (\"\{timestampUs}\")");
                }
                case ControllerAxisMotion controllerAxisMotion when VERBOSE_AXES -> {
                    if (event.caxis.value <= (-SDL_JOYSTICK_AXIS_MAX / 2) || event.caxis.value >= (SDL_JOYSTICK_AXIS_MAX / 2)) {
                        setController(event.caxis.which);
                    }
                    System.out.printf("Controller %" SDL_PRIs32 " axis %s changed to %d\n", event.caxis.which, SDL_GameControllerGetStringForAxis((SDL_GameControllerAxis)event.caxis.axis), event.caxis.value);
                }
                case ControllerButtonDown controllerButtonDown -> {
                }
                case ControllerButtonUp controllerButtonUp -> {
                }
            }

            case SDL_CONTROLLERBUTTONDOWN:
            case SDL_CONTROLLERBUTTONUP:
                if (event.type == SDL_CONTROLLERBUTTONDOWN) {
                    setController(event.cbutton.which);
                }
                SDL_Log("Controller %" SDL_PRIs32 " button %s %s\n", event.cbutton.which, SDL_GameControllerGetStringForButton((SDL_GameControllerButton)event.cbutton.button), event.cbutton.state ? "pressed" : "released");

                /* Cycle PS5 trigger effects when the microphone button is pressed */
                if (event.type == SDL_CONTROLLERBUTTONDOWN &&
                    event.cbutton.button == SDL_CONTROLLER_BUTTON_MISC1 &&
                    SDL_GameControllerGetType(gameController) == SDL_CONTROLLER_TYPE_PS5) {
                    cyclePS5TriggerEffect();
                }
                break;

            case SDL_JOYBATTERYUPDATED:
                SDL_Log("Controller %" SDL_PRIs32 " battery state changed to %s\n", event.jbattery.which, POWER_LEVEL_STRINGS[event.jbattery.level + 1]);
                break;

            case MouseButtonDown mouseButtonDown:
                if (virtualJoystick != null) {
                    virtualControllerMouseDown(mouseButtonDown.x(), mouseButtonDown.y());
                }
                break;

            case MouseButtonUp mouseButtonUp:
                if (virtualJoystick != null) {
                    virtualControllerMouseUp(mouseButtonUp.x(), mouseButtonUp.y());
                }
                break;

            case MouseMotion mouseMotion:
                if (virtualJoystick != null) {
                    virtualControllerMouseMotion(mouseMotion.x(), mouseMotion.y());
                }
                break;

            case KeyDown keyDown:
                if (event.key.keysym.sym >= SDLK_0 && event.key.keysym.sym <= SDLK_9) {
                    if (gameController) {
                        int player_index = (event.key.keysym.sym - SDLK_0);

                        SDL_GameControllerSetPlayerIndex(gameController, player_index);
                    }
                    break;
                }
                if (event.key.keysym.sym == SDLK_a) {
                    openVirtualController();
                    break;
                }
                if (event.key.keysym.sym == SDLK_d) {
                    closeVirtualController();
                    break;
                }
                if (event.key.keysym.sym != SDLK_ESCAPE) {
                    break;
                }
                SDL_FALLTHROUGH;
            case Quit quit:
                done = true;
                break;
            default:
                break;
        }

        showingFront = showingFront();

        /* blank screen, set up for drawing this frame. */
        screen.setDrawColor((byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) SDL_ALPHA_OPAQUE());
        screen.clear();
        screen.copy(showingFront ? backgroundFront : backgroundBack, null, null);

        if (gameController != null) {
            /* Update visual controller state */
            for (i = 0; i < GameControllerButton.Touchpad.value(); ++i) {
                if (gameController.getButton(GameControllerButton.valueOf(i)) == GeneralInputStateDefinitions.Pressed) {
                    boolean onFront = (i < GameControllerButton.Paddle1.value() || i > GameControllerButton.Paddle4.value());
                    if (onFront == showingFront) {
                        Rect dst = new Rect(BUTTON_POSITIONS[i].x, BUTTON_POSITIONS[i].y, BUTTON_SIZE, BUTTON_SIZE);
                        screen.copy(buttonTexture, null, dst, 0, null, RendererFlip.FlipNone);
                    }
                }
            }

            if (showingFront) {
                for (i = 0; i < GameControllerAxis.Max.value(); ++i) {
                    short deadzone = 8000; /* !!! FIXME: real deadzone */
                    short value = gameController.getAxis(GameControllerAxis.valueOf(i));
                    if (value < -deadzone) {
                        double angle = AXIS_POSITIONS[i].angle;
                        Rect dst = new Rect(AXIS_POSITIONS[i].x, AXIS_POSITIONS[i].y, AXIS_SIZE, AXIS_SIZE);
                        screen.copy(axisTexture, null, dst, angle, null, RendererFlip.FlipNone);
                    } else if (value > deadzone) {
                        double angle = AXIS_POSITIONS[i].angle + 180.0;
                        Rect dst = new Rect(AXIS_POSITIONS[i].x, AXIS_POSITIONS[i].y, AXIS_SIZE, AXIS_SIZE);
                        screen.copy(axisTexture, null, dst, angle, null, RendererFlip.FlipNone);
                    }
                }
            }

            /* Update LED based on left thumbstick position */
            {
                short x = gameController.getAxis(GameControllerAxis.LeftX);
                short y = gameController.getAxis(GameControllerAxis.LeftY);

                if (!set_LED) {
                    set_LED = (x < -8000 || x > 8000 || y > 8000);
                }
                if (set_LED) {
                    byte r, g, b;

                    if (x < 0) {
                        r = (byte)(((~x) * 255) / 32767);
                        b = 0;
                    } else {
                        r = 0;
                        b = (byte)(((int)(x)*255) / 32767);
                    }
                    if (y > 0) {
                        g = (byte)(((int)(y)*255) / 32767);
                    } else {
                        g = 0;
                    }

                    gameController.setLed(r, g, b);
                }
            }

            if (triggerEffect == 0) {
                /* Update rumble based on trigger state */
                {
                    short left = gameController.getAxis(GameControllerAxis.TriggerLeft);
                    short right = gameController.getAxis(GameControllerAxis.TriggerRight);
                    short lowFrequencyRumble = convertAxisToRumble(left);
                    short highFrequencyRumble = convertAxisToRumble(right);
                    gameController.rumble(lowFrequencyRumble, highFrequencyRumble, Duration.ofMillis(250));
                }

                /* Update trigger rumble based on thumbstick state */
                {
                    short left = gameController.getAxis(GameControllerAxis.LeftY);
                    short right = gameController.getAxis(GameControllerAxis.RightY);
                    short leftRumble = convertAxisToRumble((short) ~left);
                    short rightRumble = convertAxisToRumble((short) ~right);

                    gameController.rumbleTriggers(leftRumble, rightRumble, Duration.ofMillis(250));
                }
            }
        }
        Thread.sleep(Duration.ofMillis(16));
        // SDL_Delay(16);
        // SDL_RenderPresent(screen);
        screen.present();
    }

    public static void main(String[] args) {
        new TestGameController().main(args);
    }
    public void main(String[] args) throws InterruptedException {
        int i;
        int controllerCount = 0;
        int controllerIndex = 0;
        String guid;

        Hints.setHint(Hints.HINT_ACCELEROMETER_AS_JOYSTICK, "0");
        Hints.setHint(Hints.HINT_JOYSTICK_HIDAPI_PS4_RUMBLE, "1");
        Hints.setHint(Hints.HINT_JOYSTICK_HIDAPI_PS5_RUMBLE, "1");
        Hints.setHint(Hints.HINT_JOYSTICK_HIDAPI_STEAM, "1");
        Hints.setHint(Hints.HINT_JOYSTICK_ROG_CHAKRAM, "1");
        Hints.setHint(Hints.HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS, "1");
        Hints.setHint(Hints.HINT_LINUX_JOYSTICK_DEADZONES, "1");

        /* Enable standard application logging */
        SDL_LogSetPriority(SDL_LOG_CATEGORY_APPLICATION, SDL_LOG_PRIORITY_INFO);

        /* Initialize SDL (Note: video is required to start event loop) */
        Sdl.init(SDL_INIT_VIDEO() | SDL_INIT_JOYSTICK() | SDL_INIT_GAMECONTROLLER());

        GameController.addMappingsFromFile("gameControllerdb.txt");

        /* Print information about the mappings */
        if (argv[1] && SDL_strcmp(argv[1], "--mappings") == 0) {
            SDL_Log("Supported mappings:\n");
            for (i = 0; i < GameController.numMappings(); ++i) {
                String mapping = GameController.mappingForIndex(i);
                if (mapping != null) {
                    SDL_Log("\t%s\n", mapping);
                }
            }
            SDL_Log("\n");
        }

        /* Print information about the controller */
        for (i = 0; i < Joystick.numJoysticks(); ++i) {
            String name;
            String path;
            String description;

            guid = Joystick.getDeviceGUIDString(i);

            if (GameController.isGameController(i)) {
                controllerCount++;
                name = GameController.nameForIndex(i);
                path = GameController.pathForIndex(i);
                description = switch (GameController.typeForIndex(i)) {
                    case GameControllerType.AmazonLuna -> "Amazon Luna Controller";
                    case GameControllerType.GoogleStadia -> "Google Stadia Controller";
                    case GameControllerType.NintendoSwitchJoyconLeft, GameControllerType.NintendoSwitchJoyconRight, GameControllerType.NintendoSwitchJoyconPair ->
                            "Nintendo Switch Joy-Con";
                    case GameControllerType.NintendoSwitchPro -> "Nintendo Switch Pro Controller";
                    case GameControllerType.PS3 -> "PS3 Controller";
                    case GameControllerType.PS4 -> "PS4 Controller";
                    case GameControllerType.PS5 -> "PS5 Controller";
                    case GameControllerType.XBox360 -> "XBox 360 Controller";
                    case GameControllerType.XBoxOne -> "XBox One Controller";
                    case GameControllerType.Virtual -> "Virtual Game Controller";
                    default -> "Game Controller";
                };
                addController(i, false);
            } else {
                name = GameController.nameForIndex(i);
                path = GameController.pathForIndex(i);
                description = "Joystick";
            }
            SDL_Log("%s %d: %s%s%s (guid %s, VID 0x%.4x, PID 0x%.4x, player index = %d)\n",
                    description, i, name ? name : "Unknown", path ? ", " : "", path ? path : "", guid,
                    SDL_JoystickGetDeviceVendor(i), SDL_JoystickGetDeviceProduct(i), SDL_JoystickGetDevicePlayerIndex(i));
        }
        SDL_Log("There are %d game controller(s) attached (%d joystick(s))\n", controllerCount, SDL_NumJoysticks());

        /* Create a window to display controller state */
        window = Window.create("Game Controller Test", SDL_WINDOWPOS_CENTERED(),
                SDL_WINDOWPOS_CENTERED(), SCREEN_WIDTH,
                SCREEN_HEIGHT, 0);
        // if (window == NULL) {
        //     SDL_LogError(SDL_LOG_CATEGORY_APPLICATION, "Couldn't create window: %s\n", SDL_GetError());
        //     return 2;
        // }

        screen = Renderer.create(window, -1, 0);

        screen.setDrawColor((byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) SDL_ALPHA_OPAQUE());
        screen.clear();
        screen.present();

        /* scale for platforms that don't give you the window size you asked for. */
        screen.setLogicalSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        backgroundFront = loadTexture(screen, "controllermap.bmp", false).texture();
        backgroundBack = loadTexture(screen, "controllermap_back.bmp", false).texture();
        buttonTexture = loadTexture(screen, "button.bmp", true).texture();
        axisTexture = loadTexture(screen, "axis.bmp", true).texture();

        if (backgroundFront == null || backgroundBack == null || buttonTexture == null || axisTexture == null) {
            screen.destroy();
            window.destroy();
            System.exit(2);
        }
        buttonTexture.setColorMod((byte) 10, (byte) 255, (byte) 21);
        axisTexture.setColorMod((byte) 10, (byte) 255, (byte) 21);

        /* !!! FIXME: */
        /*SDL_RenderSetLogicalSize(screen, background->w, background->h);*/

        for (i = 1; i < args.length; ++i) {
            if (args[i].equals("--virtual")) {
                openVirtualController();
            }
            // todo: this logic would allow follow thru?!?
            // if (args[i] != "-") {
            //     controllerIndex = SDL_atoi(argv[i]);
            //     break;
            // }
        }
        if (controllerIndex < gameControllers.size()) {
            gameController = gameControllers.get(controllerIndex);
        } else {
            gameController = null;
        }
        updateWindowTitle();

        while (!done) {
            loop();
        }

        /* Reset trigger state */
        if (triggerEffect != 0) {
            triggerEffect = -1;
            cyclePS5TriggerEffect();
        }

        closeVirtualController();
        screen.destroy();
        window.destroy();
        Sdl.quitSubSystem(SDL_INIT_VIDEO() | SDL_INIT_JOYSTICK() | SDL_INIT_GAMECONTROLLER());
    }

    private static void SDL_Log(String format, Object... args) {
        System.out.printf(format, args);
    }
}
