// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$105 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$105() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetBall",
        constants$59.const$2
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_JoystickGetButton",
        constants$104.const$4
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_SHORT,
        JAVA_SHORT,
        JAVA_INT
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_JoystickRumble",
        constants$105.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_JoystickRumbleTriggers",
        constants$105.const$2
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_JoystickHasLED",
        constants$18.const$4
    );
}


