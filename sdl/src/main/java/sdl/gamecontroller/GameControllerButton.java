package sdl.gamecontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h.*;

public enum GameControllerButton {
    Invalid(SDL_CONTROLLER_BUTTON_INVALID()),
    A(SDL_CONTROLLER_BUTTON_A()),
    B(SDL_CONTROLLER_BUTTON_B()),
    X(SDL_CONTROLLER_BUTTON_X()),
    Y(SDL_CONTROLLER_BUTTON_Y()),
    Back(SDL_CONTROLLER_BUTTON_BACK()),
    Guide(SDL_CONTROLLER_BUTTON_GUIDE()),
    Start(SDL_CONTROLLER_BUTTON_START()),
    LeftStick(SDL_CONTROLLER_BUTTON_LEFTSTICK()),
    RightStick(SDL_CONTROLLER_BUTTON_RIGHTSTICK()),
    LeftShoulder(SDL_CONTROLLER_BUTTON_LEFTSHOULDER()),
    RightShoulder(SDL_CONTROLLER_BUTTON_RIGHTSHOULDER()),
    DPadUp(SDL_CONTROLLER_BUTTON_DPAD_UP()),
    DPadDown(SDL_CONTROLLER_BUTTON_DPAD_DOWN()),
    DPadLeft(SDL_CONTROLLER_BUTTON_DPAD_LEFT()),
    DPadRight(SDL_CONTROLLER_BUTTON_DPAD_RIGHT()),
    Misc1(SDL_CONTROLLER_BUTTON_MISC1()),
    Paddle1(SDL_CONTROLLER_BUTTON_PADDLE1()),
    Paddle2(SDL_CONTROLLER_BUTTON_PADDLE2()),
    Paddle3(SDL_CONTROLLER_BUTTON_PADDLE3()),
    Paddle4(SDL_CONTROLLER_BUTTON_PADDLE4()),
    Touchpad(SDL_CONTROLLER_BUTTON_TOUCHPAD()),
    Max(SDL_CONTROLLER_BUTTON_MAX()),
    ;

    private final int value;

    GameControllerButton(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, GameControllerButton> lookup;

    static {
        lookup = new HashMap<>();
        for (GameControllerButton e: GameControllerButton.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static GameControllerButton valueOf(int value) {
        GameControllerButton x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("GameControllerButton = " + value);
        }
        return x;
    }
}
