// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$110 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$110() {}
    static final StructLayout const$0 = MemoryLayout.structLayout(
        JAVA_INT.withName("bindType"),
        MemoryLayout.unionLayout(
            JAVA_INT.withName("button"),
            JAVA_INT.withName("axis"),
            MemoryLayout.structLayout(
                JAVA_INT.withName("hat"),
                JAVA_INT.withName("hat_mask")
            ).withName("hat")
        ).withName("value")
    ).withName("SDL_GameControllerButtonBind");
    static final VarHandle const$1 = constants$110.const$0.varHandle(MemoryLayout.PathElement.groupElement("bindType"));
    static final UnionLayout const$2 = MemoryLayout.unionLayout(
        JAVA_INT.withName("button"),
        JAVA_INT.withName("axis"),
        MemoryLayout.structLayout(
            JAVA_INT.withName("hat"),
            JAVA_INT.withName("hat_mask")
        ).withName("hat")
    ).withName("");
    static final VarHandle const$3 = constants$110.const$2.varHandle(MemoryLayout.PathElement.groupElement("button"));
    static final VarHandle const$4 = constants$110.const$2.varHandle(MemoryLayout.PathElement.groupElement("axis"));
    static final StructLayout const$5 = MemoryLayout.structLayout(
        JAVA_INT.withName("hat"),
        JAVA_INT.withName("hat_mask")
    ).withName("");
}


