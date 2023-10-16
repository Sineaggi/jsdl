package sdl.render;

import sdl.*;
import sdl.surface.Surface;
import sdl.video.Window;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static sdl.Cause.*;
import static sdl.jextract.sdl_h_1.*;

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

    public void setDrawColor(byte r, byte g, byte b, byte a) {
        if (SDL_SetRenderDrawColor(renderer, r, g, b, a) != 0) {
            throw new SdlException(SetRenderDrawColor);
        }
    }

    public void clear() {
        if (SDL_RenderClear(renderer) != 0) {
            throw new SdlException(RenderClear);
        }
    }

    public void present() {
        SDL_RenderPresent(renderer);
    }

    public void copy(Texture texture, Rect srcRect, Rect dstRect, double angle, Point center, RendererFlip flip) {
        try (var arena = Arena.ofConfined()) {
            SDL_RenderCopyEx(
                    renderer,
                    texture.texture(),
                    srcRect == null ? MemorySegment.NULL : srcRect.allocateAndFill(arena),
                    dstRect == null ? MemorySegment.NULL : dstRect.allocateAndFill(arena),
                    angle,
                    center == null ? MemorySegment.NULL : center.allocateAndFill(arena),
                    flip.value()
            );
        }
    }

    public void copy(Texture texture, Rect srcRect, Rect dstRect) {
        try (var arena = Arena.ofConfined()) {
            SDL_RenderCopy(
                    renderer,
                    texture.texture(),
                    srcRect == null ? MemorySegment.NULL : srcRect.allocateAndFill(arena),
                    dstRect == null ? MemorySegment.NULL : dstRect.allocateAndFill(arena)
            );
        }
    }

    public void destroy() {
        SDL_DestroyRenderer(renderer);
    }

    public Texture createTexture(Surface surface) {
        MemorySegment texture;
        if ((texture = SDL_CreateTextureFromSurface(renderer, surface.surface())).equals(MemorySegment.NULL)) {
            throw new SdlException(CreateTextureFromSurface);
        }
        return new Texture(texture);
    }
}
