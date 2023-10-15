package sdl.events.controllersensor;

public record ControllerSensorUpdate(
        int which,
        int sensor,
        float[] data,
        long timestampUs
) implements ControllerSensorEvent {
}
