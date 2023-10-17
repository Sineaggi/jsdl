package sdl.joystick;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h_1.*;

public enum JoystickPowerLevel {
    Unknown(SDL_JOYSTICK_POWER_UNKNOWN()),
    Empty(SDL_JOYSTICK_POWER_EMPTY()),
    Low(SDL_JOYSTICK_POWER_LOW()),
    Medium(SDL_JOYSTICK_POWER_MEDIUM()),
    Full(SDL_JOYSTICK_POWER_FULL()),
    Wired(SDL_JOYSTICK_POWER_WIRED()),
    Max(SDL_JOYSTICK_POWER_MAX()),
    ;

    private final int value;

    JoystickPowerLevel(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, JoystickPowerLevel> lookup;

    static {
        lookup = new HashMap<>();
        for (JoystickPowerLevel e: JoystickPowerLevel.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static JoystickPowerLevel valueOf(int value) {
        JoystickPowerLevel x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("JoystickPowerLevel = " + value);
        }
        return x;
    }
}
