package sdl.events.motion;

public record MouseMotion(
        int x,
        int y
) implements MouseMotionEvent {
}
