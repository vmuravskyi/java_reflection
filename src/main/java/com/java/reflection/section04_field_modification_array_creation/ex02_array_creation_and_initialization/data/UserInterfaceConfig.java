package com.java.reflection.section04_field_modification_array_creation.ex02_array_creation_and_initialization.data;

import java.util.Arrays;

public class UserInterfaceConfig {

    private String titleColor;
    private String[] titleFonts;
    private short[] footerFontSize;

    public String getTitleColor() {
        return titleColor;
    }

    public String[] getTitleFonts() {
        return titleFonts;
    }

    public short[] getFooterFontSize() {
        return footerFontSize;
    }

    @Override
    public String toString() {
        return "UserInterfaceConfig{" +
            "titleColor='" + titleColor + '\'' +
            ", titleFonts=" + Arrays.toString(titleFonts) +
            ", footerFontSize=" + Arrays.toString(footerFontSize) +
            '}';
    }

}
