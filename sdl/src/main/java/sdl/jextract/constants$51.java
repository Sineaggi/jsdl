// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$51 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$51() {}
    static final VarHandle const$0 = constants$49.const$3.varHandle(MemoryLayout.PathElement.groupElement("list_blitmap"));
    static final VarHandle const$1 = constants$49.const$3.varHandle(MemoryLayout.PathElement.groupElement("map"));
    static final VarHandle const$2 = constants$49.const$3.varHandle(MemoryLayout.PathElement.groupElement("refcount"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_CreateRGBSurface",
        constants$51.const$3
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "SDL_CreateRGBSurfaceWithFormat",
        constants$51.const$5
    );
}


