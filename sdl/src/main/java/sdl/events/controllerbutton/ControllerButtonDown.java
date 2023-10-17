package sdl.events.controllerbutton;

import sdl.events.GeneralInputStateDefinitions;
import sdl.gamecontroller.GameControllerButton;
import sdl.joystick.JoystickId;

public record ControllerButtonDown(
        JoystickId which,
        GameControllerButton button,
        GeneralInputStateDefinitions state
) implements ControllerButtonEvent {
}
