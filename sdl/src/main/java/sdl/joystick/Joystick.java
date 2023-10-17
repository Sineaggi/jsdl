package sdl.joystick;

import sdl.Cause;
import sdl.GameControllerAxis;
import sdl.gamecontroller.GameControllerButton;
import sdl.SdlException;
import sdl.events.GeneralInputStateDefinitions;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static sdl.Cause.JoystickGetDeviceInstanceID;
import static sdl.Cause.JoystickOpen;
import static sdl.Cause.JoystickAttachVirtualEx;
import static sdl.jextract.sdl_h.*;
import static sdl.jextract.sdl_h.SDL_JoystickDetachVirtual;
import static sdl.jextract.sdl_h_1.SDL_JoystickGetDeviceProduct;

public class Joystick {
    public static final short AXIS_MIN = (short)SDL_JOYSTICK_AXIS_MIN();
    public static final short AXIS_MAX = (short)SDL_JOYSTICK_AXIS_MAX();
    private final MemorySegment joystick;
    public Joystick(MemorySegment joystick) {
        this.joystick = joystick;
    }

    public static int numJoysticks() {
        int numJoysticks = SDL_NumJoysticks();
        if (numJoysticks < 0) {
            throw new SdlException(Cause.NumJoysticks);
        }
        return numJoysticks;
    }

    public static String getDeviceGUIDString(int deviceIndex) {

        try (var arena = Arena.ofConfined()) {
            var guid = arena.allocate(64);
            // todo: handle case where SDL_JoystickGetDeviceGUID can fail
            SDL_JoystickGetGUIDString(SDL_JoystickGetDeviceGUID(arena, deviceIndex), guid, (int) guid.byteSize());
            // todo: validate this is correct
            return guid.getUtf8String(0);
        }
    }

    public static JoystickId getDeviceInstanceId(int deviceIndex) {
        int controller_id = SDL_JoystickGetDeviceInstanceID(deviceIndex);
        if (controller_id < 0) {
            throw new SdlException(JoystickGetDeviceInstanceID);
        }
        return JoystickId.wrap(controller_id);
    }

    public static Joystick wrap(MemorySegment joystick) {
        return new Joystick(joystick);
    }

    public static Joystick open(int deviceIndex) {
        MemorySegment joystick = SDL_JoystickOpen(deviceIndex);
        if (joystick.equals(MemorySegment.NULL)) {
            throw new SdlException(JoystickOpen);
        }
        return new Joystick(joystick);
    }

    public static int attachVirtual(VirtualJoystickDesc desc) {
        try (var arena = Arena.ofConfined()) {
            int joystickIndex = SDL_JoystickAttachVirtualEx(desc.allocateAndFill(arena));
            if (joystickIndex < 0) {
                throw new SdlException(JoystickAttachVirtualEx);
            }
            return joystickIndex;
        }
    }

    public static boolean isVirtual(int deviceIndex) {
        return SDL_JoystickIsVirtual(deviceIndex) == SDL_TRUE();
    }

    public static void detachVirtual(int deviceIndex) {
        if (SDL_JoystickDetachVirtual(deviceIndex) == -1) {
            throw new RuntimeException(STR."failed to detach virtual joystick \{deviceIndex}");
        }
    }

    public static short getDeviceVendor(int deviceIndex) {
        return SDL_JoystickGetDeviceVendor(deviceIndex);
    }

    public static short getDeviceProduct(int deviceIndex) {
        return SDL_JoystickGetDeviceProduct(deviceIndex);
    }

    public static int getDevicePlayerIndex(int deviceIndex) {
        return SDL_JoystickGetDevicePlayerIndex(deviceIndex);
    }

    public JoystickId instanceId() {
        return JoystickId.wrap(SDL_JoystickInstanceID(joystick));
    }

    /**
     * Set values on an opened, virtual-joystick's button.
     * @param button the specific button on the virtual joystick to set.
     * @param value the new value for the specified button.
     * @return Returns 0 on success, -1 on error.
     */
    public int setVirtualButton(GameControllerButton button, GeneralInputStateDefinitions value) {
        return SDL_JoystickSetVirtualButton(joystick, button.value(), (byte) value.value());
    }

    public int setVirtualAxis(GameControllerAxis axis, short value) {
        return SDL_JoystickSetVirtualAxis(joystick, axis.value(), value);
    }

    public void close() {
        SDL_JoystickClose(joystick);
    }
}
