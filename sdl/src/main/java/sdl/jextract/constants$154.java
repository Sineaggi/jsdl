// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$154 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$154() {}
    static final VarHandle const$0 = constants$152.const$4.varHandle(MemoryLayout.PathElement.groupElement("numFingers"));
    static final VarHandle const$1 = constants$152.const$4.varHandle(MemoryLayout.PathElement.groupElement("padding"));
    static final StructLayout const$2 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_LONG.withName("touchId"),
        JAVA_LONG.withName("gestureId"),
        JAVA_INT.withName("numFingers"),
        JAVA_FLOAT.withName("error"),
        JAVA_FLOAT.withName("x"),
        JAVA_FLOAT.withName("y")
    ).withName("SDL_DollarGestureEvent");
    static final VarHandle const$3 = constants$154.const$2.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$4 = constants$154.const$2.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
    static final VarHandle const$5 = constants$154.const$2.varHandle(MemoryLayout.PathElement.groupElement("touchId"));
}


