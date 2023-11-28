package sdl.scancode;

public class Scancode {
    private final int i;
    private Scancode(int i) {
        this.i = i;
    }
    public static Scancode valueOf(int i) {
        return null;
    }

    @Override
    public String toString() {
        return "Scancode{" +
                "i=" + i +
                '}';
    }
}
