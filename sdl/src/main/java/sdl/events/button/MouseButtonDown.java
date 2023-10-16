package sdl.events.button;

public record MouseButtonDown(
        int x,
        int y
) implements MouseButtonEvent {
}
