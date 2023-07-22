package com.java.reflection.section03_fields_arrays.ex01;

import static com.java.reflection.section03_fields_arrays.ex01.Main.Category.ADVENTURE;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Movie movie = new Movie("Lord of the Rings", 2001, true, ADVENTURE, 12.99);

        printDeclaredFields(Movie.class, movie);

        Field minPriceStaticField =  Movie.class.getDeclaredField("MINIMUM_PRICE");
        System.out.println(String.format("static MINIMUM_PRICE value is: %s", minPriceStaticField.get(null)));
    }

    public static <T> void printDeclaredFields(Class<? extends T> clazz, T instance) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(String.format("Field name: %s, type: %s", field.getName(), field.getType()));

            System.out.println(String.format("Is synthetic field: %s", field.isSynthetic()));
            System.out.println(String.format("Field value is: %s", field.get(instance)));

            System.out.println();
        }
    }

    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, boolean isReleased, Category category, double actualPrice) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = actualPrice;
        }

         // nested class
        public class MovieStats {
            private double timesWatched;

             public MovieStats(double timesWatched) {
                 this.timesWatched = timesWatched;
             }

             public double getRevenue() {
                 return timesWatched * actualPrice;
             }

         }
    }

    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }

    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }

}
