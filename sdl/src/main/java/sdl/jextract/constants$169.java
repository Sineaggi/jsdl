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
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_CreateSoftwareRenderer",
        constants$6.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_GetRenderer",
        constants$6.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_RenderGetWindow",
        constants$6.const$0
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GetRendererInfo",
        constants$6.const$4
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_GetRendererOutputSize",
        constants$21.const$2
    );
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$6 = RuntimeHelper.downcallHandle(
        "SDL_CreateTexture",
        constants$169.const$5
    );
}


