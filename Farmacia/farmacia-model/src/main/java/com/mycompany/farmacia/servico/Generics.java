package com.mycompany.farmacia.servico;

public class Generics {
    public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
}
