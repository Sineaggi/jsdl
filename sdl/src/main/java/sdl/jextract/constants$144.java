// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$144 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$144() {}
    static final VarHandle const$0 = constants$143.const$2.varHandle(MemoryLayout.PathElement.groupElement("iscapture"));
    static final VarHandle const$1 = constants$143.const$2.varHandle(MemoryLayout.PathElement.groupElement("padding1"));
    static final VarHandle const$2 = constants$143.const$2.varHandle(MemoryLayout.PathElement.groupElement("padding2"));
    static final VarHandle const$3 = constants$143.const$2.varHandle(MemoryLayout.PathElement.groupElement("padding3"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_LONG.withName("touchId"),
        JAVA_LONG.withName("fingerId"),
        JAVA_FLOAT.withName("x"),
        JAVA_FLOAT.withName("y"),
        JAVA_FLOAT.withName("dx"),
        JAVA_FLOAT.withName("dy"),
        JAVA_FLOAT.withName("pressure"),
        JAVA_INT.withName("windowID")
    ).withName("SDL_TouchFingerEvent");
    static final VarHandle const$5 = constants$144.const$4.varHandle(MemoryLayout.PathElement.groupElement("type"));
}


