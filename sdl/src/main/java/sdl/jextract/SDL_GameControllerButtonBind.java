// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * struct SDL_GameControllerButtonBind {
 *     enum SDL_GameControllerBindType bindType;
 *     union  value;
 * };
 * }
 */
public class SDL_GameControllerButtonBind {

    public static MemoryLayout $LAYOUT() {
        return constants$110.const$0;
    }
    public static VarHandle bindType$VH() {
        return constants$110.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * enum SDL_GameControllerBindType bindType;
     * }
     */
    public static int bindType$get(MemorySegment seg) {
        return (int)constants$110.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * enum SDL_GameControllerBindType bindType;
     * }
     */
    public static void bindType$set(MemorySegment seg, int x) {
        constants$110.const$1.set(seg, x);
    }
    public static int bindType$get(MemorySegment seg, long index) {
        return (int)constants$110.const$1.get(seg.asSlice(index*sizeof()));
    }
    public static void bindType$set(MemorySegment seg, long index, int x) {
        constants$110.const$1.set(seg.asSlice(index*sizeof()), x);
    }
    /**
     * {@snippet :
     * union {
     *     int button;
     *     int axis;
     *     struct  hat;
     * };
     * }
     */
    public static final class value {

        // Suppresses default constructor, ensuring non-instantiability.
        private value() {}
        public static MemoryLayout $LAYOUT() {
            return constants$110.const$2;
        }
        public static VarHandle button$VH() {
            return constants$110.const$3;
        }
        /**
         * Getter for field:
         * {@snippet :
         * int button;
         * }
         */
        public static int button$get(MemorySegment seg) {
            return (int)constants$110.const$3.get(seg);
        }
        /**
         * Setter for field:
         * {@snippet :
         * int button;
         * }
         */
        public static void button$set(MemorySegment seg, int x) {
            constants$110.const$3.set(seg, x);
        }
        public static int button$get(MemorySegment seg, long index) {
            return (int)constants$110.const$3.get(seg.asSlice(index*sizeof()));
        }
        public static void button$set(MemorySegment seg, long index, int x) {
            constants$110.const$3.set(seg.asSlice(index*sizeof()), x);
        }
        public static VarHandle axis$VH() {
            return constants$110.const$4;
        }
        /**
         * Getter for field:
         * {@snippet :
         * int axis;
         * }
         */
        public static int axis$get(MemorySegment seg) {
            return (int)constants$110.const$4.get(seg);
        }
        /**
         * Setter for field:
         * {@snippet :
         * int axis;
         * }
         */
        public static void axis$set(MemorySegment seg, int x) {
            constants$110.const$4.set(seg, x);
        }
        public static int axis$get(MemorySegment seg, long index) {
            return (int)constants$110.const$4.get(seg.asSlice(index*sizeof()));
        }
        public static void axis$set(MemorySegment seg, long index, int x) {
            constants$110.const$4.set(seg.asSlice(index*sizeof()), x);
        }
        /**
         * {@snippet :
         * struct {
         *     int hat;
         *     int hat_mask;
         * };
         * }
         */
        public static final class hat {

            // Suppresses default constructor, ensuring non-instantiability.
            private hat() {}
            public static MemoryLayout $LAYOUT() {
                return constants$110.const$5;
            }
            public static VarHandle hat$VH() {
                return constants$111.const$0;
            }
            /**
             * Getter for field:
             * {@snippet :
             * int hat;
             * }
             */
            public static int hat$get(MemorySegment seg) {
                return (int)constants$111.const$0.get(seg);
            }
            /**
             * Setter for field:
             * {@snippet :
             * int hat;
             * }
             */
            public static void hat$set(MemorySegment seg, int x) {
                constants$111.const$0.set(seg, x);
            }
            public static int hat$get(MemorySegment seg, long index) {
                return (int)constants$111.const$0.get(seg.asSlice(index*sizeof()));
            }
            public static void hat$set(MemorySegment seg, long index, int x) {
                constants$111.const$0.set(seg.asSlice(index*sizeof()), x);
            }
            public static VarHandle hat_mask$VH() {
                return constants$111.const$1;
            }
            /**
             * Getter for field:
             * {@snippet :
             * int hat_mask;
             * }
             */
            public static int hat_mask$get(MemorySegment seg) {
                return (int)constants$111.const$1.get(seg);
            }
            /**
             * Setter for field:
             * {@snippet :
             * int hat_mask;
             * }
             */
            public static void hat_mask$set(MemorySegment seg, int x) {
                constants$111.const$1.set(seg, x);
            }
            public static int hat_mask$get(MemorySegment seg, long index) {
                return (int)constants$111.const$1.get(seg.asSlice(index*sizeof()));
            }
            public static void hat_mask$set(MemorySegment seg, long index, int x) {
                constants$111.const$1.set(seg.asSlice(index*sizeof()), x);
            }
            public static long sizeof() { return $LAYOUT().byteSize(); }
            public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
            public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
                return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
            }
            public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
        }

        public static MemorySegment hat$slice(MemorySegment seg) {
            return seg.asSlice(0, 8);
        }
        public static long sizeof() { return $LAYOUT().byteSize(); }
        public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
        public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
            return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
        }
        public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
    }

    public static MemorySegment value$slice(MemorySegment seg) {
        return seg.asSlice(4, 8);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


