package sdl.events;

import sdl.events.controllerdevice.ControllerDeviceEvent;
import sdl.events.controllersensor.ControllerSensorEvent;
import sdl.events.controllertouchpad.ControllerTouchpad;

public sealed interface Event permits ControllerDeviceEvent, ControllerSensorEvent, ControllerTouchpad {
}
