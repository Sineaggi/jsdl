package sdl.events.controllersensor;

import sdl.events.Event;
import sdl.gamecontroller.SensorType;

public sealed interface ControllerSensorEvent extends Event permits ControllerSensorUpdate {
    int which();
    SensorType sensor();
    float[] data();
    long timestampUs();
}
