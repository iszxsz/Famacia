package com.mycompany.farmacia;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mostrarBD {
    public static void main(String[] args) {
        Connection conn = EstoqueBD.conectar();
        
        try{
            String consultar = "SELECT * FROM `estoque`";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                System.out.println(r.getString("nome"));
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
}
