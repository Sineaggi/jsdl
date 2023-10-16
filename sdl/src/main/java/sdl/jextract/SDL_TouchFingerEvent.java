// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_TouchFingerEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     long long touchId;
 *     long long fingerId;
 *     float x;
 *     float y;
 *     float dx;
 *     float dy;
 *     float pressure;
 *     unsigned int windowID;
 * };
 * }
 */
public class SDL_TouchFingerEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$150.const$5;
    }
    public static VarHandle type$VH() {
        return constants$151.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$151.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$151.const$0.set(seg, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$151.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$151.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$151.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$151.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$151.const$1.set(seg, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$151.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$151.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle touchId$VH() {
        return constants$151.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * long long touchId;
     * }
     */
    public static long touchId$get(MemorySegment seg) {
        return (long)constants$151.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * long long touchId;
     * }
     */
    public static void touchId$set(MemorySegment seg, long x) {
        constants$151.const$2.set(seg, x);
    }
    public static long touchId$get(MemorySegment seg, long index) {
        return (long)constants$151.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void touchId$set(MemorySegment seg, long index, long x) {
        constants$151.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle fingerId$VH() {
        return constants$151.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * long long fingerId;
     * }
     */
    public static long fingerId$get(MemorySegment seg) {
        return (long)constants$151.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * long long fingerId;
     * }
     */
    public static void fingerId$set(MemorySegment seg, long x) {
        constants$151.const$3.set(seg, x);
    }
    public static long fingerId$get(MemorySegment seg, long index) {
        return (long)constants$151.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void fingerId$set(MemorySegment seg, long index, long x) {
        constants$151.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle x$VH() {
        return constants$151.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float x;
     * }
     */
    public static float x$get(MemorySegment seg) {
        return (float)constants$151.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float x;
     * }
     */
    public static void x$set(MemorySegment seg, float x) {
        constants$151.const$4.set(seg, x);
    }
    public static float x$get(MemorySegment seg, long index) {
        return (float)constants$151.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void x$set(MemorySegment seg, long index, float x) {
        constants$151.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle y$VH() {
        return constants$151.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float y;
     * }
     */
    public static float y$get(MemorySegment seg) {
        return (float)constants$151.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float y;
     * }
     */
    public static void y$set(MemorySegment seg, float x) {
        constants$151.const$5.set(seg, x);
    }
    public static float y$get(MemorySegment seg, long index) {
        return (float)constants$151.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void y$set(MemorySegment seg, long index, float x) {
        constants$151.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle dx$VH() {
        return constants$152.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float dx;
     * }
     */
    public static float dx$get(MemorySegment seg) {
        return (float)constants$152.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float dx;
     * }
     */
    public static void dx$set(MemorySegment seg, float x) {
        constants$152.const$0.set(seg, x);
    }
    public static float dx$get(MemorySegment seg, long index) {
        return (float)constants$152.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void dx$set(MemorySegment seg, long index, float x) {
        constants$152.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle dy$VH() {
        return constants$152.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float dy;
     * }
     */
    public static float dy$get(MemorySegment seg) {
        return (float)constants$152.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float dy;
     * }
     */
    public static void dy$set(MemorySegment seg, float x) {
        constants$152.const$1.set(seg, x);
    }
    public static float dy$get(MemorySegment seg, long index) {
        return (float)constants$152.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void dy$set(MemorySegment seg, long index, float x) {
        constants$152.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle pressure$VH() {
        return constants$152.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * float pressure;
     * }
     */
    public static float pressure$get(MemorySegment seg) {
        return (float)constants$152.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * float pressure;
     * }
     */
    public static void pressure$set(MemorySegment seg, float x) {
        constants$152.const$2.set(seg, x);
    }
    public static float pressure$get(MemorySegment seg, long index) {
        return (float)constants$152.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void pressure$set(MemorySegment seg, long index, float x) {
        constants$152.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle windowID$VH() {
        return constants$152.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static int windowID$get(MemorySegment seg) {
        return (int)constants$152.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static void windowID$set(MemorySegment seg, int x) {
        constants$152.const$3.set(seg, x);
    }
    public static int windowID$get(MemorySegment seg, long index) {
        return (int)constants$152.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void windowID$set(MemorySegment seg, long index, int x) {
        constants$152.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


