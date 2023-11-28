package sdl.mouse;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum MouseWheelDirection {
    Normal(-1),
    Flipped(-1),
    ;

    private final int value;

    MouseWheelDirection(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, MouseWheelDirection> lookup;

    static {
        lookup = new HashMap<>();
        for (MouseWheelDirection e: MouseWheelDirection.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static MouseWheelDirection valueOf(int value) {
        MouseWheelDirection x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("MouseWheelDirection = " + value);
        }
        return x;
    }
}
