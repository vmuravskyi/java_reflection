package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.init;

import com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.Game;
import com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.internal.TicTacToeGame;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Game game = createObjectRecursively(TicTacToeGame.class);
        game.startGame();
    }

    private static <T> T createObjectRecursively(Class<?> clazz)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getFirstConstructor(clazz);

        List<Object> constructorArguments = new ArrayList<>();

        for (Class<?> argumentType : constructor.getParameterTypes()) {
            Object argumentValue = createObjectRecursively(argumentType);
            constructorArguments.add(argumentValue);
        }

        constructor.setAccessible(true);
        return (T) constructor.newInstance(constructorArguments.toArray());
    }

    private static Constructor<?> getFirstConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new IllegalStateException(String.format("No constructor have been found for %s", clazz.getClasses()));
        }

        return constructors[0];
    }

}
