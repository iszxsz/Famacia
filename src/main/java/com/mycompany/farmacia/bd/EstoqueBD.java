package com.mycompany.farmacia.bd;

import java.sql.*;

public class EstoqueBD {

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://drogaspoint.cbl5egq4cigg.us-east-1.rds.amazonaws.com:3306/drogaspoint", "admin", "cefet123");
            System.out.println("Conectou no banco de dados.");
        } catch (SQLException ex) {
            System.out.println("Erro: Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
        }

        return conn;
    }

    public static void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Não conseguiu desconectar do BD.");
        }
    }
    
    /*public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmaciagrupo4", "root", "");
            System.out.println("Conectou no banco de dados.");
        } catch (SQLException ex) {
            System.out.println("Erro: Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: Não encontrou o driver do BD.");
        }

        return conn;
    }

    public static void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Não conseguiu desconectar do BD.");
        }
    }*/

}
