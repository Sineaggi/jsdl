// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$33 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$33() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_LoadFile",
        constants$8.const$0
    );
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(JAVA_BYTE,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_ReadU8",
        constants$33.const$1
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_SHORT,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_ReadLE16",
        constants$33.const$3
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_ReadBE16",
        constants$33.const$3
    );
}


