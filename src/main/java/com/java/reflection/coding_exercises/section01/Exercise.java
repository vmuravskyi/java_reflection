package com.java.reflection.coding_exercises.section01;

import java.util.HashSet;
import java.util.Set;

public class Exercise {

    /**
     * Returns all the interfaces that the current input class implements. Note: If the input is an interface itself,
     * the method returns all the interfaces the input interface extends.
     */
    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {
        Set<Class<?>> allImplementedInterfaces = new HashSet<>();

        Class<?>[] inputInterfaces = input.getInterfaces();
        for (Class<?> currentInterface : inputInterfaces) {
            allImplementedInterfaces.add(currentInterface);
            allImplementedInterfaces.addAll(findAllImplementedInterfaces(currentInterface));
        }

        return allImplementedInterfaces;
    }

//    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {
//        Set<Class<?>> result = new HashSet<>();
//        extractedInterfaces(result, input);
//        return result;
//    }
//
//    private static void extractedInterfaces(Set<Class<?>> result, Class<?>... input) {
//        for (Class<?> aClass : input) {
//            Class<?>[] interfaces = aClass.getInterfaces();
//            for (Class<?> anInterface : interfaces) {
//                result.add(anInterface);
//                extractedInterfaces(result, anInterface);
//            }
//
//            if (aClass.isInterface()) {
//                result.add(aClass);
//                extractedInterfaces(result, aClass.getInterfaces());
//            }
//
//            if (aClass.getSuperclass() != null) {
//                extractedInterfaces(result, aClass.getSuperclass());
//            } else {
//                break;
//            }
//        }
//    }

}
