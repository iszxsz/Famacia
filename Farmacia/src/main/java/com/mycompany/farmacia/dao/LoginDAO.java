/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.view.TelaInicial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class LoginDAO {
    public static void verificarLogin(String nome, String senha){
        Connection conn = EstoqueBD.conectar();
        
        try{
            String consultar = "SELECT * FROM `estoque` WHERE nome = '" + nome + "'";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                if(nome.equals(r.getString("usuario"))){
                    if(senha.equals(r.getString("senha"))){
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                            new TelaInicial().setVisible(true);
                        }
                        });
                    }
                    
            }}
            
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
    }
}
