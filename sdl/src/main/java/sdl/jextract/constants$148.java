// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$148 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$148() {}
    static final VarHandle const$0 = constants$147.const$0.varHandle(MemoryLayout.PathElement.groupElement("x"));
    static final VarHandle const$1 = constants$147.const$0.varHandle(MemoryLayout.PathElement.groupElement("y"));
    static final VarHandle const$2 = constants$147.const$0.varHandle(MemoryLayout.PathElement.groupElement("pressure"));
    static final StructLayout const$3 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("which"),
        JAVA_INT.withName("sensor"),
        MemoryLayout.sequenceLayout(3, JAVA_FLOAT).withName("data"),
        MemoryLayout.paddingLayout(4),
        JAVA_LONG.withName("timestamp_us")
    ).withName("SDL_ControllerSensorEvent");
    static final VarHandle const$4 = constants$148.const$3.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$5 = constants$148.const$3.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
}


