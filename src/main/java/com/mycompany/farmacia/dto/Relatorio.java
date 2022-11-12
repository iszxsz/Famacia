package com.mycompany.farmacia.dto;
import com.mycompany.farmacia.dto.Produto;
import java.util.List;
import java.util.ArrayList;

public class Relatorio {
    private List<Produto> produtos = new ArrayList<>();
    private List<String> dataVenda = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public List<String> getDatas(){
        return dataVenda;
    }
}
