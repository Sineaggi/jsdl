// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_SysWMEvent {
 *     unsigned int type;
 *     unsigned int timestamp;
 *     struct SDL_SysWMmsg* msg;
 * };
 * }
 */
public class SDL_SysWMEvent {

    public static MemoryLayout $LAYOUT() {
        return constants$153.const$3;
    }
    public static VarHandle type$VH() {
        return constants$153.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$153.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$153.const$4.set(seg, 0L, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$153.const$4.get(seg, index * sizeof());    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$153.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle timestamp$VH() {
        return constants$153.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static int timestamp$get(MemorySegment seg) {
        return (int)constants$153.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int timestamp;
     * }
     */
    public static void timestamp$set(MemorySegment seg, int x) {
        constants$153.const$5.set(seg, 0L, x);
    }
    public static int timestamp$get(MemorySegment seg, long index) {
        return (int)constants$153.const$5.get(seg, index * sizeof());    }
    public static void timestamp$set(MemorySegment seg, long index, int x) {
        constants$153.const$5.set(seg, index * sizeof(), x);
    }
    public static VarHandle msg$VH() {
        return constants$154.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct SDL_SysWMmsg* msg;
     * }
     */
    public static MemorySegment msg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$154.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct SDL_SysWMmsg* msg;
     * }
     */
    public static void msg$set(MemorySegment seg, MemorySegment x) {
        constants$154.const$0.set(seg, 0L, x);
    }
    public static MemorySegment msg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$154.const$0.get(seg, index * sizeof());    }
    public static void msg$set(MemorySegment seg, long index, MemorySegment x) {
        constants$154.const$0.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


