package sdl;

import sdl.events.GeneralInputStateDefinitions;
import sdl.events.controllerdevice.ControllerDeviceAdded;
import sdl.events.controllerdevice.ControllerDeviceRemoved;
import sdl.events.Event;
import sdl.events.controllersensor.ControllerSensorUpdate;
import sdl.events.controllertouchpad.ControllerTouchpadDown;
import sdl.events.controllertouchpad.ControllerTouchpadMotion;
import sdl.events.controllertouchpad.ControllerTouchpadUp;
import sdl.gamecontroller.GameController;
import sdl.gamecontroller.JoystickId;
import sdl.gamecontroller.SensorType;
import sdl.jextract.DS5EffectsState_t;
import sdl.joystick.Joystick;
import sdl.render.Renderer;
import sdl.video.Window;

import java.util.Set;

import static sdl.jextract.SDL_subset_h.SDL_ALPHA_OPAQUE;

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
public static class TestGameController {

    private static final boolean VERBOSE_SENSORS = false;
    private static final boolean VERBOSE_AXES = false;

    private static final int SCREEN_WIDTH = 512;
    private static final int SCREEN_HEIGHT = 320;

    private static final int BUTTON_SIZE = 50;
    private static final int AXIS_SIZE = 50;

    /* This is indexed by SDL_GameControllerButton. */
    static const struct
    {
        int x;
        int y;
    } button_positions[] = {
        { 387, 167 }, /* SDL_CONTROLLER_BUTTON_A */
        { 431, 132 }, /* SDL_CONTROLLER_BUTTON_B */
        { 342, 132 }, /* SDL_CONTROLLER_BUTTON_X */
        { 389, 101 }, /* SDL_CONTROLLER_BUTTON_Y */
        { 174, 132 }, /* SDL_CONTROLLER_BUTTON_BACK */
        { 232, 128 }, /* SDL_CONTROLLER_BUTTON_GUIDE */
        { 289, 132 }, /* SDL_CONTROLLER_BUTTON_START */
        { 75, 154 },  /* SDL_CONTROLLER_BUTTON_LEFTSTICK */
        { 305, 230 }, /* SDL_CONTROLLER_BUTTON_RIGHTSTICK */
        { 77, 40 },   /* SDL_CONTROLLER_BUTTON_LEFTSHOULDER */
        { 396, 36 },  /* SDL_CONTROLLER_BUTTON_RIGHTSHOULDER */
        { 154, 188 }, /* SDL_CONTROLLER_BUTTON_DPAD_UP */
        { 154, 249 }, /* SDL_CONTROLLER_BUTTON_DPAD_DOWN */
        { 116, 217 }, /* SDL_CONTROLLER_BUTTON_DPAD_LEFT */
        { 186, 217 }, /* SDL_CONTROLLER_BUTTON_DPAD_RIGHT */
        { 232, 174 }, /* SDL_CONTROLLER_BUTTON_MISC1 */
        { 132, 135 }, /* SDL_CONTROLLER_BUTTON_PADDLE1 */
        { 330, 135 }, /* SDL_CONTROLLER_BUTTON_PADDLE2 */
        { 132, 175 }, /* SDL_CONTROLLER_BUTTON_PADDLE3 */
        { 330, 175 }, /* SDL_CONTROLLER_BUTTON_PADDLE4 */
        { 0, 0 },     /* SDL_CONTROLLER_BUTTON_TOUCHPAD */
    };
    SDL_COMPILE_TIME_ASSERT(button_positions, SDL_arraysize(button_positions) == SDL_CONTROLLER_BUTTON_MAX);

    /* This is indexed by SDL_GameControllerAxis. */
    static const struct
    {
        int x;
        int y;
        double angle;
    } axis_positions[] = {
        { 74, 153, 270.0 },  /* LEFTX */
        { 74, 153, 0.0 },    /* LEFTY */
        { 306, 231, 270.0 }, /* RIGHTX */
        { 306, 231, 0.0 },   /* RIGHTY */
        { 91, -20, 0.0 },    /* TRIGGERLEFT */
        { 375, -20, 0.0 },   /* TRIGGERRIGHT */
    };
    SDL_COMPILE_TIME_ASSERT(axis_positions, SDL_arraysize(axis_positions) == SDL_CONTROLLER_AXIS_MAX);

    /* This is indexed by SDL_JoystickPowerLevel + 1. */
    static const char *power_level_strings[] = {
        "unknown", /* SDL_JOYSTICK_POWER_UNKNOWN */
                "empty",   /* SDL_JOYSTICK_POWER_EMPTY */
                "low",     /* SDL_JOYSTICK_POWER_LOW */
                "medium",  /* SDL_JOYSTICK_POWER_MEDIUM */
                "full",    /* SDL_JOYSTICK_POWER_FULL */
                "wired",   /* SDL_JOYSTICK_POWER_WIRED */
    };
    SDL_COMPILE_TIME_ASSERT(power_level_strings, SDL_arraysize(power_level_strings) == SDL_JOYSTICK_POWER_MAX + 1);

    private Window window = null;
    private Renderer screen = null;
    private boolean retval = false;
    private boolean done = false;
    private boolean set_LED = false;
    static int trigger_effect = 0;
    static Texture background_front, background_back, button_texture, axis_texture;
    private GameController gameController;
    private GameController[] gameControllers;
    private int numControllers = 0;
    private Joystick virtualJoystick = NULL;
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
        // const char *name = SDL_GameControllerName(gameController);
        // const char *serial = SDL_GameControllerGetSerial(gameController);
        // const char *basetitle = "Game Controller Test: ";
        const size_t titlelen = SDL_strlen(basetitle) + (name ? SDL_strlen(name) : 0) + (serial ? 3 + SDL_strlen(serial) : 0) + 1;
            char *title = (char *)SDL_malloc(titlelen);

            retval = false;
            done = false;

            if (title) {
                SDL_strlcpy(title, basetitle, titlelen);
                if (name) {
                    SDL_strlcat(title, name, titlelen);
                }
                if (serial) {
                    SDL_strlcat(title, " (", titlelen);
                    SDL_strlcat(title, serial, titlelen);
                    SDL_strlcat(title, ")", titlelen);
                }
                SDL_SetWindowTitle(window, title);
                SDL_free(title);
            }
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

        for (i = 0; i < numControllers; ++i) {
            gameControllers[i].getJoystick();
            if (controller_id.equals(gameControllers[i].getJoystick().instanceId())) {
                return i;
            }
        }
        return -1;
    }

    void addController(int deviceIndex, boolean verbose)
    {
        JoystickId controllerId = Joystick.getDeviceInstanceId(deviceIndex);
        //SDL_JoystickID controller_id = SDL_JoystickGetDeviceInstanceID(device_index);
        GameController controller;
        GameController[] controllers;
        short firmware_version;
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

        controllers = (SDL_GameController **)SDL_realloc(gameControllers, (numControllers + 1) * sizeof( * controllers));
        if (controllers == NULL) {
            controller.close();
            return;
        }

        controllers[numControllers++] = controller;
        gameControllers = controllers;
        gameController = controller;
        trigger_effect = 0;

        if (verbose) {
            String name = gameController.name();
            String path = gameController.path();
            SDL_Log("Opened game controller %s%s%s\n", name, path ? ", " : "", path ? path : "");
        }

        firmware_version = gameController.getFirmwareVersion();
        if (firmware_version > 0) {
            if (verbose) {
                SDL_Log("Firmware version: 0x%x (%d)\n", firmware_version, firmware_version);
            }
        }

        for (var sensor : sensors) {
            if (gameController.hasSensor(sensor)) {
                if (verbose) {
                    SDL_Log("Enabling %s at %.2f Hz\n", getSensorName(sensor), gameController.getSensorDataRate(sensor));
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

    void SetController(JoystickId controller)
    {
        int i = findController(controller);

        if (i < 0) {
            return;
        }

        if (gameController != gameControllers[i]) {
            gameController = gameControllers[i];
            updateWindowTitle();
        }
    }

    void delController(JoystickId controller)
    {
        int i = findController(controller);

        if (i < 0) {
            return;
        }

        gameControllers[i].close();

        --numControllers;
        if (i < numControllers) {
            SDL_memcpy(&gameControllers[i], &gameControllers[i + 1], (numControllers - i) * sizeof( * gameControllers));
        }

        if (numControllers > 0) {
            gameController = gameControllers[0];
        } else {
            gameController = null;
        }
        updateWindowTitle();
    }

    short convertAxisToRumble(short axisval)
    {
        /* Only start rumbling if the axis is past the halfway point */
    const short half_axis = (short)SDL_ceil(SDL_JOYSTICK_AXIS_MAX / 2.0f);
        if (axisval > half_axis) {
            return (Uint16)(axisval - half_axis) * 4;
        } else {
            return 0;
        }
    }

    /* PS5 trigger effect documentation:
       https://controllers.fandom.com/wiki/Sony_DualSense#FFB_Trigger_Modes
    */
    typedef struct
    {
        Uint8 ucEnableBits1;              /* 0 */
        Uint8 ucEnableBits2;              /* 1 */
        Uint8 ucRumbleRight;              /* 2 */
        Uint8 ucRumbleLeft;               /* 3 */
        Uint8 ucHeadphoneVolume;          /* 4 */
        Uint8 ucSpeakerVolume;            /* 5 */
        Uint8 ucMicrophoneVolume;         /* 6 */
        Uint8 ucAudioEnableBits;          /* 7 */
        Uint8 ucMicLightMode;             /* 8 */
        Uint8 ucAudioMuteBits;            /* 9 */
        Uint8 rgucRightTriggerEffect[11]; /* 10 */
        Uint8 rgucLeftTriggerEffect[11];  /* 21 */
        Uint8 rgucUnknown1[6];            /* 32 */
        Uint8 ucLedFlags;                 /* 38 */
        Uint8 rgucUnknown2[2];            /* 39 */
        Uint8 ucLedAnim;                  /* 41 */
        Uint8 ucLedBrightness;            /* 42 */
        Uint8 ucPadLights;                /* 43 */
        Uint8 ucLedRed;                   /* 44 */
        Uint8 ucLedGreen;                 /* 45 */
        Uint8 ucLedBlue;                  /* 46 */
    } DS5EffectsState_t;

    void cyclePS5TriggerEffect()
    {
        DS5EffectsState_t state;

        Uint8 effects[3][11] = {
        /* Clear trigger effect */
        { 0x05, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        /* Constant resistance across entire trigger pull */
        { 0x01, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0 },
        /* Resistance and vibration when trigger is pulled */
        { 0x06, 15, 63, 128, 0, 0, 0, 0, 0, 0, 0 },
    };

        trigger_effect = (trigger_effect + 1) % SDL_arraysize(effects);

        SDL_zero(state);
        state.ucEnableBits1 |= (0x04 | 0x08); /* Modify right and left trigger effect respectively */
        SDL_memcpy(state.rgucRightTriggerEffect, effects[trigger_effect], sizeof(effects[trigger_effect]));
        SDL_memcpy(state.rgucLeftTriggerEffect, effects[trigger_effect], sizeof(effects[trigger_effect]));
        SDL_GameControllerSendEffect(gameController, &state, sizeof(state));
        gameController.sendEffect();
    }

    boolean showingFront()
    {
        boolean showingFront = true;
        int i;

        if (gameController != null) {
            /* Show the back of the controller if the paddles are being held */
            for (i = SDL_CONTROLLER_BUTTON_PADDLE1; i <= SDL_CONTROLLER_BUTTON_PADDLE4; ++i) {
                // if (SDL_GameControllerGetButton(gameController, (SDL_GameControllerButton)i) == SDL_PRESSED) {
                //     showingFront = false;
                //     break;
                // }
                if (gameController.getButton(i) == GeneralInputStateDefinitions.Pressed) {
                    showingFront = false;
                    break;
                }

            }
        }
        if ((SDL_GetModState() & KMOD_SHIFT) != 0) {
            showingFront = false;
        }
        return showingFront;
    }

    static void SDLCALL VirtualControllerSetPlayerIndex(void *userdata, int player_index)
    {
        SDL_Log("Virtual Controller: player index set to %d\n", player_index);
    }

    static int SDLCALL VirtualControllerRumble(void *userdata, Uint16 low_frequency_rumble, Uint16 high_frequency_rumble)
    {
        SDL_Log("Virtual Controller: rumble set to %d/%d\n", low_frequency_rumble, high_frequency_rumble);
        return 0;
    }

    static int SDLCALL VirtualControllerRumbleTriggers(void *userdata, Uint16 left_rumble, Uint16 right_rumble)
    {
        SDL_Log("Virtual Controller: trigger rumble set to %d/%d\n", left_rumble, right_rumble);
        return 0;
    }

    static int SDLCALL VirtualControllerSetLED(void *userdata, Uint8 red, Uint8 green, Uint8 blue)
    {
        SDL_Log("Virtual Controller: LED set to RGB %d,%d,%d\n", red, green, blue);
        return 0;
    }

    void openVirtualController()
    {
        SDL_VirtualJoystickDesc desc;
        int virtual_index;

        SDL_zero(desc);
        desc.version = SDL_VIRTUAL_JOYSTICK_DESC_VERSION;
        desc.type = SDL_JOYSTICK_TYPE_GAMECONTROLLER;
        desc.naxes = SDL_CONTROLLER_AXIS_MAX;
        desc.nbuttons = SDL_CONTROLLER_BUTTON_MAX;
        desc.SetPlayerIndex = VirtualControllerSetPlayerIndex;
        desc.Rumble = VirtualControllerRumble;
        desc.RumbleTriggers = VirtualControllerRumbleTriggers;
        desc.SetLED = VirtualControllerSetLED;

        virtual_index = SDL_JoystickAttachVirtualEx(&desc);
        if (virtual_index < 0) {
            SDL_Log("Couldn't open virtual device: %s\n", SDL_GetError());
        } else {
            virtualJoystick = SDL_JoystickOpen(virtual_index);
            if (virtualJoystick == NULL) {
                SDL_Log("Couldn't open virtual device: %s\n", SDL_GetError());
            }
        }
    }

    void closeVirtualController()
    {
        int i;

        for (i = SDL_NumJoysticks(); i--;) {
            if (SDL_JoystickIsVirtual(i)) {
                SDL_JoystickDetachVirtual(i);
            }
        }

        if (virtualJoystick) {
            SDL_JoystickClose(virtualJoystick);
            virtualJoystick = NULL;
        }
    }

    GameControllerButton findButtonAtPosition(int x, int y)
    {
        Point point;
        int i;
        boolean showingFront = showingFront();

        point.x = x;
        point.y = y;
        for (i = 0; i < SDL_CONTROLLER_BUTTON_TOUCHPAD; ++i) {
            boolean onFront = (i < SDL_CONTROLLER_BUTTON_PADDLE1 || i > SDL_CONTROLLER_BUTTON_PADDLE4);
            if (onFront == showingFront) {
                Rect rect = new Rect(button_positions[i].x, button_positions[i].y, BUTTON_SIZE, BUTTON_SIZE);
                if (SDL_PointInRect(&point, &rect)) {
                    return (SDL_GameControllerButton)i;
                    return GameControllerButton.valueOf(i);
                }
            }
        }
        return SDL_CONTROLLER_BUTTON_INVALID;
    }

    GameControllerAxis findAxisAtPosition(int x, int y)
    {
        Point point;
        int i;
        boolean showing_front = showingFront();

        point.x = x;
        point.y = y;
        for (i = 0; i < GameControllerAxis.Max.value(); ++i) {
            if (showing_front) {
                SDL_Rect rect;
                rect.x = axis_positions[i].x;
                rect.y = axis_positions[i].y;
                rect.w = AXIS_SIZE;
                rect.h = AXIS_SIZE;
                if (SDL_PointInRect(&point, &rect)) {
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
            if (virtualAxisActive == SDL_CONTROLLER_AXIS_TRIGGERLEFT ||
                virtualAxisActive == SDL_CONTROLLER_AXIS_TRIGGERRIGHT) {
                int range = (SDL_JOYSTICK_AXIS_MAX - SDL_JOYSTICK_AXIS_MIN);
                float distance = SDL_clamp(((float)y - virtualAxisStartY) / AXIS_SIZE, 0.0f, 1.0f);
                short value = (short)(SDL_JOYSTICK_AXIS_MIN + (distance * range));
                virtualJoystick.setVirtualAxis(virtualAxisActive, value);
            } else {
                float distanceX = SDL_clamp(((float)x - virtualAxisStartX) / AXIS_SIZE, -1.0f, 1.0f);
                float distanceY = SDL_clamp(((float)y - virtualAxisStartY) / AXIS_SIZE, -1.0f, 1.0f);
                short valueX, valueY;

                if (distanceX >= 0) {
                    valueX = (short)(distanceX * SDL_JOYSTICK_AXIS_MAX);
                } else {
                    valueX = (short)(distanceX * -SDL_JOYSTICK_AXIS_MIN);
                }
                if (distanceY >= 0) {
                    valueY = (short)(distanceY * SDL_JOYSTICK_AXIS_MAX);
                } else {
                    valueY = (short)(distanceY * -SDL_JOYSTICK_AXIS_MIN);
                }
                SDL_JoystickSetVirtualAxis(virtualJoystick, virtualAxisActive, valueX);
                SDL_JoystickSetVirtualAxis(virtualJoystick, virtualAxisActive + 1, valueY);
            }
        }
    }

    static void VirtualControllerMouseDown(int x, int y)
    {
        SDL_GameControllerButton button;
        SDL_GameControllerAxis axis;

        button = findButtonAtPosition(x, y);
        if (button != SDL_CONTROLLER_BUTTON_INVALID) {
            virtualButtonActive = button;
            SDL_JoystickSetVirtualButton(virtualJoystick, virtualButtonActive, SDL_PRESSED);
        }

        axis = findAxisAtPosition(x, y);
        if (axis != SDL_CONTROLLER_AXIS_INVALID) {
            virtualAxisActive = axis;
            virtualAxisStartX = x;
            virtualAxisStartY = y;
        }
    }

    static void VirtualControllerMouseUp(int x, int y)
    {
        if (virtualButtonActive != SDL_CONTROLLER_BUTTON_INVALID) {
            SDL_JoystickSetVirtualButton(virtualJoystick, virtualButtonActive, SDL_RELEASED);
            virtualButtonActive = SDL_CONTROLLER_BUTTON_INVALID;
        }

        if (virtualAxisActive != SDL_CONTROLLER_AXIS_INVALID) {
            if (virtualAxisActive == SDL_CONTROLLER_AXIS_TRIGGERLEFT ||
                virtualAxisActive == SDL_CONTROLLER_AXIS_TRIGGERRIGHT) {
                virtualJoystick.setVirtualAxis(virtualAxisActive, Joystick.AXIS_MIN);
            } else {
                virtualJoystick.setVirtualAxis(virtualAxisActive, 0);
                virtualJoystick.setVirtualAxis(GameControllerAxis.valueOf(virtualAxisActive.value() + 1), 0);
            }
            virtualAxisActive = GameControllerAxis.Invalid;
        }
    }

    void loop()
    {
        Event event;
        int i;
        boolean showingFront;

        /* Update to get the current event state */
        Event.pumpEvents();

        /* Process all currently pending events */
        while (SDL_PeepEvents(&event, 1, SDL_GETEVENT, SDL_FIRSTEVENT, SDL_LASTEVENT) == 1) {
            switch(event) {
                case ControllerDeviceAdded controllerDeviceAdded -> {
                    System.out.printf("Game controller device %s added.\n", Joystick.getDeviceInstanceId(controllerDeviceAdded.which()).toString());
                    addController(controllerDeviceAdded.which(), true);
                }
                case ControllerDeviceRemoved controllerDeviceRemoved -> {
                    System.out.printf("Game controller device %s removed.\n", controllerDeviceRemoved.which());
                    delController(controllerDeviceRemoved.which());
                }
                case ControllerTouchpadDown controllerTouchpadDown -> {
                    System.out.printf("Controller %" SDL_PRIs32 " touchpad %" SDL_PRIs32 " finger %" SDL_PRIs32 " %s %.2f, %.2f, %.2f\n",
                            controllerTouchpadDown.which(),
                            controllerTouchpadDown.touchpad(),
                            controllerTouchpadDown.finger(),
                            "pressed at",
                            controllerTouchpadDown.x(),
                            controllerTouchpadDown.y(),
                            controllerTouchpadDown.pressure());
                }
                case ControllerTouchpadMotion controllerTouchpadMotion -> {
                    System.out.printf("Controller %" SDL_PRIs32 " touchpad %" SDL_PRIs32 " finger %" SDL_PRIs32 " %s %.2f, %.2f, %.2f\n",
                            controllerTouchpadMotion.which(),
                            controllerTouchpadMotion.touchpad(),
                            controllerTouchpadMotion.finger(),
                            "moved to",
                            controllerTouchpadMotion.x(),
                            controllerTouchpadMotion.y(),
                            controllerTouchpadMotion.pressure());
                }
                case ControllerTouchpadUp controllerTouchpadUp -> {
                    System.out.printf("Controller %" SDL_PRIs32 " touchpad %" SDL_PRIs32 " finger %" SDL_PRIs32 " %s %.2f, %.2f, %.2f\n",
                            controllerTouchpadUp.which(),
                            controllerTouchpadUp.touchpad(),
                            controllerTouchpadUp.finger(),
                            "released at",
                            controllerTouchpadUp.x(),
                            controllerTouchpadUp.y(),
                            controllerTouchpadUp.pressure());
                }
                case ControllerSensorUpdate controllerSensorUpdate when VERBOSE_SENSORS -> {
                    System.out.printf("Controller %"SDL_PRIs32" sensor %s: %.2f, %.2f, %.2f (%"SDL_PRIu64")\n",
                            controllerSensorUpdate.which(),
                            GetSensorName((SDL_SensorType) event.csensor.sensor),
                            controllerSensorUpdate.data()[0],
                            controllerSensorUpdate.data()[1],
                            controllerSensorUpdate.data()[2],
                            controllerSensorUpdate.timestampUs());
                }
                case ControllerAxisMotion controllerAxisMotion when VERBOSE_AXES -> {
                    if (event.caxis.value <= (-SDL_JOYSTICK_AXIS_MAX / 2) || event.caxis.value >= (SDL_JOYSTICK_AXIS_MAX / 2)) {
                        SetController(event.caxis.which);
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
                    SetController(event.cbutton.which);
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
                SDL_Log("Controller %" SDL_PRIs32 " battery state changed to %s\n", event.jbattery.which, power_level_strings[event.jbattery.level + 1]);
                break;

            case SDL_MOUSEBUTTONDOWN:
                if (virtualJoystick) {
                    VirtualControllerMouseDown(event.button.x, event.button.y);
                }
                break;

            case SDL_MOUSEBUTTONUP:
                if (virtualJoystick) {
                    VirtualControllerMouseUp(event.button.x, event.button.y);
                }
                break;

            case SDL_MOUSEMOTION:
                if (virtualJoystick) {
                    virtualControllerMouseMotion(event.motion.x, event.motion.y);
                }
                break;

            case SDL_KEYDOWN:
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
            case SDL_QUIT:
                done = SDL_TRUE;
                break;
            default:
                break;
        }
    }

        showingFront = showingFront();

        /* blank screen, set up for drawing this frame. */
        SDL_SetRenderDrawColor(screen, 0xFF, 0xFF, 0xFF, SDL_ALPHA_OPAQUE);
        SDL_RenderClear(screen);
        SDL_RenderCopy(screen, showingFront ? background_front : background_back, NULL, NULL);

        if (gameController) {
            /* Update visual controller state */
            for (i = 0; i < SDL_CONTROLLER_BUTTON_TOUCHPAD; ++i) {
                if (SDL_GameControllerGetButton(gameController, (SDL_GameControllerButton)i) == SDL_PRESSED) {
                    SDL_bool on_front = (i < SDL_CONTROLLER_BUTTON_PADDLE1 || i > SDL_CONTROLLER_BUTTON_PADDLE4);
                    if (on_front == showingFront) {
                        SDL_Rect dst;
                        dst.x = button_positions[i].x;
                        dst.y = button_positions[i].y;
                        dst.w = BUTTON_SIZE;
                        dst.h = BUTTON_SIZE;
                        SDL_RenderCopyEx(screen, button_texture, NULL, &dst, 0, NULL, SDL_FLIP_NONE);
                    }
                }
            }

            if (showingFront) {
                for (i = 0; i < SDL_CONTROLLER_AXIS_MAX; ++i) {
                const short deadzone = 8000; /* !!! FIXME: real deadzone */
                const short value = SDL_GameControllerGetAxis(gameController, (SDL_GameControllerAxis)(i));
                    if (value < -deadzone) {
                    const double angle = axis_positions[i].angle;
                        SDL_Rect dst;
                        dst.x = axis_positions[i].x;
                        dst.y = axis_positions[i].y;
                        dst.w = AXIS_SIZE;
                        dst.h = AXIS_SIZE;
                        SDL_RenderCopyEx(screen, axis_texture, NULL, &dst, angle, NULL, SDL_FLIP_NONE);
                    } else if (value > deadzone) {
                    const double angle = axis_positions[i].angle + 180.0;
                        SDL_Rect dst;
                        dst.x = axis_positions[i].x;
                        dst.y = axis_positions[i].y;
                        dst.w = AXIS_SIZE;
                        dst.h = AXIS_SIZE;
                        SDL_RenderCopyEx(screen, axis_texture, NULL, &dst, angle, NULL, SDL_FLIP_NONE);
                    }
                }
            }

            /* Update LED based on left thumbstick position */
            {
                short x = SDL_GameControllerGetAxis(gameController, SDL_CONTROLLER_AXIS_LEFTX);
                short y = SDL_GameControllerGetAxis(gameController, SDL_CONTROLLER_AXIS_LEFTY);

                if (!set_LED) {
                    set_LED = (x < -8000 || x > 8000 || y > 8000);
                }
                if (set_LED) {
                    Uint8 r, g, b;

                    if (x < 0) {
                        r = (Uint8)(((~x) * 255) / 32767);
                        b = 0;
                    } else {
                        r = 0;
                        b = (Uint8)(((int)(x)*255) / 32767);
                    }
                    if (y > 0) {
                        g = (Uint8)(((int)(y)*255) / 32767);
                    } else {
                        g = 0;
                    }

                    SDL_GameControllerSetLED(gameController, r, g, b);
                }
            }

            if (trigger_effect == 0) {
                /* Update rumble based on trigger state */
                {
                    short left = SDL_GameControllerGetAxis(gameController, SDL_CONTROLLER_AXIS_TRIGGERLEFT);
                    short right = SDL_GameControllerGetAxis(gameController, SDL_CONTROLLER_AXIS_TRIGGERRIGHT);
                    Uint16 low_frequency_rumble = convertAxisToRumble(left);
                    Uint16 high_frequency_rumble = convertAxisToRumble(right);
                    SDL_GameControllerRumble(gameController, low_frequency_rumble, high_frequency_rumble, 250);
                }

                /* Update trigger rumble based on thumbstick state */
                {
                    short left = SDL_GameControllerGetAxis(gameController, SDL_CONTROLLER_AXIS_LEFTY);
                    short right = SDL_GameControllerGetAxis(gameController, SDL_CONTROLLER_AXIS_RIGHTY);
                    Uint16 left_rumble = convertAxisToRumble(~left);
                    Uint16 right_rumble = convertAxisToRumble(~right);

                    SDL_GameControllerRumbleTriggers(gameController, left_rumble, right_rumble, 250);
                }
            }
        }
        SDL_Delay(16);
        SDL_RenderPresent(screen);

#ifdef __EMSCRIPTEN__
        if (done) {
            emscripten_cancel_main_loop();
        }
#endif
    }

    public static void main(String[] args) {
        new TestGameController().main(args);
    }
    public void main(String[] args) {
        int i;
        int controller_count = 0;
        int controller_index = 0;
        String guid;

        SDL_SetHint(SDL_HINT_ACCELEROMETER_AS_JOYSTICK, "0");
        SDL_SetHint(SDL_HINT_JOYSTICK_HIDAPI_PS4_RUMBLE, "1");
        SDL_SetHint(SDL_HINT_JOYSTICK_HIDAPI_PS5_RUMBLE, "1");
        SDL_SetHint(SDL_HINT_JOYSTICK_HIDAPI_STEAM, "1");
        SDL_SetHint(SDL_HINT_JOYSTICK_ROG_CHAKRAM, "1");
        SDL_SetHint(SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS, "1");
        SDL_SetHint(SDL_HINT_LINUX_JOYSTICK_DEADZONES, "1");

        /* Enable standard application logging */
        SDL_LogSetPriority(SDL_LOG_CATEGORY_APPLICATION, SDL_LOG_PRIORITY_INFO);

        /* Initialize SDL (Note: video is required to start event loop) */
        if (SDL_Init(SDL_INIT_VIDEO | SDL_INIT_JOYSTICK | SDL_INIT_GAMECONTROLLER) < 0) {
            SDL_LogError(SDL_LOG_CATEGORY_APPLICATION, "Couldn't initialize SDL: %s\n", SDL_GetError());
            return 1;
        }

        SDL_GameControllerAddMappingsFromFile("gameControllerdb.txt");

        /* Print information about the mappings */
        if (argv[1] && SDL_strcmp(argv[1], "--mappings") == 0) {
            SDL_Log("Supported mappings:\n");
            for (i = 0; i < SDL_GameControllerNumMappings(); ++i) {
                char *mapping = SDL_GameControllerMappingForIndex(i);
                if (mapping) {
                    SDL_Log("\t%s\n", mapping);
                    SDL_free(mapping);
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
                controller_count++;
                name = GameController.nameForIndex(i);
                path = GameController.pathForIndex(i);
                description = switch (GameController.typeForIndex(i)) {
                    case AmazonLuna -> "Amazon Luna Controller";
                    case GoogleStadia -> "Google Stadia Controller";
                    case NintendoSwitchJoyconLeft, NintendoSwitchJoyconRight, NintendoSwitchJoyconPair ->
                            "Nintendo Switch Joy-Con";
                    case NintendoSwitchPro -> "Nintendo Switch Pro Controller";
                    case PS3 -> "PS3 Controller";
                    case PS4 -> "PS4 Controller";
                    case PS5 -> "PS5 Controller";
                    case XBox360 -> "XBox 360 Controller";
                    case XBoxOne -> "XBox One Controller";
                    case Virtual -> "Virtual Game Controller";
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
        SDL_Log("There are %d game controller(s) attached (%d joystick(s))\n", controller_count, SDL_NumJoysticks());

        /* Create a window to display controller state */
        window = Window.create("Game Controller Test", SDL_WINDOWPOS_CENTERED,
                SDL_WINDOWPOS_CENTERED, SCREEN_WIDTH,
                SCREEN_HEIGHT, 0);
        // if (window == NULL) {
        //     SDL_LogError(SDL_LOG_CATEGORY_APPLICATION, "Couldn't create window: %s\n", SDL_GetError());
        //     return 2;
        // }

        screen = Renderer.create(window, -1, 0);
        if (screen == NULL) {
            SDL_LogError(SDL_LOG_CATEGORY_APPLICATION, "Couldn't create renderer: %s\n", SDL_GetError());
            SDL_DestroyWindow(window);
            return 2;
        }

        SDL_SetRenderDrawColor(screen, 0x00, 0x00, 0x00, SDL_ALPHA_OPAQUE);
        screen.setDrawColor(0x00, 0x00, 0x00, SDL_ALPHA_OPAQUE());
        screen.clear();
        screen.present();
        SDL_RenderClear(screen);
        SDL_RenderPresent(screen);

        /* scale for platforms that don't give you the window size you asked for. */
        screen.setLogicalSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        background_front = LoadTexture(screen, "controllermap.bmp", SDL_FALSE, NULL, NULL);
        background_back = LoadTexture(screen, "controllermap_back.bmp", SDL_FALSE, NULL, NULL);
        button_texture = LoadTexture(screen, "button.bmp", SDL_TRUE, NULL, NULL);
        axis_texture = LoadTexture(screen, "axis.bmp", SDL_TRUE, NULL, NULL);

        if (background_front == NULL || background_back == NULL || button_texture == NULL || axis_texture == NULL) {
            SDL_DestroyRenderer(screen);
            SDL_DestroyWindow(window);
            return 2;
        }
        SDL_SetTextureColorMod(button_texture, 10, 255, 21);
        SDL_SetTextureColorMod(axis_texture, 10, 255, 21);

        /* !!! FIXME: */
        /*SDL_RenderSetLogicalSize(screen, background->w, background->h);*/

        for (i = 1; i < argc; ++i) {
            if (SDL_strcmp(argv[i], "--virtual") == 0) {
                OpenVirtualController();
            }
            if (argv[i] && *argv[i] != '-') {
                controller_index = SDL_atoi(argv[i]);
                break;
            }
        }
        if (controller_index < numControllers) {
            gameController = gameControllers[controller_index];
        } else {
            gameController = NULL;
        }
        updateWindowTitle();

        while (!done) {
            loop(NULL);
        }

        /* Reset trigger state */
        if (trigger_effect != 0) {
            trigger_effect = -1;
            cyclePS5TriggerEffect();
        }

        CloseVirtualController();
        SDL_DestroyRenderer(screen);
        SDL_DestroyWindow(window);
        SDL_QuitSubSystem(SDL_INIT_VIDEO | SDL_INIT_JOYSTICK | SDL_INIT_GAMECONTROLLER);
    }

    private static void SDL_Log(String format, Object... args) {
        System.out.printf(format, args);
    }
}
