// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$160 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$160() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_ClearHints",
        constants$26.const$5
    );
    static final StructLayout const$1 = MemoryLayout.structLayout(
        RuntimeHelper.POINTER.withName("name"),
        JAVA_INT.withName("flags"),
        JAVA_INT.withName("num_texture_formats"),
        MemoryLayout.sequenceLayout(16, JAVA_INT).withName("texture_formats"),
        JAVA_INT.withName("max_texture_width"),
        JAVA_INT.withName("max_texture_height")
    ).withName("SDL_RendererInfo");
    static final VarHandle const$2 = constants$160.const$1.varHandle(MemoryLayout.PathElement.groupElement("name"));
    static final VarHandle const$3 = constants$160.const$1.varHandle(MemoryLayout.PathElement.groupElement("flags"));
    static final VarHandle const$4 = constants$160.const$1.varHandle(MemoryLayout.PathElement.groupElement("num_texture_formats"));
    static final VarHandle const$5 = constants$160.const$1.varHandle(MemoryLayout.PathElement.groupElement("max_texture_width"));
}


