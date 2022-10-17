package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Rotulo;
import com.mycompany.farmacia.dao.RotuloDAO;
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
    }
    
    public static List<Produto> listarProdutos(){
        return produtos;
    }
}
