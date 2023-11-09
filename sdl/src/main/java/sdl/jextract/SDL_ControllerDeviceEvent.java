// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_ControllerDeviceEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     int which;
 * };
 * }
 */
public class SDL_ControllerDeviceEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$137.const$1;
    }
    public static VarHandle type$VH() {
        return constants$137.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$137.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$137.const$2.set(seg, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$137.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$137.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$137.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$137.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$137.const$3.set(seg, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$137.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$137.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle which$VH() {
        return constants$137.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int which;
     * }
     */
    public static int which$get(MemorySegment seg) {
        return (int)constants$137.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int which;
     * }
     */
    public static void which$set(MemorySegment seg, int x) {
        constants$137.const$4.set(seg, x);
    }
    public static int which$get(MemorySegment seg, long index) {
        return (int)constants$137.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void which$set(MemorySegment seg, long index, int x) {
        constants$137.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


