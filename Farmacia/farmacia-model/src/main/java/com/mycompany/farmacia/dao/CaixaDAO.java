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

    public static void adicionarValoresCaixa(double valor) {
        Connection conn = EstoqueBD.conectar();
        
        try {
            String adicionar = "UPDATE caixa SET valor += "+ valor +" WHERE valor >= 0";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Alterou valor no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu alterar valor no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
    
    private static String montarNota(){
        nota = "";
        vTotal = 0;
        for(Produto p: caixa){
            nota += p.getNome() + " " + p.getValor() + "\n";
            vTotal += p.getValor();
        }
        nota += "TOTAL: " + vTotal;
        
        return nota;
    }
    
    public static String adicionarAoCaixa(Produto p){
        caixa.add(p);
        
        return montarNota();
    }

    public static void venderProduto(Produto p) {
        RelatorioDAO.cadastrarProdutoRelatorio(p);
        ProdutoDAO.removerProdutoEstoque(p);
    }
    
    public static List<Produto> listarProdutos(){    
        return caixa;
    }
}
