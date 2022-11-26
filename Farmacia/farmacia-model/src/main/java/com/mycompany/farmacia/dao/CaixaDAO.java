package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bd.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAO {
    private static List<Produto> caixa;
    private static String nota;
    private static double vTotal;
    static{
        caixa = new ArrayList<>();
        nota = "";
        vTotal = 0;
    }
    
    private static String montarNota(){
        nota = "";
        vTotal = 0;
        for(Produto p: caixa){
            nota += p.getNome() + " " + p.getValor() + "\n";
            vTotal += p.getValor();
        }
        nota += "\nTOTAL: " + vTotal;
        
        return nota;
    }
    
    public static String adicionarAoCaixa(Produto p){
        caixa.add(p);
        
        return montarNota();
    }

    public static double getvTotal() {
        return vTotal;
    }

    private static void venderProduto(Produto p) {
        RelatorioDAO.cadastrarProdutoRelatorio(p);
        ProdutoDAO.removerProdutoEstoque(p);
    }
    
    public static List<Produto> listarProdutos(){    
        return caixa;
    }
    
    public static void finalizarVenda(){
        for(Produto p: caixa){
            venderProduto(p);
        }
    }
}
