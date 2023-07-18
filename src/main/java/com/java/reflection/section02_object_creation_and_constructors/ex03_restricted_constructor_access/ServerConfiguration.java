package com.java.reflection.section02_object_creation_and_constructors.ex03_restricted_constructor_access;

import java.net.InetSocketAddress;

public class ServerConfiguration {

    private static ServerConfiguration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfiguration(int port, String greetingMessage) {
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);
        if (serverConfigurationInstance == null) {
            serverConfigurationInstance = this;
        }
    }

    public static ServerConfiguration getInstance() { return serverConfigurationInstance; }

    public InetSocketAddress getServerAddress() { return this.serverAddress; }

    public String getGreetingMessage() { return this.greetingMessage; }

}
