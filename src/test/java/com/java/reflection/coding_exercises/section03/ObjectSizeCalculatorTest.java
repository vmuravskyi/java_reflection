package com.java.reflection.coding_exercises.section03;

import com.java.reflection.section03_fields_arrays.ex02_reading_fields_json_serializer.data.Address;
import org.junit.jupiter.api.Test;

class ObjectSizeCalculatorTest {

    @Test
    public void testSizeOfObject() throws IllegalAccessException {
        ObjectSizeCalculator osc = new ObjectSizeCalculator();

        Address address = new Address("Street 1", (short) 999);
        long size = osc.sizeOfObject(address);
        assert size == 42;
    }

}