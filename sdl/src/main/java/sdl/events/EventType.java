package sdl.events;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static sdl.jextract.sdl_h.*;

public enum EventType {
    FirstEvent(SDL_FIRSTEVENT()),

    /* Application events */
    Quit(SDL_QUIT()),

    /* These application events have special meaning on iOS, see README-ios.md for details */
    AppTerminating(SDL_APP_TERMINATING()),        /**< The application is being terminated by the OS
     Called on iOS in applicationWillTerminate()
     Called on Android in onDestroy()
     */
    AppLowMemory(SDL_APP_LOWMEMORY()),          /**< The application is low on memory, free memory if possible.
     Called on iOS in applicationDidReceiveMemoryWarning()
     Called on Android in onLowMemory()
     */
    AppWillEnterBackground(SDL_APP_WILLENTERBACKGROUND()), /**< The application is about to enter the background
     Called on iOS in applicationWillResignActive()
     Called on Android in onPause()
     */
    AppDidEnterBackground(SDL_APP_DIDENTERBACKGROUND()), /**< The application did enter the background and may not get CPU for some time
     Called on iOS in applicationDidEnterBackground()
     Called on Android in onPause()
     */
    AppWillEnterForeground(SDL_APP_WILLENTERFOREGROUND()), /**< The application is about to enter the foreground
     Called on iOS in applicationWillEnterForeground()
     Called on Android in onResume()
     */
    AppDiDEnterForeground(SDL_APP_DIDENTERFOREGROUND()), /**< The application is now interactive
     Called on iOS in applicationDidBecomeActive()
     Called on Android in onResume()
     */

    LocaleChanged(SDL_LOCALECHANGED()),  /**< The user's locale preferences have changed. */

    /* Display events */
    DisplayEvent(SDL_DISPLAYEVENT()),  /**< Display state change */

    /* Window events */
    WindowEvent(SDL_WINDOWEVENT()), /**< Window state change */
    SysWmEvent(SDL_SYSWMEVENT()),             /**< System specific event */

    /* Keyboard events */
    KeyDown(SDL_KEYDOWN()), /**< Key pressed */
    KeyUp(SDL_KEYUP()),                  /**< Key released */
    TextEditing(SDL_TEXTEDITING()),            /**< Keyboard text editing (composition) */
    TextInput(SDL_TEXTINPUT()),              /**< Keyboard text input */
    KeyMapChanged(SDL_KEYMAPCHANGED()),          /**< Keymap changed due to a system event such as an
     input language or keyboard layout change.
     */
    TextEditingExt(SDL_TEXTEDITING_EXT()),       /**< Extended keyboard text editing (composition) */

    /* Mouse events */
    MouseMotion(SDL_MOUSEMOTION()), /**< Mouse moved */
    MouseButtonDown(SDL_MOUSEBUTTONDOWN()),        /**< Mouse button pressed */
    MouseButtonUp(SDL_MOUSEBUTTONUP()),          /**< Mouse button released */
    MouseWheel(SDL_MOUSEWHEEL()),             /**< Mouse wheel motion */

    /* Joystick events */
    JoyAxisMotion(SDL_JOYAXISMOTION()), /**< Joystick axis motion */
    JoyBallMotion(SDL_JOYBALLMOTION()),          /**< Joystick trackball motion */
    JoyHatMotion(SDL_JOYHATMOTION()),           /**< Joystick hat position change */
    JoyButtonDown(SDL_JOYBUTTONDOWN()),          /**< Joystick button pressed */
    JoyButtonUp(SDL_JOYBUTTONUP()),            /**< Joystick button released */
    JoyDeviceAdded(SDL_JOYDEVICEADDED()),         /**< A new joystick has been inserted into the system */
    JoyDeviceRemoved(SDL_JOYDEVICEREMOVED()),       /**< An opened joystick has been removed */
    JoyBatteryUpdated(SDL_JOYBATTERYUPDATED()),      /**< Joystick battery level change */

    /* Game controller events */
    ControllerAxisMotion(SDL_CONTROLLERAXISMOTION()), /**< Game controller axis motion */
    ControllerButtonDown(SDL_CONTROLLERBUTTONDOWN()),          /**< Game controller button pressed */
    ControllerButtonUp(SDL_CONTROLLERBUTTONUP()),            /**< Game controller button released */
    ControllerDeviceAdded(SDL_CONTROLLERDEVICEADDED()),         /**< A new Game controller has been inserted into the system */
    ControllerDeviceRemoved(SDL_CONTROLLERDEVICEREMOVED()),       /**< An opened Game controller has been removed */
    ControllerDeviceRemapped(SDL_CONTROLLERDEVICEREMAPPED()),      /**< The controller mapping was updated */
    ControllerTouchpadDown(SDL_CONTROLLERTOUCHPADDOWN()),        /**< Game controller touchpad was touched */
    ControllerTouchpadMotion(SDL_CONTROLLERTOUCHPADMOTION()),      /**< Game controller touchpad finger was moved */
    ControllerTouchpadUp(SDL_CONTROLLERTOUCHPADUP()),          /**< Game controller touchpad finger was lifted */
    ControllerSensorUpdate(SDL_CONTROLLERSENSORUPDATE()),        /**< Game controller sensor was updated */

    /* Touch events */
    FingerDown(SDL_FINGERDOWN()),
    FingerUp(SDL_FINGERUP()),
    FingerMotion(SDL_FINGERMOTION()),

    /* Gesture events */
    DollarGesture(SDL_DOLLARGESTURE()),
    DollarRecord(SDL_DOLLARRECORD()),
    MultiGesture(SDL_MULTIGESTURE()),

    /* Clipboard events */
    ClipboardUpdate(SDL_CLIPBOARDUPDATE()), /**< The clipboard or primary selection changed */

    /* Drag and drop events */
    DropFile(SDL_DROPFILE()), /**< The system requests a file open */
    DropText(SDL_DROPTEXT()),                 /**< text/plain drag-and-drop event */
    DropBegin(SDL_DROPBEGIN()),                /**< A new set of drops is beginning (NULL filename) */
    DropComplete(SDL_DROPCOMPLETE()),             /**< Current set of drops is now complete (NULL filename) */

    /* Audio hotplug events */
    AudioDeviceAdded(SDL_AUDIODEVICEADDED()), /**< A new audio device is available */
    AudioDeviceRemoved(SDL_AUDIODEVICEREMOVED()),        /**< An audio device has been removed. */

    /* Sensor events */
    SensorUpdate(SDL_SENSORUPDATE()),     /**< A sensor was updated */

    /* Render events */
    RenderTargetsReset(SDL_RENDER_TARGETS_RESET()), /**< The render targets have been reset and their contents need to be updated */
    RenderDeviceReset(SDL_RENDER_DEVICE_RESET()), /**< The device has been reset and all textures need to be recreated */

    /* Internal events */
    PollSentinel(SDL_POLLSENTINEL()), /**< Signals the end of an event poll cycle */

    /** Events ::SDL_USEREVENT through ::SDL_LASTEVENT are for your use,
     *  and should be allocated with SDL_RegisterEvents()
     */
    UserEvent(SDL_USEREVENT()),

    /**
     *  This last event is only for bounding internal arrays
     */
    LastEvent(SDL_LASTEVENT()),
    ;

    private final int value;

    EventType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    private final static Map<Integer, EventType> lookup;

    static {
        lookup = new HashMap<>();
        for (EventType e: EventType.values()) {
            lookup.put(e.value(), e);
        }
    }

    public final static EventType valueOf(int value) {
        EventType x = lookup.get(value);
        if (null == x) {
            throw new NoSuchElementException("EventType = " + value);
        }
        return x;
    }
}
