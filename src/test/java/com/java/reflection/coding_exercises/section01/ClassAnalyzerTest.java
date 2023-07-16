package com.java.reflection.coding_exercises.section01;

import org.junit.jupiter.api.Test;

class ClassAnalyzerTest {

    @Test
    public void testClassAnalyzer() {
        boolean jdkClass = ClassAnalyzer.isJdkClass(Object.class);
        assert jdkClass;

        String[] allInheritedClassNames = ClassAnalyzer.getAllInheritedClassNames(int.class);
        assert allInheritedClassNames == null;
    }

}