package org.example;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;
import static java.lang.foreign.MemoryLayout.PathElement;

final class constants {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants() {}

    static final StructLayout DS_5_EFFECTS_STATE_T = MemoryLayout.structLayout(
        JAVA_BYTE.withName("ucEnableBits1"),
        JAVA_BYTE.withName("ucEnableBits2"),
        JAVA_BYTE.withName("ucRumbleRight"),
        JAVA_BYTE.withName("ucRumbleLeft"),
        JAVA_BYTE.withName("ucHeadphoneVolume"),
        JAVA_BYTE.withName("ucSpeakerVolume"),
        JAVA_BYTE.withName("ucMicrophoneVolume"),
        JAVA_BYTE.withName("ucAudioEnableBits"),
        JAVA_BYTE.withName("ucMicLightMode"),
        JAVA_BYTE.withName("ucAudioMuteBits"),
        MemoryLayout.sequenceLayout(11, JAVA_BYTE).withName("rgucRightTriggerEffect"),
        MemoryLayout.sequenceLayout(11, JAVA_BYTE).withName("rgucLeftTriggerEffect"),
        MemoryLayout.sequenceLayout(6, JAVA_BYTE).withName("rgucUnknown1"),
        JAVA_BYTE.withName("ucEnableBits3"),
        MemoryLayout.sequenceLayout(2, JAVA_BYTE).withName("rgucUnknown2"),
        JAVA_BYTE.withName("ucLedAnim"),
        JAVA_BYTE.withName("ucLedBrightness"),
        JAVA_BYTE.withName("ucPadLights"),
        JAVA_BYTE.withName("ucLedRed"),
        JAVA_BYTE.withName("ucLedGreen"),
        JAVA_BYTE.withName("ucLedBlue")
    ).withName("DS5EffectsState_t");
    static final VarHandle ucEnableBits1 = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucEnableBits1"));
    static final VarHandle ucEnableBits2 = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucEnableBits2"));
    static final VarHandle ucRumbleRight = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucRumbleRight"));
    static final VarHandle ucRumbleLeft = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucRumbleLeft"));
    static final VarHandle ucHeadphoneVolume = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucHeadphoneVolume"));
    static final VarHandle ucSpeakerVolume = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucSpeakerVolume"));
    static final VarHandle ucMicrophoneVolume = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucMicrophoneVolume"));
    static final VarHandle ucAudioEnableBits = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucAudioEnableBits"));
    static final VarHandle ucMicLightMode = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucMicLightMode"));
    static final VarHandle ucAudioMuteBits = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucAudioMuteBits"));
    static final VarHandle ucEnableBits3 = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucEnableBits3"));
    static final VarHandle ucLedAnim = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucLedAnim"));
    static final VarHandle ucLedBrightness = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucLedBrightness"));
    static final VarHandle ucPadLights = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucPadLights"));
    static final VarHandle ucLedRed = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucLedRed"));
    static final VarHandle ucLedGreen = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucLedGreen"));
    static final VarHandle ucLedBlue = DS_5_EFFECTS_STATE_T.varHandle(PathElement.groupElement("ucLedBlue"));
}
