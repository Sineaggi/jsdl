// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$53 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$53() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_MasksToPixelFormatEnum",
        constants$53.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_AllocFormat",
        constants$33.const$5
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_FreeFormat",
        constants$1.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_AllocPalette",
        constants$33.const$5
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_SetPixelFormatPalette",
        constants$6.const$4
    );
}


