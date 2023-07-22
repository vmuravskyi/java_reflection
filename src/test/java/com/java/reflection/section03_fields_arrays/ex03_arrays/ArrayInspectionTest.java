package com.java.reflection.section03_fields_arrays.ex03_arrays;

import org.junit.jupiter.api.Test;

class ArrayInspectionTest {

    @Test
    public void testThreeDimensionalArray() {
        String expected = "[[[123, 321], [123, 321]], [[456, 654], [456, 654]], [[789, 987], [789, 987]]]";

        short[][][] arr = {
            {
                {123, 321},
                {123, 321}
            },
            {
                {456, 654},
                {456, 654}
            },
            {
                {789, 987},
                {789, 987}
            }
        };
        String actual = ArrayInspection.inspectArrayValues(arr, new StringBuilder());

        assert actual.equals(expected);
    }

}