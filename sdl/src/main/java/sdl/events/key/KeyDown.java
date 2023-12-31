package sdl.events.key;

import sdl.events.GeneralInputStateDefinitions;

public record KeyDown(
        int windowID,
        GeneralInputStateDefinitions state,
        boolean repeat,
        Keysym keysym
) implements KeyboardEvent {
}
