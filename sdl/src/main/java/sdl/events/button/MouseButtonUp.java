package sdl.events.button;

public record MouseButtonUp(
        int x,
        int y
) implements MouseButtonEvent {
}
