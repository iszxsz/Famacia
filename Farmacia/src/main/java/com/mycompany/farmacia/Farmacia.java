package com.mycompany.farmacia;

import com.mycompany.farmacia.dao.ProdutoDAO;
import com.mycompany.farmacia.dto.Rotulo;

public class Farmacia {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ProdutoDAO.cadastrarProduto(new Rotulo(1, "Teste"), 2, 1.00, false, "Dorflex", "10/10/2023");
                //new TelaInicial().setVisible(true);
            }
        });
    }
}
