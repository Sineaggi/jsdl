// Generated by jextract

package sdl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$46 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$46() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_SensorGetType",
        constants$18.const$4
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_SensorGetNonPortableType",
        constants$18.const$4
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_SensorGetInstanceID",
        constants$18.const$4
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_SensorGetData",
        constants$6.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_SensorGetDataWithTimestamp",
        constants$46.const$4
    );
}


