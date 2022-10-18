package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Rotulo;
import java.sql.Connection;
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
    
    public static Produto consultarPorNome(String nome){
        for(Produto p: produtos)
            if(nome.equals(p.getNome()))
                return p;
        
        return null;
    }
    
    public static Produto consultarPorCodigo(int codigo){
        for(Produto p: produtos)
            if(p.getCodigo() == codigo)
                return p;
        
        return null;
    }
    
    public static void cadastrarProduto(Rotulo rotulo, int codigo, double valor, boolean receita, String nome, String validade){
        Produto p;
        p = new Produto(rotulo, codigo, valor, receita, nome, validade);
        produtos.add(p);
        Connection conn = EstoqueBD.conectar();
        try {
            String adicionar = "INSERT INTO estoque (rotulo, codigo, valor, receita, nome, validade) VALUES ('" + p.getRotulo() + "', " + p.getCodigo() + ", " + p.getValor() +", " + p.getReceita() +", '" + p.getNome() +"', '" + p.getValidade() + "')";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar uma pessoa no BD.");
        } finally {
           // EstoqueBD.desconectar(conn);
        }
    }
    
    
    public static List<Produto> listarProdutos(){
        return produtos;
    }
}
