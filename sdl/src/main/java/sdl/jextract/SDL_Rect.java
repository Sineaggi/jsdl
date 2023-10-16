// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_Rect {
 *     int x;
 *     int y;
 *     int w;
 *     int h;
 * };
 * }
 */
public class SDL_Rect {

    public static MemoryLayout $LAYOUT() {
        return constants$57.const$0;
    }
    public static VarHandle x$VH() {
        return constants$57.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int x;
     * }
     */
    public static int x$get(MemorySegment seg) {
        return (int)constants$57.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int x;
     * }
     */
    public static void x$set(MemorySegment seg, int x) {
        constants$57.const$1.set(seg, x);
    }
    public static int x$get(MemorySegment seg, long index) {
        return (int)constants$57.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void x$set(MemorySegment seg, long index, int x) {
        constants$57.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle y$VH() {
        return constants$57.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int y;
     * }
     */
    public static int y$get(MemorySegment seg) {
        return (int)constants$57.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int y;
     * }
     */
    public static void y$set(MemorySegment seg, int x) {
        constants$57.const$2.set(seg, x);
    }
    public static int y$get(MemorySegment seg, long index) {
        return (int)constants$57.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void y$set(MemorySegment seg, long index, int x) {
        constants$57.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle w$VH() {
        return constants$57.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int w;
     * }
     */
    public static int w$get(MemorySegment seg) {
        return (int)constants$57.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int w;
     * }
     */
    public static void w$set(MemorySegment seg, int x) {
        constants$57.const$3.set(seg, x);
    }
    public static int w$get(MemorySegment seg, long index) {
        return (int)constants$57.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void w$set(MemorySegment seg, long index, int x) {
        constants$57.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle h$VH() {
        return constants$57.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int h;
     * }
     */
    public static int h$get(MemorySegment seg) {
        return (int)constants$57.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int h;
     * }
     */
    public static void h$set(MemorySegment seg, int x) {
        constants$57.const$4.set(seg, x);
    }
    public static int h$get(MemorySegment seg, long index) {
        return (int)constants$57.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void h$set(MemorySegment seg, long index, int x) {
        constants$57.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


