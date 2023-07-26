package com.java.reflection.coding_exercises.section03;

import org.junit.jupiter.api.Test;

class ArrayReaderTest {

    @Test
    public void testArrayReader1() {
        ArrayReader arrayReader = new ArrayReader();
        Object arrayElement = arrayReader.getArrayElement(new int[]{0, 10, 20, 30, 40}, 3);
        assert (int) arrayElement == 30;
    }

    @Test
    public void testArrayReader2() {
        ArrayReader arrayReader = new ArrayReader();
        Object arrayElement = arrayReader.getArrayElement(new String[]{"John", "Michael", "Joe", "David"}, -1);
        assert arrayElement.equals("David");
    }

}