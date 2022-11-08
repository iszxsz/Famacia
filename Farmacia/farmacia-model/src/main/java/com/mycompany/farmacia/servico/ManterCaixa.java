package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.dao.CaixaDAO;
import com.mycompany.farmacia.dto.Produto;
import java.util.ArrayList;
import java.util.List;

public class ManterCaixa {
    private static List<Produto> produtosVendidos = new ArrayList<>();
    
    public static double finalizarVenda(double valorRecebido) throws NegocioException{
        double total = 0;
        for (Produto p : produtosVendidos) {
            CaixaDAO.venderProduto(p);
            total += p.getValor();
        }
        
        if((valorRecebido - total) < 0)
            throw new NegocioException("Pagamento inclompleto!");
        if(valorRecebido < 0)
            throw new NegocioException("Não possivel inserir valores negativos!");
        
        CaixaDAO.adicionarValoresCaixa(total);
        return valorRecebido - total; //manda troco para interface
    }

    public void selecionarProduto(Produto p) {
        produtosVendidos.add(p);
    }
}
