package sdl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h.*;

public enum Init {
    Audio(SDL_INIT_AUDIO()),
    Events(SDL_INIT_EVENTS()),
    Everything(SDL_INIT_EVERYTHING()),
    GameController(SDL_INIT_GAMECONTROLLER()),
    Haptic(SDL_INIT_HAPTIC()),
    Joystick(SDL_INIT_JOYSTICK()),
    NoParachute(SDL_INIT_NOPARACHUTE()),
    Sensor(SDL_INIT_SENSOR()),
    Timer(SDL_INIT_TIMER()),
    Video(SDL_INIT_VIDEO()),
    ;

    private final int value;

    Init(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, Init> lookup;

    static {
        lookup = new HashMap<>();
        for (Init e: Init.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static Init valueOf(int value) {
        Init x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("Init = " + value);
        }
        return x;
    }
}
