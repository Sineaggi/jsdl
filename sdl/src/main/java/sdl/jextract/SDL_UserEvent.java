// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_UserEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     unsigned int windowID;
 *     int code;
 *     void* data1;
 *     void* data2;
 * };
 * }
 */
public class SDL_UserEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$152.const$2;
    }
    public static VarHandle type$VH() {
        return constants$152.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$152.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$152.const$3.set(seg, 0L, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$152.const$3.get(seg, index * sizeof());    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$152.const$3.set(seg, index * sizeof(), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$152.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$152.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$152.const$4.set(seg, 0L, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$152.const$4.get(seg, index * sizeof());    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$152.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle windowID$VH() {
        return constants$152.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static int windowID$get(MemorySegment seg) {
        return (int)constants$152.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static void windowID$set(MemorySegment seg, int x) {
        constants$152.const$5.set(seg, 0L, x);
    }
    public static int windowID$get(MemorySegment seg, long index) {
        return (int)constants$152.const$5.get(seg, index * sizeof());    }
    public static void windowID$set(MemorySegment seg, long index, int x) {
        constants$152.const$5.set(seg, index * sizeof(), x);
    }
    public static VarHandle code$VH() {
        return constants$153.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int code;
     * }
     */
    public static int code$get(MemorySegment seg) {
        return (int)constants$153.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int code;
     * }
     */
    public static void code$set(MemorySegment seg, int x) {
        constants$153.const$0.set(seg, 0L, x);
    }
    public static int code$get(MemorySegment seg, long index) {
        return (int)constants$153.const$0.get(seg, index * sizeof());    }
    public static void code$set(MemorySegment seg, long index, int x) {
        constants$153.const$0.set(seg, index * sizeof(), x);
    }
    public static VarHandle data1$VH() {
        return constants$153.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* data1;
     * }
     */
    public static MemorySegment data1$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$153.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* data1;
     * }
     */
    public static void data1$set(MemorySegment seg, MemorySegment x) {
        constants$153.const$1.set(seg, 0L, x);
    }
    public static MemorySegment data1$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$153.const$1.get(seg, index * sizeof());    }
    public static void data1$set(MemorySegment seg, long index, MemorySegment x) {
        constants$153.const$1.set(seg, index * sizeof(), x);
    }
    public static VarHandle data2$VH() {
        return constants$153.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* data2;
     * }
     */
    public static MemorySegment data2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$153.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* data2;
     * }
     */
    public static void data2$set(MemorySegment seg, MemorySegment x) {
        constants$153.const$2.set(seg, 0L, x);
    }
    public static MemorySegment data2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$153.const$2.get(seg, index * sizeof());    }
    public static void data2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$153.const$2.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


