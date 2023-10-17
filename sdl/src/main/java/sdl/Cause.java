package sdl;

public enum Cause {
    OpenGameController("Couldn't open controller"),
    NumJoysticks("Couldn't query number of joysticks"),
    CreateWindow("Couldn't create window"),
    CreateRenderer("Couldn't create renderer"),
    JoystickGetDeviceInstanceID("Couldn't get controller ID"),
    SetRenderDrawColor("Couldn't set renderer draw color"),
    RenderClear("Couldn't clear renderer"),
    PeepEvents("Couldn't peep events"),
    SetTextureColorMod("Couldn't set texture color mod"),
    Init("Couldn't initialize SDL"),
    LoadBMP_RW("Couldn't load BMP"),
    CreateTextureFromSurface("Couldn't create texture from surface"),
    GameControllerAddMappingsFromRW("Couldn't add game controller mappings"),
    SetColorKey("Couldn't set color key"),
    JoystickAttachVirtualEx("Couldn't open virtual device"),
    JoystickOpen("Couldn't open virtual device"),
    ;

    private final String cause;
    Cause(String cause) {
        this.cause = cause;
    }
    public String cause() {
        return cause;
    }
}
