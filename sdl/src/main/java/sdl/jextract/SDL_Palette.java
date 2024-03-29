// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_Palette {
 *     int ncolors;
 *     struct SDL_Color* colors;
 *     unsigned int version;
 *     int refcount;
 * };
 * }
 */
public class SDL_Palette {

    public static MemoryLayout $LAYOUT() {
        return constants$37.const$1;
    }
    public static VarHandle ncolors$VH() {
        return constants$37.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int ncolors;
     * }
     */
    public static int ncolors$get(MemorySegment seg) {
        return (int)constants$37.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int ncolors;
     * }
     */
    public static void ncolors$set(MemorySegment seg, int x) {
        constants$37.const$2.set(seg, 0L, x);
    }
    public static int ncolors$get(MemorySegment seg, long index) {
        return (int)constants$37.const$2.get(seg, index * sizeof());    }
    public static void ncolors$set(MemorySegment seg, long index, int x) {
        constants$37.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle colors$VH() {
        return constants$37.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct SDL_Color* colors;
     * }
     */
    public static MemorySegment colors$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$37.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct SDL_Color* colors;
     * }
     */
    public static void colors$set(MemorySegment seg, MemorySegment x) {
        constants$37.const$3.set(seg, 0L, x);
    }
    public static MemorySegment colors$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$37.const$3.get(seg, index * sizeof());    }
    public static void colors$set(MemorySegment seg, long index, MemorySegment x) {
        constants$37.const$3.set(seg, index * sizeof(), x);
    }
    public static VarHandle version$VH() {
        return constants$37.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int version;
     * }
     */
    public static int version$get(MemorySegment seg) {
        return (int)constants$37.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int version;
     * }
     */
    public static void version$set(MemorySegment seg, int x) {
        constants$37.const$4.set(seg, 0L, x);
    }
    public static int version$get(MemorySegment seg, long index) {
        return (int)constants$37.const$4.get(seg, index * sizeof());    }
    public static void version$set(MemorySegment seg, long index, int x) {
        constants$37.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle refcount$VH() {
        return constants$37.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int refcount;
     * }
     */
    public static int refcount$get(MemorySegment seg) {
        return (int)constants$37.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int refcount;
     * }
     */
    public static void refcount$set(MemorySegment seg, int x) {
        constants$37.const$5.set(seg, 0L, x);
    }
    public static int refcount$get(MemorySegment seg, long index) {
        return (int)constants$37.const$5.get(seg, index * sizeof());    }
    public static void refcount$set(MemorySegment seg, long index, int x) {
        constants$37.const$5.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


