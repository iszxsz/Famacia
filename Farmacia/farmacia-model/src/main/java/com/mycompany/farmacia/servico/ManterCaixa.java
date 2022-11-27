package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.dao.CaixaDAO;
import com.mycompany.farmacia.dao.ProdutoDAO;
import com.mycompany.farmacia.dto.Produto;
import java.util.ArrayList;
import java.util.List;

public class ManterCaixa {
    //private static List<Produto> produtosVendidos = new ArrayList<>();
    
    public static double finalizarVenda(double valorRecebido) throws NegocioException{
        double total = CaixaDAO.getvTotal();
        if((valorRecebido - total) < 0)
            throw new NegocioException("Pagamento inclompleto!");
        if(valorRecebido < 0)
            throw new NegocioException("Não possivel inserir valores negativos!");
        
        return valorRecebido - total; //manda troco para interface
    }
    
    public static String adicionarAoCaixa(String info) throws NegocioException{
        if (info.isEmpty()) {
            throw new NegocioException("Preencha o campo de pesquisa!");
        } else {
            if (Generics.isInteger(info)) {
                ProdutoDAO.consultarPorCodigo(Integer.parseInt(info));
            } else {
                ProdutoDAO.consultarPorNome(info);
            }
        }
        
        List<Produto> p = ProdutoDAO.listarProdutos();
        
        if(p.isEmpty()){
            throw new NegocioException("Não foi possível encontrar o id ou nome correspondente");
        }else{
            return CaixaDAO.adicionarAoCaixa(p.get(0));
        }
    }
}
