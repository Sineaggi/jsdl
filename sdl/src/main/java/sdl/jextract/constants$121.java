// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$121 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$121() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_GL_GetDrawableSize",
        constants$91.const$0
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_GL_SetSwapInterval",
        constants$8.const$0
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_GL_GetSwapInterval",
        constants$5.const$5
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GL_SwapWindow",
        constants$1.const$2
    );
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_GL_DeleteContext",
        constants$1.const$2
    );
    static final StructLayout const$5 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp")
    ).withName("SDL_CommonEvent");
}


