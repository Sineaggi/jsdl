// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
final class constants$93 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$93() {}
    static final VarHandle const$0 = constants$88.const$3.varHandle(MemoryLayout.PathElement.groupElement("SetLED"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(SDL_VirtualJoystickDesc.SendEffect.class, "apply", constants$2.const$2);
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(
        constants$2.const$2
    );
    static final VarHandle const$3 = constants$88.const$3.varHandle(MemoryLayout.PathElement.groupElement("SendEffect"));
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(
        "SDL_JoystickAttachVirtualEx",
        constants$13.const$1
    );
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(
        "SDL_JoystickDetachVirtual",
        constants$2.const$4
    );
}


