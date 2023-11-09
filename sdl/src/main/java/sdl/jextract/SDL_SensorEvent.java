// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_SensorEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     int which;
 *     float data[6];
 *     unsigned long long timestamp_us;
 * };
 * }
 */
public class SDL_SensorEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$147.const$3;
    }
    public static VarHandle type$VH() {
        return constants$147.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$147.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$147.const$4.set(seg, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$147.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$147.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$147.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$147.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$147.const$5.set(seg, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$147.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$147.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle which$VH() {
        return constants$148.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int which;
     * }
     */
    public static int which$get(MemorySegment seg) {
        return (int)constants$148.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int which;
     * }
     */
    public static void which$set(MemorySegment seg, int x) {
        constants$148.const$0.set(seg, x);
    }
    public static int which$get(MemorySegment seg, long index) {
        return (int)constants$148.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void which$set(MemorySegment seg, long index, int x) {
        constants$148.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static MemorySegment data$slice(MemorySegment seg) {
        return seg.asSlice(12, 24);
    }
    public static VarHandle timestamp_us$VH() {
        return constants$148.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned long long timestamp_us;
     * }
     */
    public static long timestamp_us$get(MemorySegment seg) {
        return (long)constants$148.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned long long timestamp_us;
     * }
     */
    public static void timestamp_us$set(MemorySegment seg, long x) {
        constants$148.const$1.set(seg, x);
    }
    public static long timestamp_us$get(MemorySegment seg, long index) {
        return (long)constants$148.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp_us$set(MemorySegment seg, long index, long x) {
        constants$148.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


