// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$124 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$124() {}
    static final VarHandle const$0 = constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("windowID"));
    static final StructLayout const$1 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("windowID"),
        JAVA_INT.withName("which"),
        JAVA_INT.withName("state"),
        JAVA_INT.withName("x"),
        JAVA_INT.withName("y"),
        JAVA_INT.withName("xrel"),
        JAVA_INT.withName("yrel")
    ).withName("SDL_MouseMotionEvent");
    static final VarHandle const$2 = constants$124.const$1.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$3 = constants$124.const$1.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
    static final VarHandle const$4 = constants$124.const$1.varHandle(MemoryLayout.PathElement.groupElement("windowID"));
    static final VarHandle const$5 = constants$124.const$1.varHandle(MemoryLayout.PathElement.groupElement("which"));
}


