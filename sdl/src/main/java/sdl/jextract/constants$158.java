// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$158 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$158() {}
    static final StructLayout const$0 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp")
    ).withName("SDL_OSEvent");
    static final VarHandle const$1 = constants$158.const$0.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$2 = constants$158.const$0.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
    static final StructLayout const$3 = MemoryLayout.structLayout(
        JAVA_INT.withName("type"),
        JAVA_INT.withName("timestamp"),
        JAVA_INT.withName("windowID"),
        JAVA_INT.withName("code"),
        RuntimeHelper.POINTER.withName("data1"),
        RuntimeHelper.POINTER.withName("data2")
    ).withName("SDL_UserEvent");
    static final VarHandle const$4 = constants$158.const$3.varHandle(MemoryLayout.PathElement.groupElement("type"));
    static final VarHandle const$5 = constants$158.const$3.varHandle(MemoryLayout.PathElement.groupElement("timestamp"));
}


