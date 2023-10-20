package org.example;

import java.lang.foreign.MemorySegment;

public interface TriggerEffectType {
    record ContinuousResitance() implements TriggerEffectType {
        public void write(MemorySegment segment) {

        }
    }
}
