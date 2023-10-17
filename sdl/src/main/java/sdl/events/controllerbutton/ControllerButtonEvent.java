package sdl.events.controllerbutton;

import sdl.events.Event;
import sdl.events.GeneralInputStateDefinitions;
import sdl.gamecontroller.GameControllerButton;
import sdl.joystick.JoystickId;

public sealed interface ControllerButtonEvent extends Event permits ControllerButtonDown, ControllerButtonUp {
    JoystickId which();
    GameControllerButton button();
    GeneralInputStateDefinitions state();
}
