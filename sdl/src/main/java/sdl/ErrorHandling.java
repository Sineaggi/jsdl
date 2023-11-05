package sdl;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class ErrorHandling {
    public void handleError(MemorySegment input) {
        MemorySegment targetAddress = input; // todo
        Linker.Option ccs = Linker.Option.captureCallState("errno");
        MethodHandle handle = Linker.nativeLinker().downcallHandle(targetAddress, FunctionDescriptor.ofVoid(), ccs);

        StructLayout capturedStateLayout = Linker.Option.captureStateLayout();
        VarHandle errnoHandle = capturedStateLayout.varHandle(MemoryLayout.PathElement.groupElement("errno"));
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment capturedState = arena.allocate(capturedStateLayout);
            handle.invoke(capturedState);
            int errno = (int) errnoHandle.get(capturedState);
            // use errno
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
