package sdl.events.controllerdevice;

import sdl.gamecontroller.JoystickId;

public record ControllerDeviceRemoved(
        JoystickId which
) implements ControllerDeviceEvent {
}
