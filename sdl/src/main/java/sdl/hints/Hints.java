package sdl.hints;

import java.lang.foreign.Arena;

import static sdl.jextract.sdl_h.*;

public class Hints {

    public static final String HINT_ACCELEROMETER_AS_JOYSTICK = "SDL_HINT_ACCELEROMETER_AS_JOYSTICK";
    public static final String HINT_JOYSTICK_HIDAPI_PS4_RUMBLE = "SDL_HINT_JOYSTICK_HIDAPI_PS4_RUMBLE";
    public static final String HINT_JOYSTICK_HIDAPI_PS5_RUMBLE = "SDL_HINT_JOYSTICK_HIDAPI_PS5_RUMBLE";
    public static final String HINT_JOYSTICK_HIDAPI_STEAM = "SDL_HINT_JOYSTICK_HIDAPI_STEAM";
    public static final String HINT_JOYSTICK_ROG_CHAKRAM = "SDL_HINT_JOYSTICK_ROG_CHAKRAM";
    public static final String HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS = "SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS";
    public static final String HINT_LINUX_JOYSTICK_DEADZONES = "SDL_HINT_LINUX_JOYSTICK_DEADZONES";

    public static boolean setHint(String name, String value) {
        try (var arena = Arena.ofConfined()) {
            return SDL_SetHint(arena.allocateUtf8String(name), arena.allocateUtf8String(value)) == SDL_TRUE();
        }
    }
}
