// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$31 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$31() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_AllocRW",
        constants$0.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_FreeRW",
        constants$1.const$2
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_RWsize",
        constants$7.const$0
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_LONG,
        RuntimeHelper.POINTER,
        JAVA_LONG,
        JAVA_INT
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_RWseek",
        constants$31.const$3
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_RWtell",
        constants$7.const$0
    );
}


