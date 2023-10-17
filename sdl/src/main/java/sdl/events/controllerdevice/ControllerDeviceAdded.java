package sdl.events.controllerdevice;

public record ControllerDeviceAdded(
        int which
) implements ControllerDeviceEvent {
}
