package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        int validCommand = 0;
        Locale currentLocale = new Locale("ro", "RO");
        ResourceBundle resources = ResourceBundle.getBundle("res.Messages", currentLocale);
        String command = "placeholder";
        Scanner scanner = new Scanner(System.in);

        while (!command.equalsIgnoreCase("exit")) {
            validCommand = 0;
            System.out.println(resources.getString("prompt"));
            command = scanner.next();

            if (command.equalsIgnoreCase("locales")) {
                DisplayLocales.displayLocales(resources);
                validCommand = 1;
            }

            if (command.equalsIgnoreCase("info")) {
                Info.showInfo(currentLocale, resources);
                validCommand = 1;
            }

            if (command.equalsIgnoreCase("setlocale")) {
                String tag = scanner.next(); // "ro-RO"
                SetLocale.changeLocale(tag);

                currentLocale = SetLocale.getLocale();
                resources = ResourceBundle.getBundle("res.Messages", currentLocale);

                System.out.println(
                        resources.getString("locale.set").replace("{0}", currentLocale.toString()));
                validCommand = 1;
            }

            if (validCommand == 0 && (!command.equalsIgnoreCase("exit"))) {
                System.out.println(resources.getString("invalid"));
            }
        }

        scanner.close();
    }
}
