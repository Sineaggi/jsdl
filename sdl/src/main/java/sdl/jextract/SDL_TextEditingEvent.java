// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_TextEditingEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     unsigned int windowID;
 *     char text[32];
 *     int start;
 *     int length;
 * };
 * }
 */
public class SDL_TextEditingEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$121.const$2;
    }
    public static VarHandle type$VH() {
        return constants$121.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$121.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$121.const$3.set(seg, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$121.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$121.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$121.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$121.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$121.const$4.set(seg, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$121.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$121.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle windowID$VH() {
        return constants$121.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static int windowID$get(MemorySegment seg) {
        return (int)constants$121.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static void windowID$set(MemorySegment seg, int x) {
        constants$121.const$5.set(seg, x);
    }
    public static int windowID$get(MemorySegment seg, long index) {
        return (int)constants$121.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void windowID$set(MemorySegment seg, long index, int x) {
        constants$121.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static MemorySegment text$slice(MemorySegment seg) {
        return seg.asSlice(12, 32);
    }
    public static VarHandle start$VH() {
        return constants$122.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int start;
     * }
     */
    public static int start$get(MemorySegment seg) {
        return (int)constants$122.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int start;
     * }
     */
    public static void start$set(MemorySegment seg, int x) {
        constants$122.const$0.set(seg, x);
    }
    public static int start$get(MemorySegment seg, long index) {
        return (int)constants$122.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void start$set(MemorySegment seg, long index, int x) {
        constants$122.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle length$VH() {
        return constants$122.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int length;
     * }
     */
    public static int length$get(MemorySegment seg) {
        return (int)constants$122.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int length;
     * }
     */
    public static void length$set(MemorySegment seg, int x) {
        constants$122.const$1.set(seg, x);
    }
    public static int length$get(MemorySegment seg, long index) {
        return (int)constants$122.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void length$set(MemorySegment seg, long index, int x) {
        constants$122.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


