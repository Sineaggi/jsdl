// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$94 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$94() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetGUIDFromString",
        constants$82.const$0
    );
    static final FunctionDescriptor const$1 = FunctionDescriptor.ofVoid(
        MemoryLayout.structLayout(
            MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
        ).withName("SDL_GUID"),
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_GetJoystickGUIDInfo",
        constants$94.const$1
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetAttached",
        constants$13.const$1
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_JoystickInstanceID",
        constants$13.const$1
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_JoystickNumAxes",
        constants$13.const$1
    );
}


