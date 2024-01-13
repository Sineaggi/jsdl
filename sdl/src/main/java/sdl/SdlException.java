package sdl;

import static sdl.jextract.sdl_h.*;

public class SdlException extends RuntimeException {
    public SdlException(String message) {
        super(message);
    }
    public SdlException(Cause cause) {
        this(cause.cause().toString() + ": " + SDL_GetError().getString(0));
    }
}
