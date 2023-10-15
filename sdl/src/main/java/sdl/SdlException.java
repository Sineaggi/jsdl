package sdl;

import static sdl.jextract.SDL_subset_h.*;

public class SdlException extends RuntimeException {
    private SdlException(String message) {
        super(message);
    }
    public SdlException(Cause cause) {
        this(STR."\{cause.cause()}: \{SDL_GetError()}");
    }
}
