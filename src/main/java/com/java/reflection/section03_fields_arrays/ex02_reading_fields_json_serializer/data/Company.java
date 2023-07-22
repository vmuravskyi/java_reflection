package com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data;

public class Company {

    private final String name;
    private final String city;
    private final Address address;

    public Company(String name, String city, Address address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
