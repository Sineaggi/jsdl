package sdl.video;

import sdl.SdlException;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static sdl.Cause.CreateWindow;
import static sdl.jextract.sdl_h.*;

public class Window {
    private final MemorySegment window;
    private Window(MemorySegment window) {
        this.window = window;
    }
    public MemorySegment window() {
        return window;
    }

    public static Window create(String title, int x, int y, int w, int h, int flags) {
        MemorySegment window;
        try (var arena = Arena.ofConfined()) {
            window = SDL_CreateWindow(arena.allocateUtf8String(title), x,
                    y, w,
                    h, flags);
        }
        if (window.equals(MemorySegment.NULL)) {
            throw new SdlException(CreateWindow);
        }
        return new Window(window);
    }
    public void setWindowTitle(String title) {
        try (var arena = Arena.ofConfined()) {
            SDL_SetWindowTitle(window, arena.allocateUtf8String(title));
        }
    }

    public void destroy() {
        SDL_DestroyWindow(window);
    }
}
