package sdl;

import java.lang.foreign.MemorySegment;

public class Texture {
    private final MemorySegment texture;
    private Texture(MemorySegment texture) {
        this.texture = texture;
    }
    public MemorySegment texture() {
        return texture;
    }
}
