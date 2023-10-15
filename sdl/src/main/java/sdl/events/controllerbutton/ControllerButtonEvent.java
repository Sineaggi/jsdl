package sdl.events.controllerbutton;

import sdl.events.GeneralInputStateDefinitions;

public interface ControllerButtonEvent {
    int which();
    byte button();
    GeneralInputStateDefinitions state();
}
