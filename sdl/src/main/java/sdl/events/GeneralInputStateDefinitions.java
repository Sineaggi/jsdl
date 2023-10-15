package sdl.events;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.SDL_subset_h.*;

public enum GeneralInputStateDefinitions {
    Pressed(SDL_PRESSED()),
    Released(SDL_RELEASED()),
    ;

    private final int value;

    GeneralInputStateDefinitions(int value) {
        this.value = value;
    }

    public byte value() {
        return value;
    }

    private final static Map<Integer, GeneralInputStateDefinitions> lookup;

    static {
        lookup = new HashMap<>();
        for (GeneralInputStateDefinitions e: GeneralInputStateDefinitions.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static GeneralInputStateDefinitions valueOf(int value) {
        GeneralInputStateDefinitions x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("GeneralInputStateDefinitions = " + value);
        }
        return x;
    }
}
