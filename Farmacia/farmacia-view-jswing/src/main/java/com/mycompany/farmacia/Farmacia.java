package com.mycompany.farmacia;

import com.mycompany.farmacia.view.TelaInicial;
import com.mycompany.farmacia.dao.ProdutoDAO;
import com.mycompany.farmacia.dao.RelatorioDAO;
import com.mycompany.farmacia.view.TelaLogin;


public class Farmacia {

    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLogin dialog = new TelaLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
       }
    }
