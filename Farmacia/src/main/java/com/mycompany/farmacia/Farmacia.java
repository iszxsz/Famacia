package com.mycompany.farmacia;

import com.mycompany.farmacia.view.TelaInicial;
import com.mycompany.farmacia.dao.ProdutoDAO;
import com.mycompany.farmacia.dao.RelatorioDAO;


public class Farmacia {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
}
