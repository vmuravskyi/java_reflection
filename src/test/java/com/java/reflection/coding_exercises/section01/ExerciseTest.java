package com.java.reflection.coding_exercises.section01;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ExerciseTest {

    @Test
    void testFindAllImplementedInterfaces() {
        Set<Class<?>> interfaces = Exercise.findAllImplementedInterfaces(A.class);
        assert interfaces.size() == 3;
    }

    @Test
    void testFindAllImplementedInterfacesWithArrayList() {
        List<Class<?>> expected = new ArrayList<>();
        expected.add(Serializable.class);
        expected.add(List.class);
        expected.add(Cloneable.class);
        expected.add(RandomAccess.class);
        expected.add(Collection.class);
        expected.add(Iterable.class);

        Set<Class<?>> interfaces = Exercise.findAllImplementedInterfaces(ArrayList.class);
        assert interfaces.containsAll(expected);
    }

}