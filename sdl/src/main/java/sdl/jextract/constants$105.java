// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$105 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$105() {}
    static final UnionLayout const$0 = MemoryLayout.unionLayout(
        JAVA_INT.withName("button"),
        JAVA_INT.withName("axis"),
        MemoryLayout.structLayout(
            JAVA_INT.withName("hat"),
            JAVA_INT.withName("hat_mask")
        ).withName("hat")
    ).withName("");
    static final VarHandle const$1 = constants$105.const$0.varHandle(MemoryLayout.PathElement.groupElement("button"));
    static final VarHandle const$2 = constants$105.const$0.varHandle(MemoryLayout.PathElement.groupElement("axis"));
    static final StructLayout const$3 = MemoryLayout.structLayout(
        JAVA_INT.withName("hat"),
        JAVA_INT.withName("hat_mask")
    ).withName("");
    static final VarHandle const$4 = constants$105.const$3.varHandle(MemoryLayout.PathElement.groupElement("hat"));
    static final VarHandle const$5 = constants$105.const$3.varHandle(MemoryLayout.PathElement.groupElement("hat_mask"));
}


