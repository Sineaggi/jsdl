// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$158 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$158() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_DelEventWatch",
        constants$56.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(SDL_FilterEvents$filter.class, "apply", constants$8.const$2);
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_FilterEvents",
        constants$56.const$0
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_BYTE,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_EventState",
        constants$158.const$3
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_RegisterEvents",
        constants$2.const$4
    );
}


