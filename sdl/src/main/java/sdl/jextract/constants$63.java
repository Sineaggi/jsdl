// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$63 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$63() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_GetDesktopDisplayMode",
        constants$61.const$4
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_GetCurrentDisplayMode",
        constants$61.const$4
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GetClosestDisplayMode",
        constants$63.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_GetPointDisplayIndex",
        constants$13.const$1
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_GetRectDisplayIndex",
        constants$13.const$1
    );
}


