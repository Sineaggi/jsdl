package sdl.render;

import sdl.SdlException;
import sdl.video.Window;

import java.lang.foreign.MemorySegment;

import static sdl.Cause.CreateRenderer;
import static sdl.jextract.SDL_subset_h_1.SDL_CreateRenderer;
import static sdl.jextract.SDL_subset_h_1.SDL_RenderSetLogicalSize;

public class Renderer {
    private final MemorySegment renderer;
    private Renderer(MemorySegment renderer) {
        this.renderer = renderer;
    }

    public static Renderer create(Window window, int index, int flags) {
        MemorySegment renderer = SDL_CreateRenderer(window.window(), index, flags);
        if (renderer.equals(MemorySegment.NULL)) {
            throw new SdlException(CreateRenderer);
        }
        return new Renderer(renderer);
    }

    public void setLogicalSize(int w, int h) {
        // todo: handle response code
        SDL_RenderSetLogicalSize(renderer, w, h);
    }
}
