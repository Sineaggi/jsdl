package sdl;

import sdl.jextract.SDL_Rect;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

public record Rect(int x, int y, int w, int h) {
    public MemorySegment allocateAndFill(SegmentAllocator allocator) {
        var rect = SDL_Rect.allocate(allocator);
        SDL_Rect.x$set(rect, x);
        SDL_Rect.y$set(rect, y);
        SDL_Rect.w$set(rect, w);
        SDL_Rect.h$set(rect, h);
        return rect;
    }
}
