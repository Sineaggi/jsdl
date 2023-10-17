package sdl.events.joybattery;

import sdl.joystick.JoystickId;
import sdl.joystick.JoystickPowerLevel;

public record JoyBatteryUpdated(
        JoystickId which,
        JoystickPowerLevel level
) implements JoyBatteryEvent {
}
