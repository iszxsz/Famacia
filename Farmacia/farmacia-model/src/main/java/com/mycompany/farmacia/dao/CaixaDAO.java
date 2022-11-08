package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.dto.Produto;

public class CaixaDAO {

    public static void adicionarValoresCaixa(double valor) {

        //chama o valor armazenado no bd; soma o novo valor como valor anterior com o valor antigo e substitui no bd
        //adiciona data da venda junto com o produto vendido 
    }

    public static void venderProduto(Produto p) {
        //pegar o produto no estoque e manda-lo para o relatorio
        RelatorioDAO.cadastrarProdutoRelatorio(p);

        adicionarValoresCaixa(p.getValor());
    }
}
