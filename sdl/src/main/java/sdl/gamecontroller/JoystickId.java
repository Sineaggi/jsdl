package sdl.gamecontroller;

public class JoystickId {
    private final int joystickId;
    private JoystickId(int joystickId) {
        this.joystickId = joystickId;
    }
    public static JoystickId wrap(int joystickId) {
        return new JoystickId(joystickId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JoystickId other) {
            return other.joystickId == joystickId;
        } else {
            return false;
        }
    }
}
