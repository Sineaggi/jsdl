// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$59 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$59() {}
    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(
        "SDL_GetYUVConversionMode",
        constants$1.const$4
    );
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(JAVA_INT,
        JAVA_INT,
        JAVA_INT
    );
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        "SDL_GetYUVConversionModeForResolution",
        constants$59.const$1
    );
    static final StructLayout const$3 = MemoryLayout.structLayout(
        JAVA_INT.withName("format"),
        JAVA_INT.withName("w"),
        JAVA_INT.withName("h"),
        JAVA_INT.withName("refresh_rate"),
        RuntimeHelper.POINTER.withName("driverdata")
    ).withName("SDL_DisplayMode");
    static final VarHandle const$4 = constants$59.const$3.varHandle(MemoryLayout.PathElement.groupElement("format"));
    static final VarHandle const$5 = constants$59.const$3.varHandle(MemoryLayout.PathElement.groupElement("w"));
}


