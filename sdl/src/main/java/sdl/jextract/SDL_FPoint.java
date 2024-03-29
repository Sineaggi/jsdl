// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_FPoint {
 *     float x;
 *     float y;
 * };
 * }
 */
public class SDL_FPoint {

    public static MemoryLayout $LAYOUT() {
        return constants$45.const$1;
    }
    public static VarHandle x$VH() {
        return constants$45.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float x;
     * }
     */
    public static float x$get(MemorySegment seg) {
        return (float)constants$45.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float x;
     * }
     */
    public static void x$set(MemorySegment seg, float x) {
        constants$45.const$2.set(seg, 0L, x);
    }
    public static float x$get(MemorySegment seg, long index) {
        return (float)constants$45.const$2.get(seg, index * sizeof());    }
    public static void x$set(MemorySegment seg, long index, float x) {
        constants$45.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle y$VH() {
        return constants$45.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float y;
     * }
     */
    public static float y$get(MemorySegment seg) {
        return (float)constants$45.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float y;
     * }
     */
    public static void y$set(MemorySegment seg, float x) {
        constants$45.const$3.set(seg, 0L, x);
    }
    public static float y$get(MemorySegment seg, long index) {
        return (float)constants$45.const$3.get(seg, index * sizeof());    }
    public static void y$set(MemorySegment seg, long index, float x) {
        constants$45.const$3.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


