package com.java.reflection.section05_methods_discovery_invocation.ex02_method_invocation.database;

public class DatabaseClient {

    public boolean storeData(String data) {
        System.out.println(String.format("Data : %s was successfully stored in the database", data));
        return true;
    }

}
