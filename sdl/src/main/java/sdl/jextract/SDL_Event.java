// Generated by jextract

package sdl.jextract;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
/**
 * {@snippet :
 * union SDL_Event {
 *     unsigned int type;
 *     struct SDL_CommonEvent common;
 *     struct SDL_DisplayEvent display;
 *     struct SDL_WindowEvent window;
 *     struct SDL_KeyboardEvent key;
 *     struct SDL_TextEditingEvent edit;
 *     struct SDL_TextEditingExtEvent editExt;
 *     struct SDL_TextInputEvent text;
 *     struct SDL_MouseMotionEvent motion;
 *     struct SDL_MouseButtonEvent button;
 *     struct SDL_MouseWheelEvent wheel;
 *     struct SDL_JoyAxisEvent jaxis;
 *     struct SDL_JoyBallEvent jball;
 *     struct SDL_JoyHatEvent jhat;
 *     struct SDL_JoyButtonEvent jbutton;
 *     struct SDL_JoyDeviceEvent jdevice;
 *     struct SDL_JoyBatteryEvent jbattery;
 *     struct SDL_ControllerAxisEvent caxis;
 *     struct SDL_ControllerButtonEvent cbutton;
 *     struct SDL_ControllerDeviceEvent cdevice;
 *     struct SDL_ControllerTouchpadEvent ctouchpad;
 *     struct SDL_ControllerSensorEvent csensor;
 *     struct SDL_AudioDeviceEvent adevice;
 *     struct SDL_SensorEvent sensor;
 *     struct SDL_QuitEvent quit;
 *     struct SDL_UserEvent user;
 *     struct SDL_SysWMEvent syswm;
 *     struct SDL_TouchFingerEvent tfinger;
 *     struct SDL_MultiGestureEvent mgesture;
 *     struct SDL_DollarGestureEvent dgesture;
 *     struct SDL_DropEvent drop;
 *     unsigned char padding[56];
 * };
 * }
 */
public class SDL_Event {

    public static MemoryLayout $LAYOUT() {
        return constants$154.const$1;
    }
    public static VarHandle type$VH() {
        return constants$154.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static int type$get(MemorySegment seg) {
        return (int)constants$154.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int type;
     * }
     */
    public static void type$set(MemorySegment seg, int x) {
        constants$154.const$2.set(seg, 0L, x);
    }
    public static int type$get(MemorySegment seg, long index) {
        return (int)constants$154.const$2.get(seg, index * sizeof());    }
    public static void type$set(MemorySegment seg, long index, int x) {
        constants$154.const$2.set(seg, index * sizeof(), x);
    }
    public static MemorySegment common$slice(MemorySegment seg) {
        return seg.asSlice(0, 8);
    }
    public static MemorySegment display$slice(MemorySegment seg) {
        return seg.asSlice(0, 20);
    }
    public static MemorySegment window$slice(MemorySegment seg) {
        return seg.asSlice(0, 24);
    }
    public static MemorySegment key$slice(MemorySegment seg) {
        return seg.asSlice(0, 32);
    }
    public static MemorySegment edit$slice(MemorySegment seg) {
        return seg.asSlice(0, 52);
    }
    public static MemorySegment editExt$slice(MemorySegment seg) {
        return seg.asSlice(0, 32);
    }
    public static MemorySegment text$slice(MemorySegment seg) {
        return seg.asSlice(0, 44);
    }
    public static MemorySegment motion$slice(MemorySegment seg) {
        return seg.asSlice(0, 36);
    }
    public static MemorySegment button$slice(MemorySegment seg) {
        return seg.asSlice(0, 28);
    }
    public static MemorySegment wheel$slice(MemorySegment seg) {
        return seg.asSlice(0, 44);
    }
    public static MemorySegment jaxis$slice(MemorySegment seg) {
        return seg.asSlice(0, 20);
    }
    public static MemorySegment jball$slice(MemorySegment seg) {
        return seg.asSlice(0, 20);
    }
    public static MemorySegment jhat$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment jbutton$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment jdevice$slice(MemorySegment seg) {
        return seg.asSlice(0, 12);
    }
    public static MemorySegment jbattery$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment caxis$slice(MemorySegment seg) {
        return seg.asSlice(0, 20);
    }
    public static MemorySegment cbutton$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment cdevice$slice(MemorySegment seg) {
        return seg.asSlice(0, 12);
    }
    public static MemorySegment ctouchpad$slice(MemorySegment seg) {
        return seg.asSlice(0, 32);
    }
    public static MemorySegment csensor$slice(MemorySegment seg) {
        return seg.asSlice(0, 40);
    }
    public static MemorySegment adevice$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment sensor$slice(MemorySegment seg) {
        return seg.asSlice(0, 48);
    }
    public static MemorySegment quit$slice(MemorySegment seg) {
        return seg.asSlice(0, 8);
    }
    public static MemorySegment user$slice(MemorySegment seg) {
        return seg.asSlice(0, 32);
    }
    public static MemorySegment syswm$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment tfinger$slice(MemorySegment seg) {
        return seg.asSlice(0, 48);
    }
    public static MemorySegment mgesture$slice(MemorySegment seg) {
        return seg.asSlice(0, 40);
    }
    public static MemorySegment dgesture$slice(MemorySegment seg) {
        return seg.asSlice(0, 40);
    }
    public static MemorySegment drop$slice(MemorySegment seg) {
        return seg.asSlice(0, 24);
    }
    public static MemorySegment padding$slice(MemorySegment seg) {
        return seg.asSlice(0, 56);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


