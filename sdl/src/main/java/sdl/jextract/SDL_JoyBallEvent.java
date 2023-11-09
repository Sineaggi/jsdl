// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_JoyBallEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     int which;
 *     unsigned char ball;
 *     unsigned char padding1;
 *     unsigned char padding2;
 *     unsigned char padding3;
 *     short xrel;
 *     short yrel;
 * };
 * }
 */
public class SDL_JoyBallEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$128.const$2;
    }
    public static VarHandle type$VH() {
        return constants$128.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$128.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$128.const$3.set(seg, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$128.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$128.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$128.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$128.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$128.const$4.set(seg, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$128.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$128.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle which$VH() {
        return constants$128.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int which;
     * }
     */
    public static int which$get(MemorySegment seg) {
        return (int)constants$128.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int which;
     * }
     */
    public static void which$set(MemorySegment seg, int x) {
        constants$128.const$5.set(seg, x);
    }
    public static int which$get(MemorySegment seg, long index) {
        return (int)constants$128.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void which$set(MemorySegment seg, long index, int x) {
        constants$128.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle ball$VH() {
        return constants$129.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char ball;
     * }
     */
    public static byte ball$get(MemorySegment seg) {
        return (byte)constants$129.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char ball;
     * }
     */
    public static void ball$set(MemorySegment seg, byte x) {
        constants$129.const$0.set(seg, x);
    }
    public static byte ball$get(MemorySegment seg, long index) {
        return (byte)constants$129.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void ball$set(MemorySegment seg, long index, byte x) {
        constants$129.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle padding1$VH() {
        return constants$129.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char padding1;
     * }
     */
    public static byte padding1$get(MemorySegment seg) {
        return (byte)constants$129.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char padding1;
     * }
     */
    public static void padding1$set(MemorySegment seg, byte x) {
        constants$129.const$1.set(seg, x);
    }
    public static byte padding1$get(MemorySegment seg, long index) {
        return (byte)constants$129.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void padding1$set(MemorySegment seg, long index, byte x) {
        constants$129.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle padding2$VH() {
        return constants$129.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char padding2;
     * }
     */
    public static byte padding2$get(MemorySegment seg) {
        return (byte)constants$129.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char padding2;
     * }
     */
    public static void padding2$set(MemorySegment seg, byte x) {
        constants$129.const$2.set(seg, x);
    }
    public static byte padding2$get(MemorySegment seg, long index) {
        return (byte)constants$129.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void padding2$set(MemorySegment seg, long index, byte x) {
        constants$129.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle padding3$VH() {
        return constants$129.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char padding3;
     * }
     */
    public static byte padding3$get(MemorySegment seg) {
        return (byte)constants$129.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char padding3;
     * }
     */
    public static void padding3$set(MemorySegment seg, byte x) {
        constants$129.const$3.set(seg, x);
    }
    public static byte padding3$get(MemorySegment seg, long index) {
        return (byte)constants$129.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void padding3$set(MemorySegment seg, long index, byte x) {
        constants$129.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle xrel$VH() {
        return constants$129.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * short xrel;
     * }
     */
    public static short xrel$get(MemorySegment seg) {
        return (short)constants$129.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * short xrel;
     * }
     */
    public static void xrel$set(MemorySegment seg, short x) {
        constants$129.const$4.set(seg, x);
    }
    public static short xrel$get(MemorySegment seg, long index) {
        return (short)constants$129.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void xrel$set(MemorySegment seg, long index, short x) {
        constants$129.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle yrel$VH() {
        return constants$129.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * short yrel;
     * }
     */
    public static short yrel$get(MemorySegment seg) {
        return (short)constants$129.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * short yrel;
     * }
     */
    public static void yrel$set(MemorySegment seg, short x) {
        constants$129.const$5.set(seg, x);
    }
    public static short yrel$get(MemorySegment seg, long index) {
        return (short)constants$129.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void yrel$set(MemorySegment seg, long index, short x) {
        constants$129.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


