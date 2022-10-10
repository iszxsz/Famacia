

package com.mycompany.farmacia.dto;

public class Produto {
    private String codigo;
    private String nome;
    private String rotulo;
    private String validade;
    private String valor;
    
    public void Produto(){ //ainda pensar sobre
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getRotulo() {
        return rotulo;
    }
    
    public String getValidade() {
        return validade;
    }
    
    public String getValor() {
        return valor;
    }
}
