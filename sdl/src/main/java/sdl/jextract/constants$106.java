// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$106 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$106() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetGUIDString",
        constants$94.const$2
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetGUIDFromString",
        constants$94.const$4
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.ofVoid(
        MemoryLayout.structLayout(
            MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
        ).withName("SDL_GUID"),
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GetJoystickGUIDInfo",
        constants$106.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetAttached",
        constants$18.const$4
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_JoystickInstanceID",
        constants$18.const$4
    );
}


