package org.example;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeForeignAccess;

import java.lang.foreign.*;

import static java.lang.foreign.ValueLayout.*;

class ForeignRegistrationFeature implements Feature {
    private static final AddressLayout POINTER = ValueLayout.ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(JAVA_BYTE));
    public void duringSetup(DuringSetupAccess access) {
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                JAVA_INT,
                JAVA_LONG
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                POINTER,
                JAVA_LONG
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                JAVA_LONG
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                JAVA_INT,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                JAVA_LONG,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_DOUBLE,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                POINTER,
                POINTER,
                JAVA_LONG
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid());
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                JAVA_INT,
                POINTER,
                JAVA_LONG
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_BYTE,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                JAVA_FLOAT,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_INT,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_BYTE,
                JAVA_BYTE,
                JAVA_BYTE
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_BYTE,
                JAVA_BYTE,
                JAVA_BYTE,
                JAVA_BYTE
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                JAVA_INT,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                POINTER,
                JAVA_FLOAT,
                JAVA_FLOAT,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                JAVA_INT,
                POINTER,
                JAVA_INT,
                POINTER,
                JAVA_INT,
                JAVA_INT,
                POINTER,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                JAVA_INT,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                POINTER,
                JAVA_DOUBLE,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(MemoryLayout.structLayout(
                        MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
                ).withName("SDL_GUID"),
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                POINTER,
                JAVA_INT,
                JAVA_INT,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER,
                POINTER,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                POINTER,
                JAVA_INT,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                MemoryLayout.structLayout(
                        MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
                ).withName("SDL_GUID"),
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_INT,
                JAVA_INT,
                POINTER,
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_FLOAT,
                POINTER,
                JAVA_INT
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(
                MemoryLayout.structLayout(
                        MemoryLayout.sequenceLayout(16, JAVA_BYTE).withName("data")
                ).withName("SDL_GUID"),
                POINTER,
                POINTER,
                POINTER,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT,
                POINTER,
                JAVA_INT,
                POINTER
        ));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(POINTER));
    }
}
