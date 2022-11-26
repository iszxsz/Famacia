package com.mycompany.farmacia.dto;
import com.mycompany.farmacia.dto.Produto;
import java.util.List;
import java.util.ArrayList;

public class Relatorio {
    int rotulo;
    int codigo;
    double valor;
    String venda;
    String nome;
    String validade;

    public Relatorio(int rotulo, int codigo, double valor, String venda, String nome, String validade) {
        this.rotulo = rotulo;
        this.codigo = codigo;
        this.valor = valor;
        this.venda = venda;
        this.nome = nome;
        this.validade = validade;
    }

    public int getRotulo() {
        return rotulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public String getVenda() {
        return venda;
    }

    public String getNome() {
        return nome;
    }

    public String getValidade() {
        return validade;
    }
}
