package sdl;

import static sdl.SDL_subset_h.*;
import static sdl.SDL_subset_h.SDL_SENSOR_GYRO;

public class SensorTypeMapper {
    public static int toInt(SensorType type) {
        return switch (type) {
            case Invalid -> SDL_SENSOR_INVALID();
            case Unknown -> SDL_SENSOR_UNKNOWN();
            case Accel -> SDL_SENSOR_ACCEL();
            case Gryo -> SDL_SENSOR_GYRO();
            case AccelL -> SDL_SENSOR_ACCEL_L();
            case GyroL -> SDL_SENSOR_GYRO_L();
            case AccelR -> SDL_SENSOR_ACCEL_R();
            case GyroR -> SDL_SENSOR_GYRO_R();
        };
    }
}
