package sdl.internal;

import java.lang.foreign.MemorySegment;

public class Util {
    public static String stringOrNull(MemorySegment memorySegment) {
        if (memorySegment.equals(MemorySegment.NULL)) {
            return null;
        }
        return memorySegment.getUtf8String(0);
    }
}
