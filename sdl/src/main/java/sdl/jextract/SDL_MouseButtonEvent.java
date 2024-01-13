// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_MouseButtonEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     unsigned int windowID;
 *     unsigned int which;
 *     unsigned char button;
 *     unsigned char state;
 *     unsigned char clicks;
 *     unsigned char padding1;
 *     int x;
 *     int y;
 * };
 * }
 */
public class SDL_MouseButtonEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$125.const$5;
    }
    public static VarHandle type$VH() {
        return constants$126.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$126.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$126.const$0.set(seg, 0L, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$126.const$0.get(seg, index * sizeof());    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$126.const$0.set(seg, index * sizeof(), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$126.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$126.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$126.const$1.set(seg, 0L, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$126.const$1.get(seg, index * sizeof());    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$126.const$1.set(seg, index * sizeof(), x);
    }
    public static VarHandle windowID$VH() {
        return constants$126.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static int windowID$get(MemorySegment seg) {
        return (int)constants$126.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int windowID;
     * }
     */
    public static void windowID$set(MemorySegment seg, int x) {
        constants$126.const$2.set(seg, 0L, x);
    }
    public static int windowID$get(MemorySegment seg, long index) {
        return (int)constants$126.const$2.get(seg, index * sizeof());    }
    public static void windowID$set(MemorySegment seg, long index, int x) {
        constants$126.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle which$VH() {
        return constants$126.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int which;
     * }
     */
    public static int which$get(MemorySegment seg) {
        return (int)constants$126.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int which;
     * }
     */
    public static void which$set(MemorySegment seg, int x) {
        constants$126.const$3.set(seg, 0L, x);
    }
    public static int which$get(MemorySegment seg, long index) {
        return (int)constants$126.const$3.get(seg, index * sizeof());    }
    public static void which$set(MemorySegment seg, long index, int x) {
        constants$126.const$3.set(seg, index * sizeof(), x);
    }
    public static VarHandle button$VH() {
        return constants$126.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char button;
     * }
     */
    public static byte button$get(MemorySegment seg) {
        return (byte)constants$126.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char button;
     * }
     */
    public static void button$set(MemorySegment seg, byte x) {
        constants$126.const$4.set(seg, 0L, x);
    }
    public static byte button$get(MemorySegment seg, long index) {
        return (byte)constants$126.const$4.get(seg, index * sizeof());    }
    public static void button$set(MemorySegment seg, long index, byte x) {
        constants$126.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle state$VH() {
        return constants$126.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char state;
     * }
     */
    public static byte state$get(MemorySegment seg) {
        return (byte)constants$126.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char state;
     * }
     */
    public static void state$set(MemorySegment seg, byte x) {
        constants$126.const$5.set(seg, 0L, x);
    }
    public static byte state$get(MemorySegment seg, long index) {
        return (byte)constants$126.const$5.get(seg, index * sizeof());    }
    public static void state$set(MemorySegment seg, long index, byte x) {
        constants$126.const$5.set(seg, index * sizeof(), x);
    }
    public static VarHandle clicks$VH() {
        return constants$127.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char clicks;
     * }
     */
    public static byte clicks$get(MemorySegment seg) {
        return (byte)constants$127.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char clicks;
     * }
     */
    public static void clicks$set(MemorySegment seg, byte x) {
        constants$127.const$0.set(seg, 0L, x);
    }
    public static byte clicks$get(MemorySegment seg, long index) {
        return (byte)constants$127.const$0.get(seg, index * sizeof());    }
    public static void clicks$set(MemorySegment seg, long index, byte x) {
        constants$127.const$0.set(seg, index * sizeof(), x);
    }
    public static VarHandle padding1$VH() {
        return constants$127.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char padding1;
     * }
     */
    public static byte padding1$get(MemorySegment seg) {
        return (byte)constants$127.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char padding1;
     * }
     */
    public static void padding1$set(MemorySegment seg, byte x) {
        constants$127.const$1.set(seg, 0L, x);
    }
    public static byte padding1$get(MemorySegment seg, long index) {
        return (byte)constants$127.const$1.get(seg, index * sizeof());    }
    public static void padding1$set(MemorySegment seg, long index, byte x) {
        constants$127.const$1.set(seg, index * sizeof(), x);
    }
    public static VarHandle x$VH() {
        return constants$127.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int x;
     * }
     */
    public static int x$get(MemorySegment seg) {
        return (int)constants$127.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int x;
     * }
     */
    public static void x$set(MemorySegment seg, int x) {
        constants$127.const$2.set(seg, 0L, x);
    }
    public static int x$get(MemorySegment seg, long index) {
        return (int)constants$127.const$2.get(seg, index * sizeof());    }
    public static void x$set(MemorySegment seg, long index, int x) {
        constants$127.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle y$VH() {
        return constants$127.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int y;
     * }
     */
    public static int y$get(MemorySegment seg) {
        return (int)constants$127.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int y;
     * }
     */
    public static void y$set(MemorySegment seg, int x) {
        constants$127.const$3.set(seg, 0L, x);
    }
    public static int y$get(MemorySegment seg, long index) {
        return (int)constants$127.const$3.get(seg, index * sizeof());    }
    public static void y$set(MemorySegment seg, long index, int x) {
        constants$127.const$3.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


