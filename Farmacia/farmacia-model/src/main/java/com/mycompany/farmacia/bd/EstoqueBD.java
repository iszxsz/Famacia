package com.mycompany.farmacia.bd;

import java.sql.*;


public class EstoqueBD {
private static final String DRIVER = "com.mysql.jdbc.Driver";
private static final String URL = "jdbc:mysql://drogaspoint.cbl5egq4cigg.us-east-1.rds.amazonaws.com:3306/drogaspoint";
private static final String USUARIO = "admin";
private static final String SENHA = "cefet123";

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
    public static Connection conectarBD() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        
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
