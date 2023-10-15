package sdl.events.controllerdevice;

import sdl.gamecontroller.JoystickId;

public record ControllerDeviceRemapped(
        JoystickId which
) implements ControllerDeviceEvent {
}
