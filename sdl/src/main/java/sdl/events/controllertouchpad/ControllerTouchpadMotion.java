package sdl.events.controllertouchpad;

public record ControllerTouchpadMotion(
        int which,
        int touchpad,
        int finger,
        float x,
        float y,
        float pressure
) implements ControllerTouchpad {
}
