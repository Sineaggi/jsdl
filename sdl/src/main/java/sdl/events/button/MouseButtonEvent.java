package sdl.events.button;

import sdl.events.Event;

public sealed interface MouseButtonEvent extends Event permits MouseButtonDown, MouseButtonUp {
}
