// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$130 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$130() {}
    static final StructLayout const$0 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("which"),
        JAVA_BYTE.withName("hat"),
        JAVA_BYTE.withName("value"),
        JAVA_BYTE.withName("padding1"),
        JAVA_BYTE.withName("padding2")
    ).withName("SDL_JoyHatEvent");
    static final VarHandle const$1 = constants$130.const$0.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$2 = constants$130.const$0.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
    static final VarHandle const$3 = constants$130.const$0.varHandle(MemoryLayout.PathElement.groupElement("which"));
    static final VarHandle const$4 = constants$130.const$0.varHandle(MemoryLayout.PathElement.groupElement("hat"));
    static final VarHandle const$5 = constants$130.const$0.varHandle(MemoryLayout.PathElement.groupElement("value"));
}


