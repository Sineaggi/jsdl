// Generated by jextract

package sdl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$36 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$36() {}
    static final UnionLayout const$0 = MemoryLayout.unionLayout(
        MemoryLayout.structLayout(
            JAVA_INT.withName("append"),
            MemoryLayout.paddingLayout(4),
            RuntimeHelper.POINTER.withName("h"),
            MemoryLayout.structLayout(
                RuntimeHelper.POINTER.withName("data"),
                JAVA_LONG.withName("size"),
                JAVA_LONG.withName("left")
            ).withName("buffer")
        ).withName("windowsio"),
        MemoryLayout.structLayout(
            JAVA_INT.withName("autoclose"),
            MemoryLayout.paddingLayout(4),
            RuntimeHelper.POINTER.withName("fp")
        ).withName("stdio"),
        MemoryLayout.structLayout(
            RuntimeHelper.POINTER.withName("base"),
            RuntimeHelper.POINTER.withName("here"),
            RuntimeHelper.POINTER.withName("stop")
        ).withName("mem"),
        MemoryLayout.structLayout(
            RuntimeHelper.POINTER.withName("data1"),
            RuntimeHelper.POINTER.withName("data2")
        ).withName("unknown")
    ).withName("");
    static final StructLayout const$1 = MemoryLayout.structLayout(
        JAVA_INT.withName("append"),
        MemoryLayout.paddingLayout(4),
        RuntimeHelper.POINTER.withName("h"),
        MemoryLayout.structLayout(
            RuntimeHelper.POINTER.withName("data"),
            JAVA_LONG.withName("size"),
            JAVA_LONG.withName("left")
        ).withName("buffer")
    ).withName("");
    static final VarHandle const$2 = constants$36.const$1.varHandle(MemoryLayout.PathElement.groupElement("append"));
    static final VarHandle const$3 = constants$36.const$1.varHandle(MemoryLayout.PathElement.groupElement("h"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
        RuntimeHelper.POINTER.withName("data"),
        JAVA_LONG.withName("size"),
        JAVA_LONG.withName("left")
    ).withName("");
    static final VarHandle const$5 = constants$36.const$4.varHandle(MemoryLayout.PathElement.groupElement("data"));
}


