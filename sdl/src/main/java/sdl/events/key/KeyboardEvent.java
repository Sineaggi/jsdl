package sdl.events.key;

import sdl.events.Event;
import sdl.events.GeneralInputStateDefinitions;

public sealed interface KeyboardEvent extends Event permits KeyDown, KeyUp {
    int windowID();    /**< The window with keyboard focus, if any */
    GeneralInputStateDefinitions state();        /**< ::SDL_PRESSED or ::SDL_RELEASED */
    boolean repeat();       /**< Non-zero if this is a key repeat */
    Keysym keysym();
}
