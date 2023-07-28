package com.java.reflection.section04_field_modification_array_creation.ex01_generic_configuration_file_parser.data;

public class UserInterfaceConfig {
    private String titleColor;
    private String footerText;
    private short titleFontSize;
    private short footerFontSize;

    public String getTitleColor() {
        return titleColor;
    }

    public String getFooterText() {
        return footerText;
    }

    public short getTitleFontSize() {
        return titleFontSize;
    }

    public short getFooterFontSize() {
        return footerFontSize;
    }

    @Override
    public String toString() {
        return "UserInterfaceConfig{" +
            "titleColor='" + titleColor + '\'' +
            ", footerText='" + footerText + '\'' +
            ", titleFontSize=" + titleFontSize +
            ", footerFontSize=" + footerFontSize +
            '}';
    }
}
