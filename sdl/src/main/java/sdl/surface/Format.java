package sdl.surface;

import sdl.jextract.SDL_PixelFormat;

import java.lang.foreign.MemorySegment;

public class Format {
    private final MemorySegment format;
    public Format(MemorySegment format) {
        this.format = format;
    }

    public Palette palette() {
        MemorySegment palette = SDL_PixelFormat.palette$get(format);
        if (palette.equals(MemorySegment.NULL)) {
            return null;
        }
        return new Palette(palette);
    }
}
