// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$77 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$77() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_GL_GetSwapInterval",
        constants$1.const$4
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_GL_SwapWindow",
        constants$1.const$2
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_GL_DeleteContext",
        constants$1.const$2
    );
    static final StructLayout const$3 = MemoryLayout.structLayout(
        JAVA_INT.withName("scancode"),
        JAVA_INT.withName("sym"),
        JAVA_SHORT.withName("mod"),
        MemoryLayout.paddingLayout(2),
        JAVA_INT.withName("unused")
    ).withName("SDL_Keysym");
    static final VarHandle const$4 = constants$77.const$3.varHandle(MemoryLayout.PathElement.groupElement("scancode"));
    static final VarHandle const$5 = constants$77.const$3.varHandle(MemoryLayout.PathElement.groupElement("sym"));
}


