package sdl.events.key;

import sdl.keycode.Keycode;
import sdl.scancode.Scancode;

public record Keysym(
        Scancode scancode,      /**< SDL physical key code - see ::SDL_Scancode for details */
        Keycode sym,            /**< SDL virtual key code - see ::SDL_Keycode for details */
        short mod
) {
}
