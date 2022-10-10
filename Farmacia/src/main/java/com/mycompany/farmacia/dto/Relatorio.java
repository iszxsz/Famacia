package com.mycompany.farmacia.dto;
import com.mycompany.farmacia.dto.Produto;
import java.util.List;
import java.util.ArrayList;

public class Relatorio {
    List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }
}
