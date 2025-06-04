package org.example;

public class UseClass {
    public static void staticHello(){
        System.out.println("Hello");
    }

    @Test
    public static void testStaticHello(){
        System.out.println("Hello");
    }

    public void simpleHello(){
        System.out.println("Hello");
    }

    @Test
    public void testHello(){
        System.out.println("Hello");
    }
}
