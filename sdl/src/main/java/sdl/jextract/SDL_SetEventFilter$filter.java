// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * int (*SDL_SetEventFilter$filter)(void*,union SDL_Event*);
 * }
 */
public interface SDL_SetEventFilter$filter {

    int apply(java.lang.foreign.MemorySegment userdata, java.lang.foreign.MemorySegment event);
    static MemorySegment allocate(SDL_SetEventFilter$filter fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$156.const$5, fi, constants$8.const$2, scope);
    }
    static SDL_SetEventFilter$filter ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _userdata, java.lang.foreign.MemorySegment _event) -> {
            try {
                return (int)constants$156.const$4.invokeExact(symbol, _userdata, _event);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


