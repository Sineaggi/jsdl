// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$131 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$131() {}
    static final VarHandle const$0 = constants$130.const$4.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
    static final VarHandle const$1 = constants$130.const$4.varHandle(MemoryLayout.PathElement.groupElement("windowID"));
    static final VarHandle const$2 = constants$130.const$4.varHandle(MemoryLayout.PathElement.groupElement("start"));
    static final VarHandle const$3 = constants$130.const$4.varHandle(MemoryLayout.PathElement.groupElement("length"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("windowID"),
        MemoryLayout.paddingLayout(4),
        RuntimeHelper.POINTER.withName("text"),
        JAVA_INT.withName("start"),
        JAVA_INT.withName("length")
    ).withName("SDL_TextEditingExtEvent");
    static final VarHandle const$5 = constants$131.const$4.varHandle(MemoryLayout.PathElement.groupElement("type"));
}


