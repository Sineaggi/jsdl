package sdl.internal;

import java.lang.foreign.MemorySegment;

public class Util {
    public static String stringOrNull(MemorySegment memorySegment) {
        if (memorySegment.equals(MemorySegment.NULL)) {
            return null;
        }
        return memorySegment.getString(0);
    }

    public static short toShortExact(int value) {
        if ((short)value != value) {
            throw new ArithmeticException("integer overflow");
        }
        return (short)value;
    }
}
