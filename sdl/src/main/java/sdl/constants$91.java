// Generated by jextract

package sdl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$91 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$91() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.ofVoid(
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_UnionRect",
        constants$91.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_EnclosePoints",
        constants$65.const$4
    );
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_IntersectRectAndLine",
        constants$91.const$3
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_HasIntersectionF",
        constants$6.const$4
    );
}


