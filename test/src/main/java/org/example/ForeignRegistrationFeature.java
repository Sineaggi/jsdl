package org.example;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeForeignAccess;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;

import static java.lang.foreign.ValueLayout.*;

class ForeignRegistrationFeature implements Feature {

    public void duringSetup(DuringSetupAccess access) {
        registerDowncalls();
    }

    private void registerDowncalls() {
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid());
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(), Linker.Option.isTrivial());
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_INT, JAVA_INT, JAVA_INT));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(JAVA_LONG, JAVA_LONG, JAVA_LONG));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.of(ADDRESS, JAVA_INT, JAVA_INT), Linker.Option.firstVariadicArg(1));
        RuntimeForeignAccess.registerForDowncall(FunctionDescriptor.ofVoid(JAVA_INT), Linker.Option.captureCallState("errno"));
    }
}
