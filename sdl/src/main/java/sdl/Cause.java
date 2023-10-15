package sdl;

public enum Cause {
    OpenGameController("Couldn't open controller"),
    NumJoysticks("Couldn't query number of joysticks"),
    CreateWindow("Couldn't create window"),
    CreateRenderer("Couldn't create renderer"),
    JoystickGetDeviceInstanceID("Couldn't get controller ID");
    ;

    private final String cause;
    Cause(String cause) {
        this.cause = cause;
    }
    public String cause() {
        return cause;
    }
}
