// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$90 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$90() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_GL_DeleteContext",
        constants$1.const$2
    );
    static final StructLayout const$1 = MemoryLayout.structLayout(
        MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
    ).withName("SDL_GUID");
    static final FunctionDescriptor const$2 = FunctionDescriptor.ofVoid(
        MemoryLayout.structLayout(
            MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
        ).withName("SDL_GUID"),
        RuntimeHelper.POINTER,
        JAVA_INT
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GUIDToString",
        constants$90.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(MemoryLayout.structLayout(
        MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
    ).withName("SDL_GUID"),
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_GUIDFromString",
        constants$90.const$4
    );
}


