package com.edu.factory.i18n;

public class Software {
    public static void main(String[] args) {
        I18n i18n = I18NFactory.getI18NObject("USA");
        System.out.println(i18n.getTitle());
    }
}
