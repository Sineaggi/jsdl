// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * void (*SDL_DelHintCallback$callback)(void*,char*,char*,char*);
 * }
 */
public interface SDL_DelHintCallback$callback {

    void apply(java.lang.foreign.MemorySegment userdata, java.lang.foreign.MemorySegment name, java.lang.foreign.MemorySegment oldValue, java.lang.foreign.MemorySegment newValue);
    static MemorySegment allocate(SDL_DelHintCallback$callback fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$169.const$4, fi, constants$3.const$4, scope);
    }
    static SDL_DelHintCallback$callback ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _userdata, java.lang.foreign.MemorySegment _name, java.lang.foreign.MemorySegment _oldValue, java.lang.foreign.MemorySegment _newValue) -> {
            try {
                constants$169.const$1.invokeExact(symbol, _userdata, _name, _oldValue, _newValue);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


