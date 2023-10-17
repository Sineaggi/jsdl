package sdl.events.controllerdevice;

import sdl.events.Event;

public sealed interface ControllerDeviceEvent extends Event permits ControllerDeviceAdded, ControllerDeviceRemapped, ControllerDeviceRemoved {
}
