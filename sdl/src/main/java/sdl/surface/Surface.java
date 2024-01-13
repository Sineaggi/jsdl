package sdl.surface;

import sdl.SdlException;
import sdl.jextract.SDL_Surface;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static sdl.Cause.SetColorKey;
import static sdl.jextract.sdl_h.*;

public class Surface implements AutoCloseable {
    private final MemorySegment surface;
    private Surface(MemorySegment surface) {
        this.surface = surface;
    }

    public MemorySegment surface() {
        return surface;
    }

    public static Surface loadBMP(String file) {
        MemorySegment surface;
        try (var arena = Arena.ofConfined()) {
            // SDL_GetError().getString(0);
            MemorySegment src = SDL_RWFromFile(arena.allocateFrom(file), arena.allocateFrom("rb"));
            if (src.equals(MemorySegment.NULL)) {
                throw new SdlException("Couldn't load " + file + ": " + SDL_GetError().getString(0));
            }
            surface = SDL_LoadBMP_RW(src, 1);
            if (surface.equals(MemorySegment.NULL)) {
                throw new SdlException("Couldn't load " + file + ": " + SDL_GetError().getString(0));
            }
            return new Surface(surface);
        }
    }

    public void setColorKey(boolean flag, int key) {
        if (SDL_SetColorKey(surface, flag ? SDL_TRUE() : SDL_FALSE(), key) != 0) {
            throw new SdlException(SetColorKey);
        }
    }

    @Override
    public void close() {
        SDL_FreeSurface(surface);
    }

    public Format format() {
        return new Format(SDL_Surface.format$get(surface));
    }

    public MemorySegment pixels() {
        return SDL_Surface.pixels$get(surface);
    }
}
