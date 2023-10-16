// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * void (*SDL_HintCallback)(void* userdata,char* name,char* oldValue,char* newValue);
 * }
 */
public interface SDL_HintCallback {

    void apply(java.lang.foreign.MemorySegment userdata, java.lang.foreign.MemorySegment name, java.lang.foreign.MemorySegment oldValue, java.lang.foreign.MemorySegment newValue);
    static MemorySegment allocate(SDL_HintCallback fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$165.const$5, fi, constants$3.const$4, scope);
    }
    static SDL_HintCallback ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _userdata, java.lang.foreign.MemorySegment _name, java.lang.foreign.MemorySegment _oldValue, java.lang.foreign.MemorySegment _newValue) -> {
            try {
                constants$166.const$0.invokeExact(symbol, _userdata, _name, _oldValue, _newValue);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


