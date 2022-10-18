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
    private Connection con = null;
    
    
      public static Connection getConnection() throws ClassNotFoundException {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão: ", e);
        }

    }

    public static void closeConnection(Connection con) {
            try {
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if(stmt !=  null){
                stmt.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if(rs != null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
