package com.java.reflection.section04_field_modification_array_creation.ex01_generic_configuration_file_parser.configloader;

import com.java.reflection.section04_field_modification_array_creation.ex01_generic_configuration_file_parser.data.GameConfig;
import com.java.reflection.section04_field_modification_array_creation.ex01_generic_configuration_file_parser.data.UserInterfaceConfig;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final Path GAME_CONFIG_PATH = Path.of("src/main/resources/ex01_generic_configuration_file_parser/game-properties.cfg");
    private static final Path UI_CONFIG_PATH = Path.of("src/main/resources/ex01_generic_configuration_file_parser/user-interface.cfg");

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        GameConfig configObGameConfig = createConfigObject(GameConfig.class, GAME_CONFIG_PATH);
        UserInterfaceConfig userInterfaceConfig = createConfigObject(UserInterfaceConfig.class, UI_CONFIG_PATH);

        System.out.println(configObGameConfig);
        System.out.println(userInterfaceConfig);
    }

    public static <T> T createConfigObject(Class<?> clazz, Path filePath)
        throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(filePath);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T configInstance = (T) constructor.newInstance();
        while (scanner.hasNextLine()) {
            String configLine = scanner.nextLine();
            String[] nameValuePair = configLine.split("=");
            String propertyName = nameValuePair[0];
            String propertyValue = nameValuePair[1];

            Field configField;
            try {
                configField = clazz.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                System.out.printf("Property name %s is unsupported", propertyName);
                continue;
            }

            configField.setAccessible(true);
            Object parsedValue = parseValue(configField.getType(), propertyValue);
            configField.set(configInstance, parsedValue);
        }
        return configInstance;
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type.equals(int.class)) {
            return Integer.parseInt(value);
        } else if (type.equals(long.class)) {
            return Long.parseLong(value);
        } else if (type.equals(byte.class)) {
            return Byte.parseByte(value);
        } else if (type.equals(short.class)) {
            return Short.parseShort(value);
        } else if (type.equals(float.class)) {
            return Float.parseFloat(value);
        } else if (type.equals(double.class)) {
            return Double.parseDouble(value);
        } else if (type.equals(String.class)) {
            return String.valueOf(value);
        }
        throw new RuntimeException(String.format("Type: %s unsupported", type.getTypeName()));
    }

}
