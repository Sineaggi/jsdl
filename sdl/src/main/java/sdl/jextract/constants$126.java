// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$126 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$126() {}
    static final VarHandle const$0 = constants$124.const$4.varHandle(MemoryLayout.PathElement.groupElement("preciseX"));
    static final VarHandle const$1 = constants$124.const$4.varHandle(MemoryLayout.PathElement.groupElement("preciseY"));
    static final VarHandle const$2 = constants$124.const$4.varHandle(MemoryLayout.PathElement.groupElement("mouseX"));
    static final VarHandle const$3 = constants$124.const$4.varHandle(MemoryLayout.PathElement.groupElement("mouseY"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("which"),
        JAVA_BYTE.withName("axis"),
        JAVA_BYTE.withName("padding1"),
        JAVA_BYTE.withName("padding2"),
        JAVA_BYTE.withName("padding3"),
        JAVA_SHORT.withName("value"),
        JAVA_SHORT.withName("padding4")
    ).withName("SDL_JoyAxisEvent");
    static final VarHandle const$5 = constants$126.const$4.varHandle(MemoryLayout.PathElement.groupElement("type"));
}


