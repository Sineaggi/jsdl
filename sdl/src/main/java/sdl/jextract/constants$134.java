// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$134 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$134() {}
    static final VarHandle const$0 = constants$133.const$0.varHandle(MemoryLayout.PathElement.groupElement("padding1"));
    static final VarHandle const$1 = constants$133.const$0.varHandle(MemoryLayout.PathElement.groupElement("padding2"));
    static final StructLayout const$2 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("which"),
        JAVA_BYTE.withName("button"),
        JAVA_BYTE.withName("state"),
        JAVA_BYTE.withName("padding1"),
        JAVA_BYTE.withName("padding2")
    ).withName("SDL_JoyButtonEvent");
    static final VarHandle const$3 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$4 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
    static final VarHandle const$5 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("which"));
}


