package sdl.surface;

import java.lang.foreign.MemorySegment;

public class Palette {
    private final MemorySegment palette;
    public Palette(MemorySegment palette) {
        this.palette = palette;
    }
}
