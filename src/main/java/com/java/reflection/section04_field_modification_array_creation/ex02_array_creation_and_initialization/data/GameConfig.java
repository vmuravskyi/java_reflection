package com.java.reflection.section04_field_modification_array_creation.ex02_array_creation_and_initialization.data;

public class GameConfig {

    private int releaseYear;
    private String getName;
    private double price;

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGetName() {
        return getName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
            "releaseYear=" + releaseYear +
            ", getName='" + getName + '\'' +
            ", price=" + price +
            '}';
    }

}
