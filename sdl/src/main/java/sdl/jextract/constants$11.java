// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$11 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$11() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_strstr",
        constants$8.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_strcasestr",
        constants$8.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_strtokr",
        constants$11.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_utf8strlen",
        constants$7.const$0
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_LONG,
        RuntimeHelper.POINTER,
        JAVA_LONG
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "SDL_utf8strnlen",
        constants$11.const$5
    );
}


