// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$135 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$135() {}
    static final VarHandle const$0 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("button"));
    static final VarHandle const$1 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("state"));
    static final VarHandle const$2 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("padding1"));
    static final VarHandle const$3 = constants$134.const$2.varHandle(MemoryLayout.PathElement.groupElement("padding2"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("which")
    ).withName("SDL_JoyDeviceEvent");
    static final VarHandle const$5 = constants$135.const$4.varHandle(MemoryLayout.PathElement.groupElement("type"));
}


