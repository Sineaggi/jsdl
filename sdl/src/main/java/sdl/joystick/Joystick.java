package sdl.joystick;

import sdl.Cause;
import sdl.GameControllerAxis;
import sdl.GameControllerButton;
import sdl.SdlException;
import sdl.events.GeneralInputStateDefinitions;
import sdl.gamecontroller.JoystickId;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static sdl.Cause.JoystickGetDeviceInstanceID;
import static sdl.SDL_subset_h.*;
import static sdl.jextract.SDL_subset_h.*;

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
        return SDL_JoystickSetVirtualButton(joystick, button.value(), value.value());
    }

    public int setVirtualAxis(GameControllerAxis axis, short value) {
        return SDL_JoystickSetVirtualAxis(joystick, axis.value(), value);
    }
}
