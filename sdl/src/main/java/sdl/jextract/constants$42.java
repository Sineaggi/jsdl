// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$42 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$42() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_AllocFormat",
        constants$28.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_FreeFormat",
        constants$1.const$2
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_AllocPalette",
        constants$28.const$0
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_SetPixelFormatPalette",
        constants$8.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_SetPaletteColors",
        constants$42.const$4
    );
}


