package sdl.events;

import sdl.events.button.MouseButtonEvent;
import sdl.events.controllerdevice.ControllerDeviceEvent;
import sdl.events.controllersensor.ControllerSensorEvent;
import sdl.events.controllertouchpad.ControllerTouchpad;
import sdl.events.key.KeyEvent;
import sdl.events.motion.MouseMotionEvent;
import sdl.events.quit.QuitEvent;

public sealed interface Event permits MouseButtonEvent, ControllerDeviceEvent, ControllerSensorEvent, ControllerTouchpad, KeyEvent, MouseMotionEvent, QuitEvent {
}
