package sdl;

import static sdl.jextract.sdl_h.*;

public class SdlException extends RuntimeException {
    public SdlException(String message) {
        super(message);
    }
    public SdlException(Cause cause) {
        this(STR."\{cause.cause()}: \{SDL_GetError().getUtf8String(0)}");
    }
}
