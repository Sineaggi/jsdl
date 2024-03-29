// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_Surface {
 *     unsigned int flags;
 *     struct SDL_PixelFormat* format;
 *     int w;
 *     int h;
 *     int pitch;
 *     void* pixels;
 *     void* userdata;
 *     int locked;
 *     void* list_blitmap;
 *     struct SDL_Rect clip_rect;
 *     struct SDL_BlitMap* map;
 *     int refcount;
 * };
 * }
 */
public class SDL_Surface {

    public static MemoryLayout $LAYOUT() {
        return constants$49.const$3;
    }
    public static VarHandle flags$VH() {
        return constants$49.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int flags;
     * }
     */
    public static int flags$get(MemorySegment seg) {
        return (int)constants$49.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int flags;
     * }
     */
    public static void flags$set(MemorySegment seg, int x) {
        constants$49.const$4.set(seg, 0L, x);
    }
    public static int flags$get(MemorySegment seg, long index) {
        return (int)constants$49.const$4.get(seg, index * sizeof());    }
    public static void flags$set(MemorySegment seg, long index, int x) {
        constants$49.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle format$VH() {
        return constants$49.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct SDL_PixelFormat* format;
     * }
     */
    public static MemorySegment format$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$49.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct SDL_PixelFormat* format;
     * }
     */
    public static void format$set(MemorySegment seg, MemorySegment x) {
        constants$49.const$5.set(seg, 0L, x);
    }
    public static MemorySegment format$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$49.const$5.get(seg, index * sizeof());    }
    public static void format$set(MemorySegment seg, long index, MemorySegment x) {
        constants$49.const$5.set(seg, index * sizeof(), x);
    }
    public static VarHandle w$VH() {
        return constants$50.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int w;
     * }
     */
    public static int w$get(MemorySegment seg) {
        return (int)constants$50.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int w;
     * }
     */
    public static void w$set(MemorySegment seg, int x) {
        constants$50.const$0.set(seg, 0L, x);
    }
    public static int w$get(MemorySegment seg, long index) {
        return (int)constants$50.const$0.get(seg, index * sizeof());    }
    public static void w$set(MemorySegment seg, long index, int x) {
        constants$50.const$0.set(seg, index * sizeof(), x);
    }
    public static VarHandle h$VH() {
        return constants$50.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int h;
     * }
     */
    public static int h$get(MemorySegment seg) {
        return (int)constants$50.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int h;
     * }
     */
    public static void h$set(MemorySegment seg, int x) {
        constants$50.const$1.set(seg, 0L, x);
    }
    public static int h$get(MemorySegment seg, long index) {
        return (int)constants$50.const$1.get(seg, index * sizeof());    }
    public static void h$set(MemorySegment seg, long index, int x) {
        constants$50.const$1.set(seg, index * sizeof(), x);
    }
    public static VarHandle pitch$VH() {
        return constants$50.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int pitch;
     * }
     */
    public static int pitch$get(MemorySegment seg) {
        return (int)constants$50.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int pitch;
     * }
     */
    public static void pitch$set(MemorySegment seg, int x) {
        constants$50.const$2.set(seg, 0L, x);
    }
    public static int pitch$get(MemorySegment seg, long index) {
        return (int)constants$50.const$2.get(seg, index * sizeof());    }
    public static void pitch$set(MemorySegment seg, long index, int x) {
        constants$50.const$2.set(seg, index * sizeof(), x);
    }
    public static VarHandle pixels$VH() {
        return constants$50.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* pixels;
     * }
     */
    public static MemorySegment pixels$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$50.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* pixels;
     * }
     */
    public static void pixels$set(MemorySegment seg, MemorySegment x) {
        constants$50.const$3.set(seg, 0L, x);
    }
    public static MemorySegment pixels$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$50.const$3.get(seg, index * sizeof());    }
    public static void pixels$set(MemorySegment seg, long index, MemorySegment x) {
        constants$50.const$3.set(seg, index * sizeof(), x);
    }
    public static VarHandle userdata$VH() {
        return constants$50.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* userdata;
     * }
     */
    public static MemorySegment userdata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$50.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* userdata;
     * }
     */
    public static void userdata$set(MemorySegment seg, MemorySegment x) {
        constants$50.const$4.set(seg, 0L, x);
    }
    public static MemorySegment userdata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$50.const$4.get(seg, index * sizeof());    }
    public static void userdata$set(MemorySegment seg, long index, MemorySegment x) {
        constants$50.const$4.set(seg, index * sizeof(), x);
    }
    public static VarHandle locked$VH() {
        return constants$50.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int locked;
     * }
     */
    public static int locked$get(MemorySegment seg) {
        return (int)constants$50.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int locked;
     * }
     */
    public static void locked$set(MemorySegment seg, int x) {
        constants$50.const$5.set(seg, 0L, x);
    }
    public static int locked$get(MemorySegment seg, long index) {
        return (int)constants$50.const$5.get(seg, index * sizeof());    }
    public static void locked$set(MemorySegment seg, long index, int x) {
        constants$50.const$5.set(seg, index * sizeof(), x);
    }
    public static VarHandle list_blitmap$VH() {
        return constants$51.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* list_blitmap;
     * }
     */
    public static MemorySegment list_blitmap$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$51.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* list_blitmap;
     * }
     */
    public static void list_blitmap$set(MemorySegment seg, MemorySegment x) {
        constants$51.const$0.set(seg, 0L, x);
    }
    public static MemorySegment list_blitmap$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$51.const$0.get(seg, index * sizeof());    }
    public static void list_blitmap$set(MemorySegment seg, long index, MemorySegment x) {
        constants$51.const$0.set(seg, index * sizeof(), x);
    }
    public static MemorySegment clip_rect$slice(MemorySegment seg) {
        return seg.asSlice(64, 16);
    }
    public static VarHandle map$VH() {
        return constants$51.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct SDL_BlitMap* map;
     * }
     */
    public static MemorySegment map$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$51.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct SDL_BlitMap* map;
     * }
     */
    public static void map$set(MemorySegment seg, MemorySegment x) {
        constants$51.const$1.set(seg, 0L, x);
    }
    public static MemorySegment map$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$51.const$1.get(seg, index * sizeof());    }
    public static void map$set(MemorySegment seg, long index, MemorySegment x) {
        constants$51.const$1.set(seg, index * sizeof(), x);
    }
    public static VarHandle refcount$VH() {
        return constants$51.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int refcount;
     * }
     */
    public static int refcount$get(MemorySegment seg) {
        return (int)constants$51.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int refcount;
     * }
     */
    public static void refcount$set(MemorySegment seg, int x) {
        constants$51.const$2.set(seg, 0L, x);
    }
    public static int refcount$get(MemorySegment seg, long index) {
        return (int)constants$51.const$2.get(seg, index * sizeof());    }
    public static void refcount$set(MemorySegment seg, long index, int x) {
        constants$51.const$2.set(seg, index * sizeof(), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


