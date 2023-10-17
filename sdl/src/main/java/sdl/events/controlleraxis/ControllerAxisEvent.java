package sdl.events.controlleraxis;

import sdl.GameControllerAxis;
import sdl.events.Event;
import sdl.joystick.JoystickId;

public sealed interface ControllerAxisEvent extends Event permits ControllerAxisMotion {
    JoystickId which(); /**< The joystick instance id */
    GameControllerAxis axis();         /**< The controller axis (SDL_GameControllerAxis) */
    short value();       /**< The axis value (range: -32768 to 32767) */
}
