// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$169 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$169() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.ofVoid(
        RuntimeHelper.POINTER,
        JAVA_INT,
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_RenderWindowToLogical",
        constants$169.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.ofVoid(
        RuntimeHelper.POINTER,
        JAVA_FLOAT,
        JAVA_FLOAT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_RenderLogicalToWindow",
        constants$169.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_SetRenderDrawColor",
        constants$43.const$3
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_GetRenderDrawColor",
        constants$48.const$2
    );
}


