package sdl.events.key;

import sdl.events.GeneralInputStateDefinitions;

public record KeyUp(
        int windowID,
        GeneralInputStateDefinitions state,
        boolean repeat,
        Keysym keysym
) implements KeyboardEvent {
}
