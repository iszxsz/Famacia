/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.farmacia.bancoDeDados;

import java.sql.*;

/**
 *
 * @author Aluno
 */
public class EstoqueBD {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://farmaciagrupo4:3306/estoque";
    private static final String USER = "drogaspoint";
    private static final String PASS = "cefet123";
    //private static Connection con = null;

    /*public static void main(String[] args) {
        EstoqueBD conexao = new EstoqueBD();
        Connection conn = conexao.conectar();
        //conexao.desconectar(conn);
    }*/

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/farmaciagrupo4", "drogaspoint", "cefet123");
            System.out.println("Conectou no banco de dados.");
        } catch (SQLException ex) {
            System.out.println("Erro: Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
        }

        return conn;
    }
    
    public void desconectar(Connection conn) {
        try {
          if(conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Desconectou do banco de dados.");
          }
        } catch (SQLException ex) {
          System.out.println("Não conseguiu desconectar do BD.");
        }
  }
    
    
    public static void main(String[] args) {
        EstoqueBD.conectar();
    }
    /**/

}
