// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * int (*SDL_EventFilter)(void* userdata,union SDL_Event* event);
 * }
 */
public interface SDL_EventFilter {

    int apply(java.lang.foreign.MemorySegment userdata, java.lang.foreign.MemorySegment event);
    static MemorySegment allocate(SDL_EventFilter fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$162.const$3, fi, constants$6.const$4, scope);
    }
    static SDL_EventFilter ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _userdata, java.lang.foreign.MemorySegment _event) -> {
            try {
                return (int)constants$7.const$0.invokeExact(symbol, _userdata, _event);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


