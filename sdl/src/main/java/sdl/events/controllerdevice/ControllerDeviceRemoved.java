package sdl.events.controllerdevice;

import sdl.joystick.JoystickId;

public record ControllerDeviceRemoved(
        JoystickId which
) implements ControllerDeviceEvent {
}
