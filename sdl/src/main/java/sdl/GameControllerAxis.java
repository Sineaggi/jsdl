package sdl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.SDL_subset_h.SDL_CONTROLLER_AXIS_INVALID;
import static sdl.jextract.SDL_subset_h.SDL_CONTROLLER_AXIS_MAX;

public enum GameControllerAxis {
    Invalid(SDL_CONTROLLER_AXIS_INVALID()),
    Max(SDL_CONTROLLER_AXIS_MAX()),
    ;

    private final int value;

    GameControllerAxis(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, GameControllerAxis> lookup;

    static {
        lookup = new HashMap<>();
        for (GameControllerAxis e: GameControllerAxis.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static GameControllerAxis valueOf(int value) {
        GameControllerAxis x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("GameControllerAxis = " + value);
        }
        return x;
    }

    public GameControllerAxis add(int i) {
        return GameControllerAxis.valueOf(this.value + i);
    }
}
