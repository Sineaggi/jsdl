package sdl.events.mousewheel;

import sdl.mouse.MouseWheelDirection;

public record MouseWheel(
        int which,
        int x,
        int y,
        MouseWheelDirection direction,
        float preciseX,
        float preciseY
) implements MouseWheelEvent {
}
