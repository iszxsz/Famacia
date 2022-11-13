package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.Generics;
import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.dao.ProdutoDAO;
import com.mycompany.farmacia.dao.RotuloDAO;

public class ManterProduto {
    public static void adicionarProduto(String nomeRotulo, double valor, boolean receita, String nome, String validade) throws NegocioException{
        if((nomeRotulo.isEmpty()) || (valor == 0) || (validade.isEmpty()) || (nome.isEmpty())){
            throw new NegocioException("Preencha todos os campos!");
        } else{
            ProdutoDAO.cadastrarProdutoEstoque(RotuloDAO.aderirRotulo(nomeRotulo), ProdutoDAO.aderirCodigo(), valor, receita, nome, validade);
        }
    }
    
    public static void consultarProduto(String info) throws NegocioException{
        if (info.isEmpty()) {
            throw new NegocioException("Preencha o campo de pesquisa!");
        } else {
            if (Generics.isInteger(info)) {
                ProdutoDAO.consultarPorCodigo(Integer.parseInt(info));
            } else {
                ProdutoDAO.consultarPorNome(info);
            }
        }
    }
}
