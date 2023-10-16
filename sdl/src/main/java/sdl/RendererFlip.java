package sdl;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h_1.*;

public enum RendererFlip {
    FlipNone(SDL_FLIP_NONE()),
    ;
    private final int value;

    RendererFlip(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, RendererFlip> lookup;

    static {
        lookup = new HashMap<>();
        for (RendererFlip e: RendererFlip.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static RendererFlip valueOf(int value) {
        RendererFlip x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("RendererFlip = " + value);
        }
        return x;
    }
}
