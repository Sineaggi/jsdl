package sdl.events.controllerbutton;

import sdl.events.GeneralInputStateDefinitions;
import sdl.gamecontroller.GameControllerButton;
import sdl.joystick.JoystickId;

public record ControllerButtonUp(
        JoystickId which,
        GameControllerButton button,
        GeneralInputStateDefinitions state
) implements ControllerButtonEvent {
}
