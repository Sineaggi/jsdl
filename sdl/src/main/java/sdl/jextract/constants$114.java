// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$114 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$114() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_GameControllerGetSensorData",
        constants$114.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GameControllerGetSensorDataWithTimestamp",
        constants$114.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_GameControllerRumble",
        constants$100.const$0
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_GameControllerRumbleTriggers",
        constants$100.const$0
    );
}


