package sdl.events;

import sdl.SdlException;
import sdl.events.button.MouseButtonEvent;
import sdl.events.controlleraxis.ControllerAxisEvent;
import sdl.events.controllerbutton.ControllerButtonEvent;
import sdl.events.controllerdevice.ControllerDeviceEvent;
import sdl.events.controllersensor.ControllerSensorEvent;
import sdl.events.controllertouchpad.ControllerTouchpad;
import sdl.events.joybattery.JoyBatteryEvent;
import sdl.events.key.KeyboardEvent;
import sdl.events.motion.MouseMotionEvent;
import sdl.events.quit.Quit;
import sdl.events.quit.QuitEvent;
import sdl.jextract.SDL_Event;

import java.lang.foreign.Arena;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sdl.Cause.PeepEvents;
import static sdl.jextract.sdl_h.SDL_PeepEvents;
import static sdl.jextract.sdl_h.SDL_PumpEvents;

public sealed interface Event permits MouseButtonEvent, ControllerAxisEvent, ControllerButtonEvent, ControllerDeviceEvent, ControllerSensorEvent, ControllerTouchpad, JoyBatteryEvent, KeyboardEvent, MouseMotionEvent, QuitEvent {
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
                    var type = SDL_Event.type$get(events, 0);
                    // if (type == SDL_ControllerButtonEvent)
                    Event event = switch (EventType.valueOf(type)) {
                        case FirstEvent -> {
                            throw new RuntimeException("todo");
                        }
                        case Quit -> {
                            yield new Quit();
                        }
                        case AppTerminating -> {
                            throw new RuntimeException("todo");
                        }
                        case AppLowMemory -> {
                            throw new RuntimeException("todo");
                        }
                        case AppWillEnterBackground -> {
                            throw new RuntimeException("todo");
                        }
                        case AppDidEnterBackground -> {
                            throw new RuntimeException("todo");
                        }
                        case AppWillEnterForeground -> {
                            throw new RuntimeException("todo");
                        }
                        case AppDiDEnterForeground -> {
                            throw new RuntimeException("todo");
                        }
                        case LocaleChanged -> {
                            throw new RuntimeException("todo");
                        }
                        case DisplayEvent -> {
                            throw new RuntimeException("todo");
                        }
                        case WindowEvent -> {
                            throw new RuntimeException("todo");
                        }
                        case SysWmEvent -> {
                            throw new RuntimeException("todo");
                        }
                        case KeyDown -> {
                            throw new RuntimeException("todo");
                        }
                        case KeyUp -> {
                            throw new RuntimeException("todo");
                        }
                        case TextEditing -> {
                            throw new RuntimeException("todo");
                        }
                        case TextInput -> {
                            throw new RuntimeException("todo");
                        }
                        case KeyMapChanged -> {
                            throw new RuntimeException("todo");
                        }
                        case TextEditingExt -> {
                            throw new RuntimeException("todo");
                        }
                        case MouseMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case MouseButtonDown -> {
                            throw new RuntimeException("todo");
                        }
                        case MouseButtonUp -> {
                            throw new RuntimeException("todo");
                        }
                        case MouseWheel -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyAxisMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyBallMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyHatMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyButtonDown -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyButtonUp -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyDeviceAdded -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyDeviceRemoved -> {
                            throw new RuntimeException("todo");
                        }
                        case JoyBatteryUpdated -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerAxisMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerButtonDown -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerButtonUp -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerDeviceAdded -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerDeviceRemoved -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerDeviceRemapped -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerTouchpadDown -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerTouchpadMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerTouchpadUp -> {
                            throw new RuntimeException("todo");
                        }
                        case ControllerSensorUpdate -> {
                            throw new RuntimeException("todo");
                        }
                        case FingerDown -> {
                            throw new RuntimeException("todo");
                        }
                        case FingerUp -> {
                            throw new RuntimeException("todo");
                        }
                        case FingerMotion -> {
                            throw new RuntimeException("todo");
                        }
                        case DollarGesture -> {
                            throw new RuntimeException("todo");
                        }
                        case DollarRecord -> {
                            throw new RuntimeException("todo");
                        }
                        case MultiGesture -> {
                            throw new RuntimeException("todo");
                        }
                        case ClipboardUpdate -> {
                            throw new RuntimeException("todo");
                        }
                        case DropFile -> {
                            throw new RuntimeException("todo");
                        }
                        case DropText -> {
                            throw new RuntimeException("todo");
                        }
                        case DropBegin -> {
                            throw new RuntimeException("todo");
                        }
                        case DropComplete -> {
                            throw new RuntimeException("todo");
                        }
                        case AudioDeviceAdded -> {
                            throw new RuntimeException("todo");
                        }
                        case AudioDeviceRemoved -> {
                            throw new RuntimeException("todo");
                        }
                        case SensorUpdate -> {
                            throw new RuntimeException("todo");
                        }
                        case RenderTargetsReset -> {
                            throw new RuntimeException("todo");
                        }
                        case RenderDeviceReset -> {
                            throw new RuntimeException("todo");
                        }
                        case PollSentinel -> {
                            throw new RuntimeException("todo");
                        }
                        case UserEvent -> {
                            throw new RuntimeException("todo");
                        }
                        case LastEvent -> {
                            throw new RuntimeException("todo");
                        }
                    };
                    mappedEvents.set(i, event);
                }
                return mappedEvents;
            }
        }
    }

    static void pumpEvents() {
        SDL_PumpEvents();
    }
}
