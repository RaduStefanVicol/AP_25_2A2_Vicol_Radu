package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classUseClass = Class.forName("org.example.UseClass");

        System.out.println("Metode in UseClass:");
        for (Method method : classUseClass.getDeclaredMethods()) {
            System.out.println("  " + method);
        }

        System.out.println("\nUtilizare metode:\n");

        for (Method method : classUseClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                    System.out.println("Invocare metoda test: " + method.getName());
                    try {
                        method.invoke(null);
                    } catch (Exception e) {
                        System.out.println("Eroare la invocare: " + e.getMessage());
                    }
                }
            }
        }
    }
}
