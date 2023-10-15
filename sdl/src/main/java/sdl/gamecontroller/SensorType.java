package sdl.gamecontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.SDL_subset_h.*;

public enum SensorType {
    Invalid(SDL_SENSOR_INVALID()),
    Unknown(SDL_SENSOR_UNKNOWN()),
    Accel(SDL_SENSOR_ACCEL()),
    Gryo(SDL_SENSOR_GYRO()),
    AccelL(SDL_SENSOR_ACCEL_L()),
    GyroL(SDL_SENSOR_GYRO_L()),
    AccelR(SDL_SENSOR_ACCEL_R()),
    GyroR(SDL_SENSOR_GYRO_R()),
    ;

    private final int value;

    SensorType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, SensorType> lookup;

    static {
        lookup = new HashMap<>();
        for (SensorType e: SensorType.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static SensorType valueOf(int value) {
        SensorType x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("SensorType = " + value);
        }
        return x;
    }
}
