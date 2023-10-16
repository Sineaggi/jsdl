package sdl;

import static sdl.Cause.Init;
import static sdl.jextract.sdl_h_1.*;

public class Sdl {
    public static void init(int flags) {
        if (SDL_Init(flags) != 0) {
            throw new SdlException(Init);
        }
    }

    public static void quitSubSystem(int flags) {
        SDL_QuitSubSystem(flags);
    }
}
