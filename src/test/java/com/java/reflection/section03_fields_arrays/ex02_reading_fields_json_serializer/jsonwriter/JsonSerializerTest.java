package com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.jsonwriter;

import com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data_with_array.Actor;
import com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data_with_array.Movie;
import org.junit.jupiter.api.Test;

class JsonSerializerTest {

    @Test
    public void testObjectToJson() throws IllegalAccessException {
        Actor actor1 = new Actor("Elijah Wood", new String[]{"Lord of the Rings", "The Good Son"});
        Actor actor2 = new Actor("Ian McKellen", new String[]{"X-Men", "Hobbit"});
        Actor actor3 = new Actor("Orlando Bloom", new String[]{"Pirates of the Caribbean", "Kingdom of Heaven"});
        String json = JsonSerializer.objectToJson(actor1, 0);

        Movie movie = new Movie("Lord of the Rings", 8.8f, new String[]{"Action", "Adventure", "Drama"},
            new Actor[]{actor1, actor2, actor3});
        String movieJson = JsonSerializer.objectToJson(movie, 0);

        System.out.println(json);
        System.out.println(movieJson);
    }

}