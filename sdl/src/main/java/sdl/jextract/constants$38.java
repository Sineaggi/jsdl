// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$38 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$38() {}
    static final StructLayout const$0 = MemoryLayout.structLayout(
        JAVA_INT.withName("format"),
        MemoryLayout.paddingLayout(4),
        RuntimeHelper.POINTER.withName("palette"),
        JAVA_BYTE.withName("BitsPerPixel"),
        JAVA_BYTE.withName("BytesPerPixel"),
        MemoryLayout.sequenceLayout(2, JAVA_BYTE).withName("padding"),
        JAVA_INT.withName("Rmask"),
        JAVA_INT.withName("Gmask"),
        JAVA_INT.withName("Bmask"),
        JAVA_INT.withName("Amask"),
        JAVA_BYTE.withName("Rloss"),
        JAVA_BYTE.withName("Gloss"),
        JAVA_BYTE.withName("Bloss"),
        JAVA_BYTE.withName("Aloss"),
        JAVA_BYTE.withName("Rshift"),
        JAVA_BYTE.withName("Gshift"),
        JAVA_BYTE.withName("Bshift"),
        JAVA_BYTE.withName("Ashift"),
        JAVA_INT.withName("refcount"),
        RuntimeHelper.POINTER.withName("next")
    ).withName("SDL_PixelFormat");
    static final VarHandle const$1 = constants$38.const$0.varHandle(MemoryLayout.PathElement.groupElement("format"));
    static final VarHandle const$2 = constants$38.const$0.varHandle(MemoryLayout.PathElement.groupElement("palette"));
    static final VarHandle const$3 = constants$38.const$0.varHandle(MemoryLayout.PathElement.groupElement("BitsPerPixel"));
    static final VarHandle const$4 = constants$38.const$0.varHandle(MemoryLayout.PathElement.groupElement("BytesPerPixel"));
    static final VarHandle const$5 = constants$38.const$0.varHandle(MemoryLayout.PathElement.groupElement("Rmask"));
}


