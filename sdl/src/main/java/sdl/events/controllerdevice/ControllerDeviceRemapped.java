package sdl.events.controllerdevice;

import sdl.joystick.JoystickId;

public record ControllerDeviceRemapped(
        JoystickId which
) implements ControllerDeviceEvent {
}
