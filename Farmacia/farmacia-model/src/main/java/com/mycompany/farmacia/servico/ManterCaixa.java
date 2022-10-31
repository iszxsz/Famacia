package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.dao.CaixaDAO;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Rotulo;
import java.util.ArrayList;
import java.util.List;

public class ManterCaixa {
    private static List<Produto> produtosVendidos = new ArrayList<>();
    
    public static double finalizarVenda(double valorRecebido){
        double total=0;
    for(Produto p: produtosVendidos){
        CaixaDAO.venderProduto(p);
        total += p.getValor();
    }
    CaixaDAO.adicionarValoresCaixa(total);
    return valorRecebido-total; //mandar para a interface
    }
    
    public void selecionarProduto(Produto p){
        produtosVendidos.add(p);
    }
}
