// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$64 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$64() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_CreateRGBSurfaceWithFormatFrom",
        constants$64.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_FreeSurface",
        constants$1.const$2
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_SetSurfacePalette",
        constants$6.const$4
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_LockSurface",
        constants$18.const$4
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_UnlockSurface",
        constants$1.const$2
    );
}


