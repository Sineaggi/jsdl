// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_DropEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     char* file;
 *     unsigned int windowID;
 * };
 * }
 */
public class SDL_DropEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$149.const$4;
    }
    public static VarHandle type$VH() {
        return constants$149.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$149.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$149.const$5.set(seg, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$149.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$149.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$150.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$150.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$150.const$0.set(seg, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$150.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$150.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle file$VH() {
        return constants$150.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* file;
     * }
     */
    public static MemorySegment file$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$150.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* file;
     * }
     */
    public static void file$set(MemorySegment seg, MemorySegment x) {
        constants$150.const$1.set(seg, x);
    }
    public static MemorySegment file$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$150.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void file$set(MemorySegment seg, long index, MemorySegment x) {
        constants$150.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle windowID$VH() {
        return constants$150.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static int windowID$get(MemorySegment seg) {
        return (int)constants$150.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static void windowID$set(MemorySegment seg, int x) {
        constants$150.const$2.set(seg, x);
    }
    public static int windowID$get(MemorySegment seg, long index) {
        return (int)constants$150.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void windowID$set(MemorySegment seg, long index, int x) {
        constants$150.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


