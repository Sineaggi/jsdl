// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$46 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$46() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_ReadBE64",
        constants$12.const$3
    );
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(JAVA_LONG,
        RuntimeHelper.POINTER,
        JAVA_BYTE
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_WriteU8",
        constants$46.const$1
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_LONG,
        RuntimeHelper.POINTER,
        JAVA_SHORT
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_WriteLE16",
        constants$46.const$3
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_WriteBE16",
        constants$46.const$3
    );
}


