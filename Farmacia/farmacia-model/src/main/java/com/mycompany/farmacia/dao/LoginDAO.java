/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class LoginDAO {

    public static int verificarLogin(String nome, String senha) {
        Connection conn = EstoqueBD.conectar();

        try {
            String consultar = "SELECT * FROM `login`";
            ResultSet r = null;

            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while (r.next()) {
                System.out.println("oi1");
                if (nome.equals(r.getString("usuario"))) {
                    if (senha.equals(r.getString("senha"))) {
                       return 2; //usuario existe
                    } else 
                        return 1; // senha errada porem usuario existe
                } else if((nome.equals(r.getString("usuario"))) && (r.getString("tipo").equals("gerente"))){
                    if (senha.equals(r.getString("senha"))) {
                       return 3; //Acessado pelo gerente
                    } else 
                        return 1; //senha errada porem usuario
                }
            }

            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
            EstoqueBD.desconectar(conn);
        }
        
        return 0;
    }
    
    public static boolean adicionarLogin(String usuario, String senha){
        Connection conn = EstoqueBD.conectar();
        try {
            String adicionar = "INSERT INTO login (usuario, senha) VALUES ('" + usuario + "', " + senha + "')";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar o login no BD.");
            return false;
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
}
