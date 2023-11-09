// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_RendererInfo {
 *     char* name;
 *     unsigned int flags;
 *     unsigned int num_texture_formats;
 *     unsigned int texture_formats[16];
 *     int max_texture_width;
 *     int max_texture_height;
 * };
 * }
 */
public class SDL_RendererInfo {

    public static MemoryLayout $LAYOUT() {
        return constants$157.const$1;
    }
    public static VarHandle name$VH() {
        return constants$157.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* name;
     * }
     */
    public static MemorySegment name$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$157.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* name;
     * }
     */
    public static void name$set(MemorySegment seg, MemorySegment x) {
        constants$157.const$2.set(seg, x);
    }
    public static MemorySegment name$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$157.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void name$set(MemorySegment seg, long index, MemorySegment x) {
        constants$157.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle flags$VH() {
        return constants$157.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int flags;
     * }
     */
    public static int flags$get(MemorySegment seg) {
        return (int)constants$157.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int flags;
     * }
     */
    public static void flags$set(MemorySegment seg, int x) {
        constants$157.const$3.set(seg, x);
    }
    public static int flags$get(MemorySegment seg, long index) {
        return (int)constants$157.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void flags$set(MemorySegment seg, long index, int x) {
        constants$157.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle num_texture_formats$VH() {
        return constants$157.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int num_texture_formats;
     * }
     */
    public static int num_texture_formats$get(MemorySegment seg) {
        return (int)constants$157.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int num_texture_formats;
     * }
     */
    public static void num_texture_formats$set(MemorySegment seg, int x) {
        constants$157.const$4.set(seg, x);
    }
    public static int num_texture_formats$get(MemorySegment seg, long index) {
        return (int)constants$157.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void num_texture_formats$set(MemorySegment seg, long index, int x) {
        constants$157.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static MemorySegment texture_formats$slice(MemorySegment seg) {
        return seg.asSlice(16, 64);
    }
    public static VarHandle max_texture_width$VH() {
        return constants$157.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int max_texture_width;
     * }
     */
    public static int max_texture_width$get(MemorySegment seg) {
        return (int)constants$157.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int max_texture_width;
     * }
     */
    public static void max_texture_width$set(MemorySegment seg, int x) {
        constants$157.const$5.set(seg, x);
    }
    public static int max_texture_width$get(MemorySegment seg, long index) {
        return (int)constants$157.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void max_texture_width$set(MemorySegment seg, long index, int x) {
        constants$157.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle max_texture_height$VH() {
        return constants$158.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int max_texture_height;
     * }
     */
    public static int max_texture_height$get(MemorySegment seg) {
        return (int)constants$158.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int max_texture_height;
     * }
     */
    public static void max_texture_height$set(MemorySegment seg, int x) {
        constants$158.const$0.set(seg, x);
    }
    public static int max_texture_height$get(MemorySegment seg, long index) {
        return (int)constants$158.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void max_texture_height$set(MemorySegment seg, long index, int x) {
        constants$158.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


