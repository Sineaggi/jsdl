package sdl.surface;

import sdl.SdlException;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static sdl.Cause.LoadBMP_RW;
import static sdl.jextract.sdl_h.*;

public class Surface implements AutoCloseable {
    private final MemorySegment surface;
    private Surface(MemorySegment surface) {
        this.surface = surface;
    }

    public MemorySegment surface() {
        return surface;
    }

    public Surface loadBMP(String file) {
        MemorySegment surface;
        try (var arena = Arena.ofConfined()) {
            surface = SDL_LoadBMP_RW(SDL_RWFromFile(arena.allocateUtf8String(file), arena.allocateUtf8String("rb")), 1);
            if (surface.equals(MemorySegment.NULL)) {
                throw new SdlException(LoadBMP_RW);
            }
            return new Surface(surface);
        }
    }

    @Override
    public void close() {
        SDL_FreeSurface(surface);
    }
}
