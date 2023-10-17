package sdl.keycode;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static sdl.jextract.sdl_h.*;

public enum Keymod {
    None(KMOD_NONE()),
    LShift(KMOD_LSHIFT()),
    RightShift(KMOD_RSHIFT()),
    LeftControl(KMOD_LCTRL()),
    RightControl(KMOD_RCTRL()),
    LeftAlt(KMOD_LALT()),
    RightAlt(KMOD_RALT()),
    LeftGui(KMOD_LGUI()),
    RightGui(KMOD_RGUI()),
    Num(KMOD_NUM()),
    Caps(KMOD_CAPS()),
    Mode(KMOD_MODE()),
    Scroll(KMOD_SCROLL()),

    Control(KMOD_LCTRL() | KMOD_RCTRL()),
    Shift(KMOD_LSHIFT() | KMOD_RSHIFT()),
    Alt(KMOD_LALT() | KMOD_RALT()),
    Gui(KMOD_LGUI() | KMOD_RGUI()),

    Reserved(KMOD_SCROLL()),
    ;

    /*
    SDL_GetModState() & KMOD_SHIFT) != 0
     */

    private final int value;

    Keymod(int value) {
        this.value = value;
    }

    public static EnumSet<Keymod> fromBits(int bits) {
        return lookup.entrySet()
                .stream().filter((entry) -> (bits & entry.getKey()) != 0)
                .map(Map.Entry::getValue)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Keymod.class))); // https://stackoverflow.com/a/35178448
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, Keymod> lookup;

    static {
        lookup = new HashMap<>();
        for (Keymod e: Keymod.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static Keymod valueOf(int value) {
        Keymod x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("Keymod = " + value);
        }
        return x;
    }
}
