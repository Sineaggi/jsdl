package sdl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.SDL_subset_h.SDL_CONTROLLER_BUTTON_INVALID;

public enum GameControllerButton {
    Invalid(SDL_CONTROLLER_BUTTON_INVALID()),
    ;

    private final int value;

    GameControllerButton(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, GameControllerButton> lookup;

    static {
        lookup = new HashMap<>();
        for (GameControllerButton e: GameControllerButton.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static GameControllerButton valueOf(int value) {
        GameControllerButton x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("GameControllerButton = " + value);
        }
        return x;
    }
}
