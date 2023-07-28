package com.java.reflection.coding_exercises.section04;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ArrayFlatteningTest {

    @Test
    public void testArrayFlattening() {
        ArrayFlattening arrayFlattening = new ArrayFlattening();

        String[] actual = arrayFlattening.concat(String.class, new String[]{"a", "b"}, "c", new String[]{"d", "e"});
        String[] expected = new String[]{"a", "b", "c", "d", "e"};

        assert Arrays.equals(actual, expected);
    }

}