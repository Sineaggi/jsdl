// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$83 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$83() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_JoystickPathForIndex",
        constants$28.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetDevicePlayerIndex",
        constants$2.const$4
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(MemoryLayout.structLayout(
        MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
    ).withName("SDL_GUID"),
        JAVA_INT
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetDeviceGUID",
        constants$83.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_SHORT,
        JAVA_INT
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetDeviceVendor",
        constants$83.const$4
    );
}


