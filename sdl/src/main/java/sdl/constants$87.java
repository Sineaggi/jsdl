// Generated by jextract

package sdl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$87 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$87() {}
    static final FunctionDescriptor const$0 = FunctionDescriptor.ofVoid(
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(
        "SDL_GetRGB",
        constants$87.const$0
    );
    static final FunctionDescriptor const$2 = FunctionDescriptor.ofVoid(
        JAVA_INT,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(
        "SDL_GetRGBA",
        constants$87.const$2
    );
    static final FunctionDescriptor const$4 = FunctionDescriptor.ofVoid(
        JAVA_FLOAT,
        RuntimeHelper.POINTER
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_CalculateGammaRamp",
        constants$87.const$4
    );
}


