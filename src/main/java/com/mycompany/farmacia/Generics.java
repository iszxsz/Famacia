package com.mycompany.farmacia;

public class Generics {
    public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
}
