package com.java.reflection.section05_methods_discovery_invocation.ex01_discovery_analysis.test;

import com.java.reflection.section05_methods_discovery_invocation.ex01_discovery_analysis.api.Product;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProductTest {

    public static void main(String[] args) {
        testGetters(Product.class);
    }

    private static Map<String, Method> mapMethodNameToMethod(Class<?> dataClass) {
        Method[] methods = dataClass.getMethods();

        Map<String, Method> nameToMethod = new HashMap<>();
        for (Method method : methods) {
            nameToMethod.put(method.getName(), method);
        }

        return nameToMethod;
    }

    public static void testGetters(Class<?> dataClass) {
        Field[] fields = dataClass.getDeclaredFields();
        Map<String, Method> stringMethodMap = mapMethodNameToMethod(dataClass);
        for (Field field : fields) {
            String getterName = "get" + capitalizeFirstLetter(field.getName());
            if (!stringMethodMap.containsKey(getterName)) {
                throw new IllegalStateException(
                    String.format("Field %s doesn't have a getter method", field.getName()));

            }

            Method getter = stringMethodMap.get(getterName);

            if (!getter.getReturnType().equals(field.getType())) {
                throw new IllegalStateException(String.format("Getter method: %s has return type %s but expected %s",
                    getter.getName(),
                    getter.getReturnType(),
                    field.getType()));
            }

            if (getter.getParameterCount() > 0) {
                throw new IllegalStateException(
                    String.format("Getter: %s has %d parameters", getter.getName(), getter.getParameterCount()));
            }
        }
    }

    private static String capitalizeFirstLetter(String name) {
        return name.substring(0, 1).toUpperCase().concat(name.substring(1));
    }

}
