// Generated by jextract

package sdl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$41 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$41() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_LoadFile_RW",
        constants$41.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_LoadFile",
        constants$13.const$2
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_BYTE,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_ReadU8",
        constants$41.const$3
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_SHORT,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "SDL_ReadLE16",
        constants$41.const$5
    );
}


