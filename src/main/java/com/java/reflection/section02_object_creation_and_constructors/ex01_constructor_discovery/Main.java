package com.java.reflection.section02_object_creation_and_constructors.ex01_constructor_discovery;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        printConstructorData(Address.class);
    }

    public static void printConstructorData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        System.out.println(String.format("class %s has %s constructors", clazz.getSimpleName(), constructors.length));

        for (int i = 0; i < constructors.length; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                .map(aClass -> aClass.getSimpleName())
                .collect(Collectors.toList());
            System.out.println(parameterTypeNames);
        }
    }

    public static class Person {

        private final Address address;
        private final String name;
        private final int age;

        public Person() {
            this.name = "anonymous";
            this.age = 0;
            this.address = null;
        }

        public Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }
    }

    public static class Address {

        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }
    }

}
