package sdl;

import sdl.jextract.SDL_Point;
import sdl.jextract.SDL_Rect;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

public record Point(int x, int y) {
    public MemorySegment allocateAndFill(SegmentAllocator allocator) {
        var point = SDL_Rect.allocate(allocator);
        SDL_Point.x$set(point, x);
        SDL_Point.y$set(point, y);
        return point;
    }

    public boolean in(Rect rect) {
        return ((this.x >= rect.x()) && (this.x < (rect.x() + rect.w())) &&
                (this.y >= rect.y()) && (this.y < (rect.y() + rect.h())));
    }
}
