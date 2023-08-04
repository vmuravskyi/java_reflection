package com.java.reflection.section05_methods_discovery_invocation.ex02_method_invocation.logging;

import java.io.IOException;

public class FileLogger {

    public void sendRequest(String data) throws IOException {
        throw new IOException("Failed saving request to a file");
        //System.out.println(String.format("Data : %s was logged to the file system", data));
    }

}
