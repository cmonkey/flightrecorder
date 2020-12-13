package org.excavator.boot.flightrecorder;

import java.io.IOException;
import java.nio.*;
import java.lang.ProcessBuilder.*;

public class DBB{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("nmt baseline: %n");
        new ProcessBuilder("jcmd", Long.toString(ProcessHandle.current().pid()), "VM.native_memory", "baseline")
                .redirectOutput(Redirect.INHERIT)
            .redirectError(Redirect.INHERIT)
            .start()
            .waitFor();
        var bbCount = Integer.parseInt(args[0]);
        var bbSizeMiB = Integer.parseInt(args[1]);
        for (var i = 0;  i < bbCount; i++) {
            var byteBuffer = ByteBuffer.allocateDirect(bbSizeMiB * 1024 * 1024)
                .putInt(0, 0x01);
        }

        System.out.printf("nmt summary.diff: %n");

        new ProcessBuilder("jcmd", Long.toString(ProcessHandle.current().pid()), "VM.native_memory", "summary.diff")
            .redirectOutput(Redirect.INHERIT)
            .redirectError(Redirect.INHERIT)
            .start()
            .waitFor();
    }
}
