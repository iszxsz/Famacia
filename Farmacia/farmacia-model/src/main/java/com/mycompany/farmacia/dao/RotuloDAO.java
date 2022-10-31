package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.common.PersistenciaException;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Rotulo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RotuloDAO {
   
    public static List<Rotulo> rotulo;
    private static int chave;
   
    static {
        rotulo = new ArrayList<>();
        chave = 1;
    }
   
    private RotuloDAO(){}
    
    public static Rotulo aderirRotulo(String nome){
        Connection conn = EstoqueBD.conectar();
        Rotulo rotulo = consultarRotuloPorNome(nome);
        
        try {
            if (rotulo == null) {
                String consultar = "INSERT INTO rotulo (codigo, nome) VALUES ("+ maiorCodigo() +", '"+ nome +"')";
                ResultSet r = null;
                Statement stm = conn.createStatement();
                stm.executeQuery(consultar);
            }
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
            EstoqueBD.desconectar(conn);
        }
        
        return rotulo;
    }
    
    public static int maiorCodigo(){
        int aux = 1;
        Connection conn = EstoqueBD.conectar();
        
        try{
            String consultar = "SELECT * FROM `rotulo`";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                if(r.getInt("codigo") > aux)
                    aux = r.getInt("codigo") + 1;
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
        return aux;
    }
   
    public static Rotulo consultarRotuloPorNome(String nome){
        Connection conn = EstoqueBD.conectar();
        Rotulo aux = null;
        
        try{
            String consultar = "SELECT * FROM `rotulo` WHERE nome = '" + nome + "'";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                aux = new Rotulo(r.getInt("codigo"), r.getString("nome"));
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
        return aux;
    }
    
    public static Rotulo consultarRotuloPorCodigo(int cod){
        Connection conn = EstoqueBD.conectar();
        Rotulo aux = null;
        
        try{
            String consultar = "SELECT * FROM `rotulo` WHERE codigo = '" + cod + "'";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                aux = new Rotulo(r.getInt("codigo"), r.getString("nome"));
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
        return aux;
    }
   
    /*public static void cadastrar (Rotulo r) throws PersistenciaException{
        if(r.getNome().isEmpty())
            throw new PersistenciaException("Violação de campo único: nome");
        
        rotulo.add(r);
    }
   
    public static List<Rotulo> listarRotulo(){
        if(rotulo.isEmpty()!= true){
            return rotulo;
        }
       
        return null;
    }*/
   
}
