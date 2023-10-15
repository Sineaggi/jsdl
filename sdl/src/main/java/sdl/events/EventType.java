package sdl.events;

import sdl.gamecontroller.GameControllerType;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.SDL_subset_h.*;

public enum EventType {
    ControllerDeviceAdded(SDL_CONTROLLERDEVICEADDED()),
    ControllerDeviceRemoved(SDL_CONTROLLERDEVICEREMOVED()),
    SDL_CONTROLLERTOUCHPADDOWN(SDL_CONTROLLERTOUCHPADDOWN()),
    SDL_CONTROLLERTOUCHPADMOTION(SDL_CONTROLLERTOUCHPADMOTION()),
    SDL_CONTROLLERTOUCHPADUP(SDL_CONTROLLERTOUCHPADUP()),
    SDL_CONTROLLERSENSORUPDATE(SDL_CONTROLLERSENSORUPDATE()),
    SDL_CONTROLLERAXISMOTION(SDL_CONTROLLERAXISMOTION()),
    SDL_CONTROLLERBUTTONDOWN(SDL_CONTROLLERBUTTONDOWN()),
    SDL_CONTROLLERBUTTONUP(SDL_CONTROLLERBUTTONUP()),
    ;

    private final int value;

    EventType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, EventType> lookup;

    static {
        lookup = new HashMap<>();
        for (EventType e: EventType.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static EventType valueOf(int value) {
        EventType x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("EventType = " + value);
        }
        return x;
    }
}
