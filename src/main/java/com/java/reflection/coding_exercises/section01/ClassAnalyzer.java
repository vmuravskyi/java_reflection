package com.java.reflection.coding_exercises.section01;

import java.util.Arrays;
import java.util.List;

public class ClassAnalyzer {
    private static final List<String> JDK_PACKAGE_PREFIXES =
        Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");

    public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
        PopupTypeInfo popupTypeInfo = new PopupTypeInfo();

        /** Complete the Code **/

        popupTypeInfo.setPrimitive(inputClass.isPrimitive())
            .setInterface(inputClass.isInterface())
            .setEnum(inputClass.isEnum())
            .setName(inputClass.getSimpleName())
            .setJdk(isJdkClass(inputClass))
            .addAllInheritedClassNames(getAllInheritedClassNames(inputClass));

        return popupTypeInfo;
    }

    /*********** Helper Methods ***************/

    public static boolean isJdkClass(Class<?> inputClass) {
        /** Complete the code
         Hint: What does inputClass.getPackage() return when the class is a primitive type?
         **/
        return inputClass.isPrimitive()
            ? true
            : JDK_PACKAGE_PREFIXES.stream().anyMatch(s -> inputClass.getPackage().getName().startsWith(s));
    }

    public static String[] getAllInheritedClassNames(Class<?> inputClass) {
        /** Complete the code
         Hints: What does inputClass.getSuperclass() return when the inputClass doesn't inherit from any class?
         What does inputClass.getSuperclass() return when the inputClass is a primitive type?
         **/
        String[] result;
        Class<?> superclass = inputClass.getSuperclass();

        if (superclass == null) {
            return null;
        }

        if (inputClass.isPrimitive()) {
            return result = new String[]{inputClass.getSimpleName()};
        }

        if (superclass.isInterface()) {
            Class<?>[] interfaces = superclass.getInterfaces();
            result = new String[interfaces.length];
            for (int i = 0; i < interfaces.length; i++) {
                result[i] = interfaces[i].getSimpleName();
            }
        } else {
            return result = new String[]{superclass.getSimpleName()};
        }
        return result;
    }
}
