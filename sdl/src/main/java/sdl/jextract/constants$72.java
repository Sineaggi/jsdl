// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$72 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$72() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_GetGrabbedWindow",
        constants$0.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_SetWindowMouseRect",
        constants$8.const$2
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_GetWindowMouseRect",
        constants$2.const$0
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_FLOAT
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_SetWindowBrightness",
        constants$72.const$3
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_FLOAT,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "SDL_GetWindowBrightness",
        constants$72.const$5
    );
}


