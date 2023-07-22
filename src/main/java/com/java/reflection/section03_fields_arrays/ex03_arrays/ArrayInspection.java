package com.java.reflection.section03_fields_arrays.ex03_arrays;

import java.lang.reflect.Array;

public class ArrayInspection {

    public static void main(String[] args) {
        int[] oneDimensionalArray = {1, 2};

        double[][] twoDimensionalArray = {
            {1.5},
            {2.5},
            {3.5},
            {4.5},
        };

//        inspectArrayObject(oneDimensionalArray);
//        System.out.print("\n");
//        inspectArrayObject(twoDimensionalArray);

        inspectArrayValues(twoDimensionalArray, new StringBuilder());
    }

    /**
     * @param arrayObject array
     * @param sb          new StringBuilder
     * @return string representation of any-dimensional array
     */
    public static String inspectArrayValues(Object arrayObject, StringBuilder sb) {
        int arrayLength = Array.getLength(arrayObject);

        sb.append("[");
        for (int i = 0; i < arrayLength; i++) {
            Object arrayElement = Array.get(arrayObject, i);

            // if object is array call this method recursively
            if (arrayElement.getClass().isArray()) {
                inspectArrayValues(arrayElement, sb);
            } else {
                sb.append(arrayElement);
            }

            if (i != arrayLength - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void inspectArrayObject(Object arrayObject) {
        Class<?> clazz = arrayObject.getClass();

        System.out.print(String.format("isArray : %s%n", clazz.isArray()));

        Class<?> arrayComponentType = clazz.getComponentType();

        System.out.print(String.format("array component type : %s%n", arrayComponentType.getTypeName()));
    }

}
