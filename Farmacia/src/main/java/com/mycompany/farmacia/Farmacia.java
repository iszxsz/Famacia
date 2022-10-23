package com.mycompany.farmacia;

import com.mycompany.farmacia.view.TelaInicial;

public class Farmacia {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
}
