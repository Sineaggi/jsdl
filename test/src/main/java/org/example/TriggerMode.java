package org.example;

public enum TriggerMode {
    Off((byte) 0x0), // no resistance
    Rigid((byte)0x1), // continuous resistance
    Pulse((byte) 0x2), // section resistance
    Rigid_A((byte)(0x1 | 0x20)),
    Rigid_B((byte) (0x1 | 0x04)),
    Rigid_AB((byte) (0x1 | 0x20 | 0x04)),
    Pulse_A((byte) (0x2 | 0x20)),
    Pulse_B((byte) (0x2 | 0x04)),
    Pulse_AB((byte) (0x2 | 0x20 | 0x04)),
    Calibration((byte) 0xFC),
    ;

    private final byte mode;
    TriggerMode(byte mode) {
        this.mode = mode;
    }
    public byte value() {
        return mode;
    }
}
