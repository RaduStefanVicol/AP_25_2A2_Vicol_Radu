package com;

import java.text.SimpleDateFormat;
import java.util.*;

public class DisplayLocales {

    public static void displayLocales(ResourceBundle resources) {
        Locale[] locales = SimpleDateFormat.getAvailableLocales();
        Set<String> sortedLocales = new TreeSet<>();

        for (Locale locale : locales) {
            String entry = locale.getDisplayName() + "\t:\t" + locale.toString();
            sortedLocales.add(entry);
        }

        System.out.println(resources.getString("locales"));

        for (String s : sortedLocales) {
            System.out.println(s);
        }
    }
}
