package com;
import java.util.Locale;
public class SetLocale {
    static Locale currentLocale = Locale.getDefault();
    public static void changeLocale(String languageTag){
        currentLocale=Locale.forLanguageTag(languageTag);
    }
    public static Locale getLocale(){
        return currentLocale;
    }
}
