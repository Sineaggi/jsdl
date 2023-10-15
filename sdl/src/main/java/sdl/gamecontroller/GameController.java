package sdl.gamecontroller;

import sdl.Cause;
import sdl.SdlException;
import sdl.events.GeneralInputStateDefinitions;
import sdl.joystick.Joystick;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static sdl.internal.Util.stringOrNull;
import static sdl.jextract.SDL_subset_h.*;

public class GameController implements AutoCloseable {
    private final MemorySegment gameController;
    private GameController(MemorySegment gameController) {
        this.gameController = gameController;
    }
    public static GameController open(int joystickIndex) {
        MemorySegment gameController = SDL_GameControllerOpen(joystickIndex);
        if (gameController.equals(MemorySegment.NULL)) {
            throw new SdlException(Cause.OpenGameController);
        }
        return new GameController(SDL_GameControllerOpen(joystickIndex));
    }

    public static boolean isGameController(int joystickIndex) {
        return SDL_IsGameController(joystickIndex) == SDL_TRUE();
    }

    public static String nameForIndex(int joystickIndex) {
        return stringOrNull(SDL_GameControllerNameForIndex(joystickIndex));
    }

    public static String pathForIndex(int joystickIndex) {
        return stringOrNull(SDL_GameControllerPathForIndex(joystickIndex));
    }

    public static GameControllerType typeForIndex(int joystickIndex) {
        return GameControllerType.valueOf(SDL_GameControllerTypeForIndex(joystickIndex));
    }

    public String name() {
        return stringOrNull(SDL_GameControllerName(gameController));
    }

    public String getSerial() {
        return stringOrNull(SDL_GameControllerGetSerial(gameController));
    }

    public String path() {
        return stringOrNull(SDL_GameControllerPath(gameController));
    }

    public boolean hasSensor(SensorType type) {
        return SDL_GameControllerHasSensor(gameController, type.value()) == SDL_TRUE();
    }

    public void setSensorEnabled(SensorType type, boolean enabled) {
        SDL_GameControllerSetSensorEnabled(gameController, type.value(), enabled ? SDL_TRUE() : SDL_FALSE());
    }

    @Override
    public void close() {
        SDL_GameControllerClose(gameController);
    }

    /**
     *
     * @return Return the controller firmware version, or zero if unavailable.
     */
    public short getFirmwareVersion() {
        return SDL_GameControllerGetFirmwareVersion(gameController);
    }

    /**
     * Get the data rate (number of events per second) of a game controller sensor.
     * @param sensor The type of sensor to query
     * @return Return the data rate, or 0.0f if the data rate is not available.
     */
    public float getSensorDataRate(SensorType sensor) {
        return SDL_GameControllerGetSensorDataRate(gameController, sensor.value());
    }

    public Joystick getJoystick() {
        return Joystick.wrap(SDL_GameControllerGetJoystick(gameController));
    }

    public boolean hasRumble() {
        return SDL_GameControllerHasRumble(gameController) == SDL_TRUE();
    }

    public boolean hasRumbleTriggers() {
        return SDL_GameControllerHasRumbleTriggers(gameController) == SDL_TRUE();
    }

    public int sendEffect(byte[] data) {
        try (var arena = Arena.ofConfined()) {
            var nativeData = arena.allocateArray(ValueLayout.JAVA_BYTE, data);
            return SDL_GameControllerSendEffect(gameController, nativeData, (int) nativeData.byteSize());
        }
    }

    public GeneralInputStateDefinitions getButton(int button) {
        return GeneralInputStateDefinitions.valueOf(SDL_GameControllerGetButton(gameController, button));
    }
}
