package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.ai_version;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * A helper class for performing dependency injection.
 */
public class DependencyInjector {

    private Map<Class<?>, Object> instances;

    /**
     * Constructs a new DependencyInjector object.
     */
    public DependencyInjector() {
        instances = new HashMap<>();
    }

    /**
     * Instantiates an object of the specified class, performing dependency injection if necessary.
     *
     * @param clazz the class to instantiate
     * @param <T>   the type of the object to instantiate
     * @return an instance of the specified class with dependencies injected
     * @throws InstantiationException    if the specified class cannot be instantiated
     * @throws IllegalAccessException    if the constructor is inaccessible
     * @throws InvocationTargetException if the constructor throws an exception
     * @throws NoSuchMethodException     if the constructor does not exist
     */
    public <T> T instantiate(Class<T> clazz) throws InstantiationException, IllegalAccessException,
        InvocationTargetException, NoSuchMethodException {
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Constructor<T> constructor = null;

        for (Constructor<?> c : constructors) {
            if (c.getAnnotation(Dependency.class) != null) {
                constructor = (Constructor<T>) c;
                break;
            }
        }

        if (constructor == null) {
            throw new NoSuchMethodException("No constructor found with @Dependency annotation");
        }

        constructor.setAccessible(true);

        T instance = constructor.newInstance();
        instances.put(clazz, instance);

        initializeDependencies(instance);

        return instance;
    }

    /**
     * Initializes the dependencies of the specified instance by recursively instantiating and injecting them.
     *
     * @param instance the instance whose dependencies should be initialized
     * @param <T>      the type of the instance
     * @throws IllegalAccessException    if the constructor is inaccessible
     * @throws InstantiationException    if a dependency cannot be instantiated
     * @throws InvocationTargetException if a constructor throws an exception
     * @throws NoSuchMethodException     if a constructor does not exist
     */
    private <T> void initializeDependencies(T instance) throws IllegalAccessException, InstantiationException,
        InvocationTargetException, NoSuchMethodException {
        Class<?> clazz = instance.getClass();
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getAnnotation(Dependency.class) != null) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] dependencies = new Object[parameterTypes.length];

                for (int i = 0; i < parameterTypes.length; i++) {
                    dependencies[i] = instantiate(parameterTypes[i]);
                }

                constructor.setAccessible(true);
                constructor.newInstance(dependencies);
            }
        }
    }
}
