package com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data_with_array;

public class Actor {
    private final String name;
    private final String[] knownForMovies;

    public Actor(String name, String[] knownForMovies) {
        this.name = name;
        this.knownForMovies = knownForMovies;
    }
}
