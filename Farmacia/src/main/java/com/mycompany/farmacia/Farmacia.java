package com.mycompany.farmacia;

//import com.mycompany.farmacia.view.TelaInicial;

import static com.mycompany.farmacia.dao.ProdutoDAO.consultarPorNome;
import static com.mycompany.farmacia.dao.RelatorioDAO.cadastrarProdutoRelatorio;


public class Farmacia {

    public static void main(String[] args) {
        
        cadastrarProdutoRelatorio(consultarPorNome("Paracetamol"));
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });*/
    }
}
