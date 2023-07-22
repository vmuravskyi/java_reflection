package com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data_with_array;

public class Movie {
    private final String name;
    private final float rating;
    private final String[] categories;
    private final Actor[] actors;

    public Movie(String name, float rating, String[] categories, Actor[] actors) {
        this.name = name;
        this.rating = rating;
        this.categories = categories;
        this.actors = actors;
    }
}
