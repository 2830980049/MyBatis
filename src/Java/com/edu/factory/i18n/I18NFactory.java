package com.edu.factory.i18n;

public class I18NFactory {
    public static I18n getI18NObject(String title){
        if (title.equals("China"))
            return new Chinese();
            else if (title.equals("USA"))
                return new USA();
                else
                    return null;
    }
}
