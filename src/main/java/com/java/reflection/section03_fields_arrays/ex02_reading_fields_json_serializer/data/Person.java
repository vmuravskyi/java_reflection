package com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data;

public class Person {
    private final String name;
    private final boolean employed;
    private final int age;
    private final float salary;
    private final Address address;
    private final Company job;

    public Person(String name, Address address, Company company, boolean employed, int age, float salary) {
        this.name = name;
        this.address = address;
        this.job = company;
        this.employed = employed;
        this.age = age;
        this.salary = salary;
    }
}
