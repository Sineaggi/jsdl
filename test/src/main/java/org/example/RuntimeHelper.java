package org.example;

import java.lang.foreign.*;

final class RuntimeHelper {

    // Suppresses default constructor, ensuring non-instantiability.
    private RuntimeHelper() {}

    static MemorySegment asArray(MemorySegment addr, MemoryLayout layout, int numElements, Arena arena) {
         return addr.reinterpret(numElements * layout.byteSize(), arena, null);
    }
}
