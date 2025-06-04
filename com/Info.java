package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public static void showInfo(Locale locale, ResourceBundle messages) {
        System.out.println(messages.getString("info").replace("{0}", locale.toString()));

        System.out.println(messages.getString("label.country") + ": " + locale.getDisplayCountry(locale));
        System.out.println(messages.getString("label.language") + ": " + locale.getDisplayLanguage(locale));

        try {
            Currency currency = Currency.getInstance(locale);
            System.out.println(messages.getString("label.currency") + ": " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        } catch (IllegalArgumentException e) {
            System.out.println(messages.getString("label.currency") + ": N/A");
        }

        String[] weekdays = new DateFormatSymbols(locale).getWeekdays();
        System.out.print(messages.getString("label.weekdays") + ": ");
        for (int i = Calendar.MONDAY; i <= Calendar.SATURDAY; i++) {
            if (!weekdays[i].isEmpty())
                System.out.print(weekdays[i] + ", ");
        }

        if (!weekdays[Calendar.SUNDAY].isEmpty()) {
            System.out.print(weekdays[Calendar.SUNDAY]);
        }
        System.out.println();

        String[] months = new DateFormatSymbols(locale).getMonths();
        System.out.print(messages.getString("label.months") + ": ");
        for (int i = 0; i < months.length; i++) {
            if (months[i] == null || months[i].isEmpty()) break;
            System.out.print(months[i]);
            if (i < months.length - 1 && !months[i+1].isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();

        Date today = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(messages.getString("label.today") + ": " + dateFormat.format(today));
    }
}
