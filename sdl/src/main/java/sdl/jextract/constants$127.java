// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$127 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$127() {}
    static final VarHandle const$0 = constants$126.const$5.varHandle(MemoryLayout.PathElement.groupElement("scancode"));
    static final VarHandle const$1 = constants$126.const$5.varHandle(MemoryLayout.PathElement.groupElement("sym"));
    static final VarHandle const$2 = constants$126.const$5.varHandle(MemoryLayout.PathElement.groupElement("mod"));
    static final VarHandle const$3 = constants$126.const$5.varHandle(MemoryLayout.PathElement.groupElement("unused"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("windowID"),
        MemoryLayout.sequenceLayout(32, JAVA_BYTE).withName("text"),
        JAVA_INT.withName("start"),
        JAVA_INT.withName("length")
    ).withName("SDL_TextEditingEvent");
    static final VarHandle const$5 = constants$127.const$4.varHandle(MemoryLayout.PathElement.groupElement("type"));
}


