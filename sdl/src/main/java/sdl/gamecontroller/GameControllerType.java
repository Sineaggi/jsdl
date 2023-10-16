package sdl.gamecontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h.*;

public enum GameControllerType {
    Unknown(SDL_CONTROLLER_TYPE_UNKNOWN()),
    XBox360(SDL_CONTROLLER_TYPE_XBOX360()),
    XBoxOne(SDL_CONTROLLER_TYPE_XBOXONE()),
    PS3(SDL_CONTROLLER_TYPE_PS3()),

    PS4(SDL_CONTROLLER_TYPE_PS4()),
    NintendoSwitchPro(SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_PRO()),
    Virtual(SDL_CONTROLLER_TYPE_VIRTUAL()),
    PS5(SDL_CONTROLLER_TYPE_PS5()),
    AmazonLuna(SDL_CONTROLLER_TYPE_AMAZON_LUNA()),
    GoogleStadia(SDL_CONTROLLER_TYPE_GOOGLE_STADIA()),
    NVidiaShield(SDL_CONTROLLER_TYPE_NVIDIA_SHIELD()),
    NintendoSwitchJoyconLeft(SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_LEFT()),
    NintendoSwitchJoyconRight(SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_RIGHT()),
    NintendoSwitchJoyconPair(SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_PAIR()),
    ;

    private final int value;

    GameControllerType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, GameControllerType> lookup;

    static {
        lookup = new HashMap<>();
        for (GameControllerType e: GameControllerType.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static GameControllerType valueOf(int value) {
        GameControllerType x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("GameControllerType = " + value);
        }
        return x;
    }
}
