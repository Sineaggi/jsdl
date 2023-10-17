package sdl.joystick;

import sdl.jextract.SDL_VirtualJoystickDesc;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

import static sdl.internal.Util.toShortExact;
import static sdl.jextract.sdl_h.SDL_VIRTUAL_JOYSTICK_DESC_VERSION;

public record VirtualJoystickDesc(
        short type,        /**< `SDL_JoystickType` */
        short naxes,       /**< the number of axes on this joystick */
        short nbuttons,    /**< the number of buttons on this joystick */
        short nhats,       /**< the number of hats on this joystick */
        short vendor_id,   /**< the USB vendor ID of this joystick */
        short product_id,  /**< the USB product ID of this joystick */
        int button_mask, /**< A mask of which buttons are valid for this controller
 e.g. (1 << SDL_CONTROLLER_BUTTON_A) */
        int axis_mask,   /**< A mask of which axes are valid for this controller
 e.g. (1 << SDL_CONTROLLER_AXIS_LEFTX) */
        String name,   /**< the name of the joystick */
        MemorySegment userData,
        Update update,
        SetPlayerIndex setPlayerIndex,
        Rumble rumble,
        RumbleTriggers rumbleTriggers,
        SetLED setLED,
        SendEffect sendEffect
) {
    // todo: callback lifecycle
    public MemorySegment allocateAndFill(SegmentAllocator allocator) {
        MemorySegment desc = SDL_VirtualJoystickDesc.allocate(allocator);
        SDL_VirtualJoystickDesc.version$set(desc, toShortExact(SDL_VIRTUAL_JOYSTICK_DESC_VERSION()));
        SDL_VirtualJoystickDesc.type$set(desc, type);
        SDL_VirtualJoystickDesc.naxes$set(desc, naxes);
        SDL_VirtualJoystickDesc.nbuttons$set(desc, nbuttons);
        SDL_VirtualJoystickDesc.nhats$set(desc, nhats);
        SDL_VirtualJoystickDesc.vendor_id$set(desc, vendor_id);
        SDL_VirtualJoystickDesc.product_id$set(desc, product_id);
        SDL_VirtualJoystickDesc.button_mask$set(desc, button_mask);
        SDL_VirtualJoystickDesc.axis_mask$set(desc, axis_mask);
        if (name != null) {
            SDL_VirtualJoystickDesc.name$set(desc, allocator.allocateUtf8String(name));
        }
        if (userData != null) {
            SDL_VirtualJoystickDesc.userdata$set(desc, userData);
        }
        if (update != null) {
            SDL_VirtualJoystickDesc.Update$set(desc, SDL_VirtualJoystickDesc.Update.allocate(update, Arena.global()));
        }
        if (setPlayerIndex != null) {
            SDL_VirtualJoystickDesc.SetPlayerIndex.allocate(setPlayerIndex, Arena.global());
        }
        if (rumble != null) {
            SDL_VirtualJoystickDesc.Rumble.allocate(rumble, Arena.global());
        }
        if (rumbleTriggers != null) {
            SDL_VirtualJoystickDesc.RumbleTriggers.allocate(rumbleTriggers, Arena.global());
        }
        if (setLED != null) {
            SDL_VirtualJoystickDesc.SetLED.allocate(setLED, Arena.global());
        }
        if (sendEffect != null) {
            SDL_VirtualJoystickDesc.SendEffect.allocate(sendEffect, Arena.global());
        }
        return desc;
    }

    public interface Update extends SDL_VirtualJoystickDesc.Update { }
    public interface SetPlayerIndex extends SDL_VirtualJoystickDesc.SetPlayerIndex { }
    public interface Rumble extends SDL_VirtualJoystickDesc.Rumble { }
    public interface RumbleTriggers extends SDL_VirtualJoystickDesc.RumbleTriggers { }
    public interface SetLED extends SDL_VirtualJoystickDesc.SetLED { }
    public interface SendEffect extends SDL_VirtualJoystickDesc.SendEffect { }
}
