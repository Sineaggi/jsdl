// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$49 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$49() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_UnionFRect",
        constants$47.const$4
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_EncloseFPoints",
        constants$48.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_IntersectFRectAndLine",
        constants$48.const$2
    );
    static final StructLayout const$3 = MemoryLayout.structLayout(
        JAVA_INT.withName("flags"),
        MemoryLayout.paddingLayout(4),
        RuntimeHelper.POINTER.withName("format"),
        JAVA_INT.withName("w"),
        JAVA_INT.withName("h"),
        JAVA_INT.withName("pitch"),
        MemoryLayout.paddingLayout(4),
        RuntimeHelper.POINTER.withName("pixels"),
        RuntimeHelper.POINTER.withName("userdata"),
        JAVA_INT.withName("locked"),
        MemoryLayout.paddingLayout(4),
        RuntimeHelper.POINTER.withName("list_blitmap"),
        MemoryLayout.structLayout(
            JAVA_INT.withName("x"),
            JAVA_INT.withName("y"),
            JAVA_INT.withName("w"),
            JAVA_INT.withName("h")
        ).withName("clip_rect"),
        RuntimeHelper.POINTER.withName("map"),
        JAVA_INT.withName("refcount"),
        MemoryLayout.paddingLayout(4)
    ).withName("SDL_Surface");
    static final VarHandle const$4 = constants$49.const$3.varHandle(MemoryLayout.PathElement.groupElement("flags"));
    static final VarHandle const$5 = constants$49.const$3.varHandle(MemoryLayout.PathElement.groupElement("format"));
}


