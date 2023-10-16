package sdl;

import java.lang.foreign.MemorySegment;

import static sdl.Cause.SetTextureColorMod;
import static sdl.jextract.sdl_h.*;

public class Texture {
    private final MemorySegment texture;
    public Texture(MemorySegment texture) {
        this.texture = texture;
    }
    public MemorySegment texture() {
        return texture;
    }

    public void setColorMod(byte r, byte g, byte b) {
        if (SDL_SetTextureColorMod(texture, r, g, b) != 0) {
            throw new SdlException(SetTextureColorMod);
        }
    }
}
