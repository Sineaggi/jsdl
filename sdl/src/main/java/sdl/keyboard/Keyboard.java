package sdl.keyboard;

import sdl.keycode.Keymod;

import java.util.EnumSet;

import static sdl.jextract.sdl_h.SDL_GetModState;

public class Keyboard {
    public static EnumSet<Keymod> getModState() {
        return Keymod.fromBits(SDL_GetModState());
    }
}
