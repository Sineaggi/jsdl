// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$35 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$35() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_SemValue",
        constants$18.const$4
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_CreateCond",
        constants$0.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_DestroyCond",
        constants$1.const$2
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_CondSignal",
        constants$18.const$4
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_CondBroadcast",
        constants$18.const$4
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_CondWait",
        constants$6.const$4
    );
}


