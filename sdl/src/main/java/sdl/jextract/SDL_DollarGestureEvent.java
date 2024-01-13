// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_DollarGestureEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     long long touchId;
 *     long long gestureId;
 *     unsigned int numFingers;
 *     float error;
 *     float x;
 *     float y;
 * };
 * }
 */
public class SDL_DollarGestureEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$148.const$1;
    }
    public static VarHandle type$VH() {
        return constants$148.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$148.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$148.const$2.set(seg, 0L, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$148.const$2.get(seg, index * sizeof());    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$148.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$148.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$148.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$148.const$3.set(seg, 0L, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$148.const$3.get(seg, index * sizeof());    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$148.const$3.set(seg, index * sizeof(), x);
    }
    public static VarHandle touchId$VH() {
        return constants$148.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * long long touchId;
     * }
     */
    public static long touchId$get(MemorySegment seg) {
        return (long)constants$148.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * long long touchId;
     * }
     */
    public static void touchId$set(MemorySegment seg, long x) {
        constants$148.const$4.set(seg, 0L, x);
    }
    public static long touchId$get(MemorySegment seg, long index) {
        return (long)constants$148.const$4.get(seg, index * sizeof());    }
    public static void touchId$set(MemorySegment seg, long index, long x) {
        constants$148.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle gestureId$VH() {
        return constants$148.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * long long gestureId;
     * }
     */
    public static long gestureId$get(MemorySegment seg) {
        return (long)constants$148.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * long long gestureId;
     * }
     */
    public static void gestureId$set(MemorySegment seg, long x) {
        constants$148.const$5.set(seg, 0L, x);
    }
    public static long gestureId$get(MemorySegment seg, long index) {
        return (long)constants$148.const$5.get(seg, index * sizeof());    }
    public static void gestureId$set(MemorySegment seg, long index, long x) {
        constants$148.const$5.set(seg, index * sizeof(), x);
    }
    public static VarHandle numFingers$VH() {
        return constants$149.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int numFingers;
     * }
     */
    public static int numFingers$get(MemorySegment seg) {
        return (int)constants$149.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int numFingers;
     * }
     */
    public static void numFingers$set(MemorySegment seg, int x) {
        constants$149.const$0.set(seg, 0L, x);
    }
    public static int numFingers$get(MemorySegment seg, long index) {
        return (int)constants$149.const$0.get(seg, index * sizeof());    }
    public static void numFingers$set(MemorySegment seg, long index, int x) {
        constants$149.const$0.set(seg, index * sizeof(), x);
    }
    public static VarHandle error$VH() {
        return constants$149.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float error;
     * }
     */
    public static float error$get(MemorySegment seg) {
        return (float)constants$149.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float error;
     * }
     */
    public static void error$set(MemorySegment seg, float x) {
        constants$149.const$1.set(seg, 0L, x);
    }
    public static float error$get(MemorySegment seg, long index) {
        return (float)constants$149.const$1.get(seg, index * sizeof());    }
    public static void error$set(MemorySegment seg, long index, float x) {
        constants$149.const$1.set(seg, index * sizeof(), x);
    }
    public static VarHandle x$VH() {
        return constants$149.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float x;
     * }
     */
    public static float x$get(MemorySegment seg) {
        return (float)constants$149.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float x;
     * }
     */
    public static void x$set(MemorySegment seg, float x) {
        constants$149.const$2.set(seg, 0L, x);
    }
    public static float x$get(MemorySegment seg, long index) {
        return (float)constants$149.const$2.get(seg, index * sizeof());    }
    public static void x$set(MemorySegment seg, long index, float x) {
        constants$149.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle y$VH() {
        return constants$149.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float y;
     * }
     */
    public static float y$get(MemorySegment seg) {
        return (float)constants$149.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float y;
     * }
     */
    public static void y$set(MemorySegment seg, float x) {
        constants$149.const$3.set(seg, 0L, x);
    }
    public static float y$get(MemorySegment seg, long index) {
        return (float)constants$149.const$3.get(seg, index * sizeof());    }
    public static void y$set(MemorySegment seg, long index, float x) {
        constants$149.const$3.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


