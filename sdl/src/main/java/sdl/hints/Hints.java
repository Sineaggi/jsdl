package sdl.hints;

import java.lang.foreign.Arena;

import static sdl.jextract.sdl_h.*;

public class Hints {
    public static boolean setHint(String name, String value) {
        try (var arena = Arena.ofConfined()) {
            return SDL_SetHint(arena.allocateFrom(name), arena.allocateFrom(value)) == SDL_TRUE();
        }
    }

    public static boolean setHint(Hint hint, String value) {
        try (var arena = Arena.ofConfined()) {
            return SDL_SetHint(hint.allocatedValue(), arena.allocateFrom(value)) == SDL_TRUE();
        }
    }

    public static boolean setHint(Hint hint, String value, HintPriority hintPriority) {
        try (var arena = Arena.ofConfined()) {
            return SDL_SetHintWithPriority(hint.allocatedValue(), arena.allocateFrom(value), hintPriority.value()) == SDL_TRUE();
        }
    }
}
