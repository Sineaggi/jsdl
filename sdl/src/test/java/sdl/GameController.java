package sdl;

import java.lang.foreign.MemorySegment;

import static sdl.SDL_subset_h.*;

public class GameController implements AutoCloseable {
    private final MemorySegment gameController;
    private GameController(MemorySegment gameController) {
        this.gameController = gameController;
    }
    public static GameController open(int joystickIndex) {
        return new GameController(SDL_GameControllerOpen(joystickIndex));
    }

    public String name() {
        return SDL_GameControllerName(gameController).getUtf8String(0);
    }

    public String getSerial() {
        return SDL_GameControllerGetSerial(gameController).getUtf8String(0);
    }

    public boolean hasSensor(SensorType type) {
        return SDL_GameControllerHasSensor(gameController, SensorTypeMapper.toInt(type)) == SDL_TRUE();
    }

    public void setSensorEnabled(SensorType type, boolean enabled) {
        SDL_GameControllerSetSensorEnabled(gameController, SensorTypeMapper.toInt(type), enabled ? SDL_TRUE() : SDL_FALSE());
    }

    @Override
    public void close() {
        SDL_GameControllerClose(gameController);
    }
}
