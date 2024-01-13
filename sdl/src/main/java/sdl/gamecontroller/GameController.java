package sdl.gamecontroller;

import sdl.Cause;
import sdl.GameControllerAxis;
import sdl.SdlException;
import sdl.events.GeneralInputStateDefinitions;
import sdl.joystick.Joystick;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.time.Duration;

import static sdl.Cause.GameControllerAddMappingsFromRW;
import static sdl.internal.Util.stringOrNull;
import static sdl.jextract.sdl_h.*;
import static sdl.jextract.sdl_h_1.*;

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

    public static void addMappingsFromFile(String file) {
        try (var arena = Arena.ofConfined()) {
            if (SDL_GameControllerAddMappingsFromRW(SDL_RWFromFile(arena.allocateFrom(file), arena.allocateFrom("rb")), 1) != 0) {
                throw new SdlException(GameControllerAddMappingsFromRW);
            }
        }
    }

    public static int numMappings() {
        return SDL_GameControllerNumMappings();
    }

    public static String mappingForIndex(int mappingIndex) {
        MemorySegment mapping = SDL_GameControllerMappingForIndex(mappingIndex);
        if (mapping.equals(MemorySegment.NULL)) {
            return null;
        }
        try {
            return mapping.getString(0);
        } finally {
            SDL_free(mapping);
        }
    }

    public static String getStringForAxis(GameControllerAxis axis) {
        MemorySegment string = SDL_GameControllerGetStringForAxis(axis.value());
        if (string.equals(MemorySegment.NULL)) {
            return null;
        }
        try {
            return string.getString(0);
        } finally {
            SDL_free(string);
        }
    }

    public static String getStringForButton(GameControllerButton button) {
        MemorySegment string = SDL_GameControllerGetStringForButton(button.value());
        if (string.equals(MemorySegment.NULL)) {
            return null;
        }
        return string.getString(0);
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameController other) {
            return other.gameController.equals(gameController);
        }
        return super.equals(obj);
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
            return sendEffect(arena.allocateFrom(ValueLayout.JAVA_BYTE, data));
        }
    }

    public int sendEffect(MemorySegment data) {
        return SDL_GameControllerSendEffect(gameController, data, (int) data.byteSize());
    }

    public GeneralInputStateDefinitions getButton(GameControllerButton button) {
        return GeneralInputStateDefinitions.valueOf(SDL_GameControllerGetButton(gameController, button.value()));
    }

    public short getAxis(GameControllerAxis axis) {
        return SDL_GameControllerGetAxis(gameController, axis.value());
    }

    public int setLed(byte r, byte g, byte b) {
        return SDL_GameControllerSetLED(gameController, r, g, b);
    }

    public int rumbleTriggers(short leftRumble, short rightRumble, int durationMs) {
        return SDL_GameControllerRumbleTriggers(gameController, leftRumble, rightRumble, durationMs);
    }

    public int rumbleTriggers(short leftRumble, short rightRumble, Duration duration) {
        return SDL_GameControllerRumbleTriggers(gameController, leftRumble, rightRumble, (int) duration.toMillis());
    }

    public int rumble(short lowFrequencyRumble, short highFrequencyRumble, int durationMs) {
        return SDL_GameControllerRumble(gameController, lowFrequencyRumble, highFrequencyRumble, durationMs);
    }

    public int rumble(short lowFrequencyRumble, short highFrequencyRumble, Duration duration) {
        return SDL_GameControllerRumble(gameController, lowFrequencyRumble, highFrequencyRumble, (int) duration.toMillis());
    }

    public void setPlayerIndex(int playerIndex) {
        SDL_GameControllerSetPlayerIndex(gameController, playerIndex);
    }

    public GameControllerType getType() {
        return GameControllerType.valueOf(SDL_GameControllerGetType(gameController));
    }
}
