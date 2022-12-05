package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bd.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Rotulo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private static List<Produto> produtos;
    
    static{
        produtos = new ArrayList<>();
    }
    
    private ProdutoDAO(){}
    
    public static void consultarBD(){
        Connection conn = EstoqueBD.conectar();
        produtos.clear();
        
        try{
            String consultar = "SELECT * FROM `estoque` ORDER BY codigo";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                produtos.add(new Produto(RotuloDAO.consultarRotuloPorCodigo(r.getInt("rotulo")), r.getInt("codigo"), r.getDouble("valor"), r.getBoolean("receita"), r.getString("nome"), r.getString("validade")));
            }
            
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
    }
    
    public static void consultarPorNome(String nome){
        Connection conn = EstoqueBD.conectar();
        produtos.clear();
        
        try{
            String consultar = "SELECT * FROM `estoque` WHERE nome = '" + nome + "'";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                produtos.add(new Produto(RotuloDAO.consultarRotuloPorCodigo(r.getInt("rotulo")), r.getInt("codigo"), r.getDouble("valor"), r.getBoolean("receita"), r.getString("nome"), r.getString("validade")));
            }
            
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
    }
    
    public static void consultarPorCodigo(int codigo){
        Connection conn = EstoqueBD.conectar();
        produtos.clear();
        
        try{
            String consultar = "SELECT * FROM `estoque` WHERE codigo = '" + codigo + "'";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                produtos.add(new Produto(RotuloDAO.consultarRotuloPorCodigo(r.getInt("rotulo")), r.getInt("codigo"), r.getDouble("valor"), r.getBoolean("receita"), r.getString("nome"), r.getString("validade")));
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
    }
    
    public static void cadastrarProdutoEstoque(Rotulo rotulo, int codigo, double valor, boolean receita, String nome, String validade){
        Produto p;
        p = new Produto(rotulo, codigo, valor, receita, nome, validade);
        Connection conn = EstoqueBD.conectar();
        try {
            String adicionar = "INSERT INTO `estoque` (rotulo, codigo, valor, receita, nome, validade) VALUES ('" + rotulo.getCodigo() + "', " + p.getCodigo() + ", " + p.getValor() +", " + p.getReceita() +", '" + p.getNome() +"', '" + p.getValidade() + "')";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
    
    public static void removerProdutoEstoque(Produto p){
        Connection conn = EstoqueBD.conectar();
        try {
            String adicionar = "DELETE FROM estoque WHERE codigo = " + p.getCodigo();

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Removeu do BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu remover um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
    
    public static int aderirCodigo(){
        int maior = 0;
        Connection conn = EstoqueBD.conectar();
        try{
            String consultar = "SELECT * FROM `estoque`";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                if(r.getInt("codigo") > maior)
                    maior = r.getInt("codigo");
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
           return maior + 1;
        }
    }
    
    public static List<Produto> listarProdutos(){    
        return produtos;
        //lista
    }
}
