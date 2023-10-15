package sdl.events.controllersensor;

import sdl.events.Event;

public sealed interface ControllerSensorEvent extends Event permits ControllerSensorUpdate {
    int which();
    int sensor();
    float[] data();
    long timestampUs();
}
