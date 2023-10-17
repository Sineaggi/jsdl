package sdl.events;

import sdl.GameControllerAxis;
import sdl.SdlException;
import sdl.events.button.MouseButtonEvent;
import sdl.events.controlleraxis.ControllerAxisEvent;
import sdl.events.controlleraxis.ControllerAxisMotion;
import sdl.events.controllerbutton.ControllerButtonDown;
import sdl.events.controllerbutton.ControllerButtonEvent;
import sdl.events.controllerdevice.ControllerDeviceEvent;
import sdl.events.controllersensor.ControllerSensorEvent;
import sdl.events.controllertouchpad.ControllerTouchpad;
import sdl.events.joybattery.JoyBatteryEvent;
import sdl.events.key.KeyboardEvent;
import sdl.events.motion.MouseMotion;
import sdl.events.motion.MouseMotionEvent;
import sdl.events.quit.Quit;
import sdl.events.quit.QuitEvent;
import sdl.gamecontroller.GameControllerButton;
import sdl.jextract.*;
import sdl.joystick.JoystickId;
import sdl.joystick.JoystickPowerLevel;

import java.lang.foreign.Arena;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sdl.Cause.PeepEvents;
import static sdl.events.EventType.*;
import static sdl.jextract.sdl_h.SDL_PeepEvents;
import static sdl.jextract.sdl_h.SDL_PumpEvents;

public sealed interface Event permits Event.TodoEvent, MouseButtonEvent, ControllerAxisEvent, ControllerButtonEvent, ControllerDeviceEvent, ControllerSensorEvent, ControllerTouchpad, JoyBatteryEvent, KeyboardEvent, MouseMotionEvent, QuitEvent {
    static List<Event> peepEvents(int numEvents, int action, int minType, int maxType) {
        try (var arena = Arena.ofConfined()) {
            var events = SDL_Event.allocateArray(numEvents, arena);
            int peepedEventCount = SDL_PeepEvents(events, numEvents, action, minType, maxType);
            if (peepedEventCount < 0) {
                throw new SdlException(PeepEvents);
            } else if (peepedEventCount == 0) {
                return Collections.emptyList();
            } else {
                // todo: read events
                List<Event> mappedEvents = new ArrayList<>(peepedEventCount);
                for (int i = 0; i < peepedEventCount; i++) {
                    var type = EventType.valueOf(SDL_Event.type$get(events, 0));
                    // if (type == SDL_ControllerButtonEvent)
                    Event event = switch (type) {
                        case FirstEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case Quit -> {
                            yield new Quit();
                        }
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
                        case WindowEvent -> {
                            yield new TodoEvent(WindowEvent);
                        }
                        case SysWmEvent -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case KeyDown -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case KeyUp -> {
                            throw new RuntimeException(STR."\{type}");
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
                        case MouseMotion -> {
                            yield new MouseMotion(
                                    SDL_MouseMotionEvent.x$get(events, i),
                                    SDL_MouseMotionEvent.y$get(events, i)
                            );
                        }
                        case MouseButtonDown -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case MouseButtonUp -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case MouseWheel -> {
                            throw new RuntimeException(STR."\{type}");
                        }
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
                            throw new RuntimeException(STR."\{type}");
                        }
                        case JoyBatteryUpdated -> {
                            yield new sdl.events.joybattery.JoyBatteryUpdated(
                                    JoystickId.wrap(SDL_JoyBatteryEvent.which$get(events, i)),
                                    JoystickPowerLevel.valueOf(SDL_JoyBatteryEvent.level$get(events, i))
                            );
                        }
                        case ControllerAxisMotion -> {
                            yield new ControllerAxisMotion(
                                    JoystickId.wrap(SDL_ControllerAxisEvent.which$get(events, i)),
                                    GameControllerAxis.valueOf(SDL_ControllerAxisEvent.axis$get(events, i)),
                                    SDL_ControllerAxisEvent.value$get(events, i)
                            );
                        }
                        case ControllerButtonDown -> {
                            // yield new ControllerButtonDown(
                            //         JoystickId.wrap(SDL_ControllerButtonEvent.which$get(events, i)),
                            //         GameControllerButton.valueOf(SDL_ControllerButtonEvent.button$get(events, i)),
                            //         GeneralInputStateDefinitions.valueOf(SDL_ControllerButtonEvent.state$get(events, i))
                            // );
                            yield new TodoEvent(ControllerButtonDown);
                        }
                        case ControllerButtonUp -> {
                            //yield new sdl.events.controllerbutton.ControllerButtonUp(
                            //        JoystickId.wrap(SDL_ControllerButtonEvent.which$get(events, i)),
                            //        GameControllerButton.valueOf(SDL_ControllerButtonEvent.button$get(events, i)),
                            //        GeneralInputStateDefinitions.valueOf(SDL_ControllerButtonEvent.state$get(events, i))
                            //);
                            yield new TodoEvent(ControllerButtonDown);
                        }
                        case ControllerDeviceAdded -> {
                            yield new sdl.events.controllerdevice.ControllerDeviceAdded(
                                    SDL_ControllerDeviceEvent.which$get(events, i)
                            );
                        }
                        case ControllerDeviceRemoved -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ControllerDeviceRemapped -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ControllerTouchpadDown -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ControllerTouchpadMotion -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ControllerTouchpadUp -> {
                            throw new RuntimeException(STR."\{type}");
                        }
                        case ControllerSensorUpdate -> {
                            throw new RuntimeException(STR."\{type}");
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
                return mappedEvents;
            }
        }
    }

    static void pumpEvents() {
        SDL_PumpEvents();
    }

    record TodoEvent(EventType windowEvent) implements Event {

    }
}
