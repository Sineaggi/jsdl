package sdl.hints;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h_1.*;
import static sdl.jextract.sdl_h_1.SDL_HINT_DEFAULT;

public enum HintPriority {
    Default(SDL_HINT_DEFAULT()),
    Normal(SDL_HINT_NORMAL()),
    Override(SDL_HINT_OVERRIDE()),
    ;

    private final int value;

    HintPriority(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, HintPriority> lookup;

    static {
        lookup = new HashMap<>();
        for (HintPriority e: HintPriority.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static HintPriority valueOf(int value) {
        HintPriority x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("HintPriority = " + value);
        }
        return x;
    }
}
