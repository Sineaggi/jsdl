// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$108 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$108() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(JAVA_SHORT,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetAxis",
        constants$108.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_INT,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetAxisInitialState",
        constants$108.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_BYTE,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetHat",
        constants$108.const$4
    );
}


