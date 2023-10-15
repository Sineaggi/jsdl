package sdl.events.controllerdevice;

import sdl.events.Event;
import sdl.gamecontroller.JoystickId;

public sealed interface ControllerDeviceEvent extends Event permits ControllerDeviceAdded, ControllerDeviceRemapped, ControllerDeviceRemoved {
}
