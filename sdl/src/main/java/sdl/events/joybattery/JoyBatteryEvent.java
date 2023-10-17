package sdl.events.joybattery;

import sdl.events.Event;
import sdl.joystick.JoystickId;
import sdl.joystick.JoystickPowerLevel;

public sealed interface JoyBatteryEvent extends Event permits JoyBatteryUpdated {
    JoystickId which();
    JoystickPowerLevel level();
}
