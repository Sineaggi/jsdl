// Generated by jextract

package sdl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$84 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$84() {}
    static final VarHandle const$0 = constants$81.const$2.varHandle(MemoryLayout.PathElement.groupElement("Ashift"));
    static final VarHandle const$1 = constants$81.const$2.varHandle(MemoryLayout.PathElement.groupElement("refcount"));
    static final VarHandle const$2 = constants$81.const$2.varHandle(MemoryLayout.PathElement.groupElement("next"));
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GetPixelFormatName",
        constants$44.const$5
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_INT,
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_PixelFormatEnumToMasks",
        constants$84.const$4
    );
}


