// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$171 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$171() {}
    static final VarHandle const$0 = constants$170.const$1.varHandle(MemoryLayout.PathElement.groupElement("max_texture_height"));
    static final StructLayout const$1 = MemoryLayout.structLayout(
        MemoryLayout.structLayout(
            JAVA_FLOAT.withName("x"),
            JAVA_FLOAT.withName("y")
        ).withName("position"),
        MemoryLayout.structLayout(
            JAVA_BYTE.withName("r"),
            JAVA_BYTE.withName("g"),
            JAVA_BYTE.withName("b"),
            JAVA_BYTE.withName("a")
        ).withName("color"),
        MemoryLayout.structLayout(
            JAVA_FLOAT.withName("x"),
            JAVA_FLOAT.withName("y")
        ).withName("tex_coord")
    ).withName("SDL_Vertex");
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_GetNumRenderDrivers",
        constants$5.const$5
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GetRenderDriverInfo",
        constants$73.const$3
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_CreateWindowAndRenderer",
        constants$171.const$4
    );
}


