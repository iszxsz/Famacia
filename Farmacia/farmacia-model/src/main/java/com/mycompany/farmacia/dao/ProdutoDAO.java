package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
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
    
    public static Produto[] consultarPorNome(String nome){
        Connection conn = EstoqueBD.conectar();
        
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
        
        return null;
    }
    
    public static Produto consultarPorCodigo(int codigo){
        Connection conn = EstoqueBD.conectar();
        
        try{
            String consultar = "SELECT * FROM `estoque` WHERE codigo = '" + codigo + "'";
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
        
        return null;
    }
    
    public static void cadastrarProdutoEstoque(Rotulo rotulo, int codigo, double valor, boolean receita, String nome, String validade){
        Produto p;
        p = new Produto(rotulo, codigo, valor, receita, nome, validade);
        Connection conn = EstoqueBD.conectar();
        try {
            String adicionar = "INSERT INTO estoque (rotulo, codigo, valor, receita, nome, validade) VALUES ('" + p.getRotulo().getCodigo() + "', " + p.getCodigo() + ", " + p.getValor() +", " + p.getReceita() +", '" + p.getNome() +"', '" + p.getValidade() + "')";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
    
    public static List<Produto> listarProdutos(){
        return produtos;
    }
}