package com.java.reflection.coding_exercises.section03;

import java.lang.reflect.Array;

public class ArrayReader {

    public Object getArrayElement(Object array, int index) {
        return index >= 0 ? Array.get(array, index) : Array.get(array, Array.getLength(array) + index);
    }

}
