// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$27 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$27() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_Error",
        constants$2.const$4
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_CreateMutex",
        constants$0.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_LockMutex",
        constants$13.const$1
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_TryLockMutex",
        constants$13.const$1
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_UnlockMutex",
        constants$13.const$1
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_DestroyMutex",
        constants$1.const$2
    );
}


