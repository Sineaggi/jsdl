package sdl.events;

import sdl.GameControllerAxis;
import sdl.SdlException;
import sdl.events.button.MouseButtonDown;
import sdl.events.button.MouseButtonEvent;
import sdl.events.button.MouseButtonUp;
import sdl.events.controlleraxis.ControllerAxisEvent;
import sdl.events.controlleraxis.ControllerAxisMotion;
import sdl.events.controllerbutton.ControllerButtonDown;
import sdl.events.controllerbutton.ControllerButtonEvent;
import sdl.events.controllerbutton.ControllerButtonUp;
import sdl.events.controllerdevice.ControllerDeviceAdded;
import sdl.events.controllerdevice.ControllerDeviceEvent;
import sdl.events.controllerdevice.ControllerDeviceRemoved;
import sdl.events.controllersensor.ControllerSensorEvent;
import sdl.events.controllersensor.ControllerSensorUpdate;
import sdl.events.controllertouchpad.ControllerTouchpad;
import sdl.events.controllertouchpad.ControllerTouchpadDown;
import sdl.events.controllertouchpad.ControllerTouchpadMotion;
import sdl.events.controllertouchpad.ControllerTouchpadUp;
import sdl.events.joybattery.JoyBatteryEvent;
import sdl.events.joybattery.JoyBatteryUpdated;
import sdl.events.key.KeyDown;
import sdl.events.key.KeyUp;
import sdl.events.key.KeyboardEvent;
import sdl.events.key.Keysym;
import sdl.events.motion.MouseMotion;
import sdl.events.motion.MouseMotionEvent;
import sdl.events.mousewheel.MouseWheel;
import sdl.events.mousewheel.MouseWheelEvent;
import sdl.events.quit.Quit;
import sdl.events.quit.QuitEvent;
import sdl.gamecontroller.GameControllerButton;
import sdl.gamecontroller.SensorType;
import sdl.jextract.SDL_ControllerAxisEvent;
import sdl.jextract.SDL_ControllerButtonEvent;
import sdl.jextract.SDL_ControllerDeviceEvent;
import sdl.jextract.SDL_ControllerSensorEvent;
import sdl.jextract.SDL_ControllerTouchpadEvent;
import sdl.jextract.SDL_Event;
import sdl.jextract.SDL_JoyBatteryEvent;
import sdl.jextract.SDL_KeyboardEvent;
import sdl.jextract.SDL_Keysym;
import sdl.jextract.SDL_MouseButtonEvent;
import sdl.jextract.SDL_MouseMotionEvent;
import sdl.jextract.SDL_MouseWheelEvent;
import sdl.joystick.JoystickId;
import sdl.joystick.JoystickPowerLevel;
import sdl.keycode.Keycode;
import sdl.mouse.MouseWheelDirection;
import sdl.scancode.Scancode;

import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sdl.Cause.PeepEvents;
import static sdl.events.EventType.JoyAxisMotion;
import static sdl.events.EventType.JoyButtonDown;
import static sdl.events.EventType.JoyButtonUp;
import static sdl.events.EventType.JoyDeviceAdded;
import static sdl.events.EventType.JoyDeviceRemoved;
import static sdl.events.EventType.JoyHatMotion;
import static sdl.events.EventType.MouseWheel;
import static sdl.events.EventType.TextEditing;
import static sdl.events.EventType.WindowEvent;
import static sdl.jextract.sdl_h.SDL_PeepEvents;
import static sdl.jextract.sdl_h.SDL_PumpEvents;
import static sdl.jextract.sdl_h.SDL_TRUE;

public sealed interface Event permits Event.TodoEvent, MouseButtonEvent, ControllerAxisEvent, ControllerButtonEvent, ControllerDeviceEvent, ControllerSensorEvent, ControllerTouchpad, JoyBatteryEvent, KeyboardEvent, MouseMotionEvent, MouseWheelEvent, QuitEvent {
    static List<Event> peepEvents(int numEvents, int action, int minType, int maxType) {
        try (var arena = Arena.ofConfined()) {
            var events = SDL_Event.allocateArray(numEvents, arena);
            int peepedEventCount = SDL_PeepEvents(events, numEvents, action, minType, maxType);
            if (peepedEventCount < 0) {
                throw new SdlException(PeepEvents);
            } else if (peepedEventCount == 0) {
                return Collections.emptyList();
            } else {
                List<Event> mappedEvents = new ArrayList<>(peepedEventCount);
                for (int i = 0; i < peepedEventCount; i++) {
                    var eventSlice = events.asSlice(i, SDL_Event.$LAYOUT());
                    var type = EventType.valueOf(SDL_Event.type$get(eventSlice));
                    Event event = switch (type) {
                        case FirstEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case Quit -> new Quit();
                        case AppTerminating -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AppLowMemory -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AppWillEnterBackground -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AppDidEnterBackground -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AppWillEnterForeground -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AppDiDEnterForeground -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case LocaleChanged -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DisplayEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case WindowEvent -> new TodoEvent(WindowEvent);
                        case SysWmEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case KeyDown -> {
                            var keysym = SDL_KeyboardEvent.keysym$slice(eventSlice);
                            yield new KeyDown(
                                    SDL_KeyboardEvent.windowID$get(eventSlice),
                                    GeneralInputStateDefinitions.valueOf(SDL_KeyboardEvent.state$get(eventSlice)),
                                    SDL_KeyboardEvent.repeat$get(eventSlice) == SDL_TRUE(),
                                    new Keysym(
                                            Scancode.valueOf(SDL_Keysym.scancode$get(keysym)),
                                            Keycode.valueOf(SDL_Keysym.sym$get(keysym)),
                                            SDL_Keysym.mod$get(keysym)
                                    )
                            );
                        }
                        case KeyUp -> {
                            var keysym = SDL_KeyboardEvent.keysym$slice(eventSlice);
                            yield new KeyUp(
                                    SDL_KeyboardEvent.windowID$get(eventSlice),
                                    GeneralInputStateDefinitions.valueOf(SDL_KeyboardEvent.state$get(eventSlice)),
                                    SDL_KeyboardEvent.repeat$get(eventSlice) == SDL_TRUE(),
                                    new Keysym(
                                            Scancode.valueOf(SDL_Keysym.scancode$get(keysym)),
                                            Keycode.valueOf(SDL_Keysym.sym$get(keysym)),
                                            SDL_Keysym.mod$get(keysym)
                                    )
                            );
                        }
                        case TextEditing -> {
                            yield new TodoEvent(TextEditing);
                        }
                        case TextInput -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case KeyMapChanged -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case TextEditingExt -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case MouseMotion -> new MouseMotion(
                                SDL_MouseMotionEvent.x$get(eventSlice),
                                SDL_MouseMotionEvent.y$get(eventSlice)
                        );
                        case MouseButtonDown -> new MouseButtonDown(
                                SDL_MouseButtonEvent.x$get(eventSlice),
                                SDL_MouseButtonEvent.y$get(eventSlice)
                        );
                        case MouseButtonUp -> new MouseButtonUp(
                                SDL_MouseButtonEvent.x$get(eventSlice),
                                SDL_MouseButtonEvent.y$get(eventSlice)
                        );
                        case MouseWheel -> new MouseWheel(
                                SDL_MouseWheelEvent.which$get(eventSlice),
                                SDL_MouseWheelEvent.x$get(eventSlice),
                                SDL_MouseWheelEvent.y$get(eventSlice),
                                MouseWheelDirection.valueOf(SDL_MouseWheelEvent.direction$get(eventSlice)),
                                SDL_MouseWheelEvent.preciseX$get(eventSlice),
                                SDL_MouseWheelEvent.preciseY$get(eventSlice)
                        );
                        case JoyAxisMotion -> {
                            yield new TodoEvent(JoyAxisMotion);
                        }
                        case JoyBallMotion -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case JoyHatMotion -> {
                            yield new TodoEvent(JoyHatMotion);
                        }
                        case JoyButtonDown -> {
                            yield new TodoEvent(JoyButtonDown);
                        }
                        case JoyButtonUp -> {
                            yield new TodoEvent(JoyButtonUp);
                        }
                        case JoyDeviceAdded -> {
                            yield new TodoEvent(JoyDeviceAdded);
                        }
                        case JoyDeviceRemoved -> {
                            yield new TodoEvent(JoyDeviceRemoved);
                        }
                        case JoyBatteryUpdated -> new JoyBatteryUpdated(
                                JoystickId.wrap(SDL_JoyBatteryEvent.which$get(eventSlice)),
                                JoystickPowerLevel.valueOf(SDL_JoyBatteryEvent.level$get(eventSlice))
                        );
                        case ControllerAxisMotion -> new ControllerAxisMotion(
                                JoystickId.wrap(SDL_ControllerAxisEvent.which$get(eventSlice)),
                                GameControllerAxis.valueOf(SDL_ControllerAxisEvent.axis$get(eventSlice)),
                                SDL_ControllerAxisEvent.value$get(eventSlice)
                        );
                        case ControllerButtonDown -> new ControllerButtonDown(
                                JoystickId.wrap(SDL_ControllerButtonEvent.which$get(eventSlice)),
                                GameControllerButton.valueOf(SDL_ControllerButtonEvent.button$get(eventSlice)),
                                GeneralInputStateDefinitions.valueOf(SDL_ControllerButtonEvent.state$get(eventSlice))
                        );
                        case ControllerButtonUp -> new ControllerButtonUp(
                                JoystickId.wrap(SDL_ControllerButtonEvent.which$get(eventSlice)),
                                GameControllerButton.valueOf(SDL_ControllerButtonEvent.button$get(eventSlice)),
                                GeneralInputStateDefinitions.valueOf(SDL_ControllerButtonEvent.state$get(eventSlice))
                        );
                        case ControllerDeviceAdded -> new ControllerDeviceAdded(
                                SDL_ControllerDeviceEvent.which$get(eventSlice)
                        );
                        case ControllerDeviceRemoved -> new ControllerDeviceRemoved(
                            JoystickId.wrap(SDL_ControllerDeviceEvent.which$get(eventSlice))
                        );
                        case ControllerDeviceRemapped -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ControllerTouchpadDown -> new ControllerTouchpadDown(
                                SDL_ControllerTouchpadEvent.which$get(eventSlice),
                                SDL_ControllerTouchpadEvent.touchpad$get(eventSlice),
                                SDL_ControllerTouchpadEvent.finger$get(eventSlice),
                                SDL_ControllerTouchpadEvent.x$get(eventSlice),
                                SDL_ControllerTouchpadEvent.y$get(eventSlice),
                                SDL_ControllerTouchpadEvent.pressure$get(eventSlice)
                        );
                        case ControllerTouchpadMotion -> new ControllerTouchpadMotion(
                                SDL_ControllerTouchpadEvent.which$get(eventSlice),
                                SDL_ControllerTouchpadEvent.touchpad$get(eventSlice),
                                SDL_ControllerTouchpadEvent.finger$get(eventSlice),
                                SDL_ControllerTouchpadEvent.x$get(eventSlice),
                                SDL_ControllerTouchpadEvent.y$get(eventSlice),
                                SDL_ControllerTouchpadEvent.pressure$get(eventSlice)
                        );
                        case ControllerTouchpadUp -> new ControllerTouchpadUp(
                                SDL_ControllerTouchpadEvent.which$get(eventSlice),
                                SDL_ControllerTouchpadEvent.touchpad$get(eventSlice),
                                SDL_ControllerTouchpadEvent.finger$get(eventSlice),
                                SDL_ControllerTouchpadEvent.x$get(eventSlice),
                                SDL_ControllerTouchpadEvent.y$get(eventSlice),
                                SDL_ControllerTouchpadEvent.pressure$get(eventSlice)
                        );
                        case ControllerSensorUpdate -> {
                            var data = SDL_ControllerSensorEvent.data$slice(eventSlice)
                                    .toArray(ValueLayout.OfFloat.JAVA_FLOAT);
                            yield new ControllerSensorUpdate(
                                    SDL_ControllerSensorEvent.which$get(eventSlice),
                                    SensorType.valueOf(SDL_ControllerSensorEvent.sensor$get(eventSlice)),
                                    data,
                                    SDL_ControllerSensorEvent.timestamp_us$get(eventSlice)
                            );
                        }
                        case FingerDown -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case FingerUp -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case FingerMotion -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DollarGesture -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DollarRecord -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case MultiGesture -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ClipboardUpdate -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DropFile -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DropText -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DropBegin -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case DropComplete -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AudioDeviceAdded -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case AudioDeviceRemoved -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case SensorUpdate -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case RenderTargetsReset -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case RenderDeviceReset -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case PollSentinel -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case UserEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case LastEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                    };
                    mappedEvents.add(i, event);
                }
                return Collections.unmodifiableList(mappedEvents);
            }
        }
    }

    static void pumpEvents() {
        SDL_PumpEvents();
    }

    record TodoEvent(EventType windowEvent) implements Event {

    }
}
