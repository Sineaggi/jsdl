package sdl.events.controllerdevice;

import sdl.gamecontroller.JoystickId;

public record ControllerDeviceAdded(
        int which
) implements ControllerDeviceEvent {
}
