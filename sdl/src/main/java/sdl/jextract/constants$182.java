// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$182 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$182() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_DOUBLE,
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_RenderCopyEx",
        constants$182.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_RenderDrawPointF",
        constants$178.const$3
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_RenderDrawPointsF",
        constants$6.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(JAVA_INT,
        RuntimeHelper.POINTER,
        JAVA_FLOAT,
        JAVA_FLOAT,
        JAVA_FLOAT,
        JAVA_FLOAT
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_RenderDrawLineF",
        constants$182.const$4
    );
}


