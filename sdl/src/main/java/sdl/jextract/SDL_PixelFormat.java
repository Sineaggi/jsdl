// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_PixelFormat {
 *     unsigned int format;
 *     struct SDL_Palette* palette;
 *     unsigned char BitsPerPixel;
 *     unsigned char BytesPerPixel;
 *     unsigned char padding[2];
 *     unsigned int Rmask;
 *     unsigned int Gmask;
 *     unsigned int Bmask;
 *     unsigned int Amask;
 *     unsigned char Rloss;
 *     unsigned char Gloss;
 *     unsigned char Bloss;
 *     unsigned char Aloss;
 *     unsigned char Rshift;
 *     unsigned char Gshift;
 *     unsigned char Bshift;
 *     unsigned char Ashift;
 *     int refcount;
 *     struct SDL_PixelFormat* next;
 * };
 * }
 */
public class SDL_PixelFormat {

    public static MemoryLayout $LAYOUT() {
        return constants$49.const$3;
    }
    public static VarHandle format$VH() {
        return constants$49.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int format;
     * }
     */
    public static int format$get(MemorySegment seg) {
        return (int)constants$49.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int format;
     * }
     */
    public static void format$set(MemorySegment seg, int x) {
        constants$49.const$4.set(seg, x);
    }
    public static int format$get(MemorySegment seg, long index) {
        return (int)constants$49.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void format$set(MemorySegment seg, long index, int x) {
        constants$49.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle palette$VH() {
        return constants$49.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct SDL_Palette* palette;
     * }
     */
    public static MemorySegment palette$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$49.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct SDL_Palette* palette;
     * }
     */
    public static void palette$set(MemorySegment seg, MemorySegment x) {
        constants$49.const$5.set(seg, x);
    }
    public static MemorySegment palette$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$49.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void palette$set(MemorySegment seg, long index, MemorySegment x) {
        constants$49.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle BitsPerPixel$VH() {
        return constants$50.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char BitsPerPixel;
     * }
     */
    public static byte BitsPerPixel$get(MemorySegment seg) {
        return (byte)constants$50.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char BitsPerPixel;
     * }
     */
    public static void BitsPerPixel$set(MemorySegment seg, byte x) {
        constants$50.const$0.set(seg, x);
    }
    public static byte BitsPerPixel$get(MemorySegment seg, long index) {
        return (byte)constants$50.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void BitsPerPixel$set(MemorySegment seg, long index, byte x) {
        constants$50.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle BytesPerPixel$VH() {
        return constants$50.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char BytesPerPixel;
     * }
     */
    public static byte BytesPerPixel$get(MemorySegment seg) {
        return (byte)constants$50.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char BytesPerPixel;
     * }
     */
    public static void BytesPerPixel$set(MemorySegment seg, byte x) {
        constants$50.const$1.set(seg, x);
    }
    public static byte BytesPerPixel$get(MemorySegment seg, long index) {
        return (byte)constants$50.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void BytesPerPixel$set(MemorySegment seg, long index, byte x) {
        constants$50.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static MemorySegment padding$slice(MemorySegment seg) {
        return seg.asSlice(18, 2);
    }
    public static VarHandle Rmask$VH() {
        return constants$50.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int Rmask;
     * }
     */
    public static int Rmask$get(MemorySegment seg) {
        return (int)constants$50.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int Rmask;
     * }
     */
    public static void Rmask$set(MemorySegment seg, int x) {
        constants$50.const$2.set(seg, x);
    }
    public static int Rmask$get(MemorySegment seg, long index) {
        return (int)constants$50.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void Rmask$set(MemorySegment seg, long index, int x) {
        constants$50.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Gmask$VH() {
        return constants$50.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int Gmask;
     * }
     */
    public static int Gmask$get(MemorySegment seg) {
        return (int)constants$50.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int Gmask;
     * }
     */
    public static void Gmask$set(MemorySegment seg, int x) {
        constants$50.const$3.set(seg, x);
    }
    public static int Gmask$get(MemorySegment seg, long index) {
        return (int)constants$50.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void Gmask$set(MemorySegment seg, long index, int x) {
        constants$50.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Bmask$VH() {
        return constants$50.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int Bmask;
     * }
     */
    public static int Bmask$get(MemorySegment seg) {
        return (int)constants$50.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int Bmask;
     * }
     */
    public static void Bmask$set(MemorySegment seg, int x) {
        constants$50.const$4.set(seg, x);
    }
    public static int Bmask$get(MemorySegment seg, long index) {
        return (int)constants$50.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void Bmask$set(MemorySegment seg, long index, int x) {
        constants$50.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Amask$VH() {
        return constants$50.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int Amask;
     * }
     */
    public static int Amask$get(MemorySegment seg) {
        return (int)constants$50.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int Amask;
     * }
     */
    public static void Amask$set(MemorySegment seg, int x) {
        constants$50.const$5.set(seg, x);
    }
    public static int Amask$get(MemorySegment seg, long index) {
        return (int)constants$50.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void Amask$set(MemorySegment seg, long index, int x) {
        constants$50.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Rloss$VH() {
        return constants$51.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Rloss;
     * }
     */
    public static byte Rloss$get(MemorySegment seg) {
        return (byte)constants$51.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Rloss;
     * }
     */
    public static void Rloss$set(MemorySegment seg, byte x) {
        constants$51.const$0.set(seg, x);
    }
    public static byte Rloss$get(MemorySegment seg, long index) {
        return (byte)constants$51.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void Rloss$set(MemorySegment seg, long index, byte x) {
        constants$51.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Gloss$VH() {
        return constants$51.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Gloss;
     * }
     */
    public static byte Gloss$get(MemorySegment seg) {
        return (byte)constants$51.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Gloss;
     * }
     */
    public static void Gloss$set(MemorySegment seg, byte x) {
        constants$51.const$1.set(seg, x);
    }
    public static byte Gloss$get(MemorySegment seg, long index) {
        return (byte)constants$51.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void Gloss$set(MemorySegment seg, long index, byte x) {
        constants$51.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Bloss$VH() {
        return constants$51.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Bloss;
     * }
     */
    public static byte Bloss$get(MemorySegment seg) {
        return (byte)constants$51.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Bloss;
     * }
     */
    public static void Bloss$set(MemorySegment seg, byte x) {
        constants$51.const$2.set(seg, x);
    }
    public static byte Bloss$get(MemorySegment seg, long index) {
        return (byte)constants$51.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void Bloss$set(MemorySegment seg, long index, byte x) {
        constants$51.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Aloss$VH() {
        return constants$51.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Aloss;
     * }
     */
    public static byte Aloss$get(MemorySegment seg) {
        return (byte)constants$51.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Aloss;
     * }
     */
    public static void Aloss$set(MemorySegment seg, byte x) {
        constants$51.const$3.set(seg, x);
    }
    public static byte Aloss$get(MemorySegment seg, long index) {
        return (byte)constants$51.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void Aloss$set(MemorySegment seg, long index, byte x) {
        constants$51.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Rshift$VH() {
        return constants$51.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Rshift;
     * }
     */
    public static byte Rshift$get(MemorySegment seg) {
        return (byte)constants$51.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Rshift;
     * }
     */
    public static void Rshift$set(MemorySegment seg, byte x) {
        constants$51.const$4.set(seg, x);
    }
    public static byte Rshift$get(MemorySegment seg, long index) {
        return (byte)constants$51.const$4.get(seg.asSlice(index*sizeof()));
    }
    public static void Rshift$set(MemorySegment seg, long index, byte x) {
        constants$51.const$4.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Gshift$VH() {
        return constants$51.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Gshift;
     * }
     */
    public static byte Gshift$get(MemorySegment seg) {
        return (byte)constants$51.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Gshift;
     * }
     */
    public static void Gshift$set(MemorySegment seg, byte x) {
        constants$51.const$5.set(seg, x);
    }
    public static byte Gshift$get(MemorySegment seg, long index) {
        return (byte)constants$51.const$5.get(seg.asSlice(index*sizeof()));
    }
    public static void Gshift$set(MemorySegment seg, long index, byte x) {
        constants$51.const$5.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Bshift$VH() {
        return constants$52.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Bshift;
     * }
     */
    public static byte Bshift$get(MemorySegment seg) {
        return (byte)constants$52.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Bshift;
     * }
     */
    public static void Bshift$set(MemorySegment seg, byte x) {
        constants$52.const$0.set(seg, x);
    }
    public static byte Bshift$get(MemorySegment seg, long index) {
        return (byte)constants$52.const$0.get(seg.asSlice(index*sizeof()));
    }
    public static void Bshift$set(MemorySegment seg, long index, byte x) {
        constants$52.const$0.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle Ashift$VH() {
        return constants$52.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char Ashift;
     * }
     */
    public static byte Ashift$get(MemorySegment seg) {
        return (byte)constants$52.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char Ashift;
     * }
     */
    public static void Ashift$set(MemorySegment seg, byte x) {
        constants$52.const$1.set(seg, x);
    }
    public static byte Ashift$get(MemorySegment seg, long index) {
        return (byte)constants$52.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void Ashift$set(MemorySegment seg, long index, byte x) {
        constants$52.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle refcount$VH() {
        return constants$52.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int refcount;
     * }
     */
    public static int refcount$get(MemorySegment seg) {
        return (int)constants$52.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int refcount;
     * }
     */
    public static void refcount$set(MemorySegment seg, int x) {
        constants$52.const$2.set(seg, x);
    }
    public static int refcount$get(MemorySegment seg, long index) {
        return (int)constants$52.const$2.get(seg.asSlice(index*sizeof()));
    }
    public static void refcount$set(MemorySegment seg, long index, int x) {
        constants$52.const$2.set(seg.asSlice(index*sizeof()), x);
    }
    public static VarHandle next$VH() {
        return constants$52.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct SDL_PixelFormat* next;
     * }
     */
    public static MemorySegment next$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment)constants$52.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct SDL_PixelFormat* next;
     * }
     */
    public static void next$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$3.set(seg, x);
    }
    public static MemorySegment next$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)constants$52.const$3.get(seg.asSlice(index*sizeof()));
    }
    public static void next$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$3.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


