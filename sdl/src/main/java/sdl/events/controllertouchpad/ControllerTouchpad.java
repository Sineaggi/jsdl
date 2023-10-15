package sdl.events.controllertouchpad;

import sdl.events.Event;

public sealed interface ControllerTouchpad extends Event permits ControllerTouchpadDown, ControllerTouchpadMotion, ControllerTouchpadUp {
    int which();
    int touchpad();
    int finger();
    float x();
    float y();
    float pressure();
}
