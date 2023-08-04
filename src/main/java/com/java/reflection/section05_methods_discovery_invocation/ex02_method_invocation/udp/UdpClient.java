package com.java.reflection.section05_methods_discovery_invocation.ex02_method_invocation.udp;

public class UdpClient {

    public void sendAndForget(String requestPayload) {
        System.out.println(String.format("Request : %s was sent through UDP", requestPayload));
    }

}
