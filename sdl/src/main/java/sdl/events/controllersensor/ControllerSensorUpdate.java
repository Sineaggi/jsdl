package sdl.events.controllersensor;

import sdl.gamecontroller.SensorType;

public record ControllerSensorUpdate(
        int which,
        SensorType sensor,
        float[] data,
        long timestampUs
) implements ControllerSensorEvent {
}
