package org.example;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classUseClass = Class.forName("org.example.UseClass");
        UseClass object1 = new UseClass();

        System.out.println("Methods in UseClass:");
        for (Method method : classUseClass.getDeclaredMethods()) {
            System.out.println("  " + method);
        }
        System.out.println("Utilizare metode:\n");
        
    }
}