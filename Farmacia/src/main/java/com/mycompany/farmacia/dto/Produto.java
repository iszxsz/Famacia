package com.mycompany.farmacia.dto;
import com.mycompany.farmacia.dto.Rotulo;

public class Produto {
    
    private Rotulo rotulo;
    private int codigo;
    private double valor;
    private boolean receita;
    private String nome;
    private String validade;
    
    //Passa os valores nescessario para criar produto
    public void Produto(Rotulo rotulo, int codigo, double valor, boolean receita, String nome, String validade){
        this.rotulo = rotulo;
        this.codigo = codigo;
        this.valor = valor;
        this.nome = nome;
        this.receita = receita;
        this.validade = validade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getRotulo() {
        return receita;
    }

    public void setReceita(boolean receita) {
        this.receita = receita;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
