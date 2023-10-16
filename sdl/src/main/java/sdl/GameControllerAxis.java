package sdl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h.*;

public enum GameControllerAxis {
    Invalid(SDL_CONTROLLER_AXIS_INVALID()),
    LeftX(SDL_CONTROLLER_AXIS_LEFTX()),
    LeftY(SDL_CONTROLLER_AXIS_LEFTY()),
    RightX(SDL_CONTROLLER_AXIS_RIGHTX()),
    RightY(SDL_CONTROLLER_AXIS_RIGHTY()),
    TriggerLeft(SDL_CONTROLLER_AXIS_TRIGGERLEFT()),
    TriggerRight(SDL_CONTROLLER_AXIS_TRIGGERRIGHT()),
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
