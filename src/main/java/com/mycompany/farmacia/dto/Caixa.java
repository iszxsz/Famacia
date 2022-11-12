package com.mycompany.farmacia.dto;

public class Caixa {
    double valorCaixa;
    int[] n = new int[8]; //Numero de notas no caixa
    //n2, n5, n10, n20, n50, n100, n200;
    int[] m = new int[6]; //Numero de moedas no caixa
    //m5, m10, m25, m50, m100;

    public void setValorCaixa(Double valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

    public Double getValorCaixa() {
        return valorCaixa;
    }
    
    public void setN(int n, int i){ //primeiro parametro: numero de notas; segundo parametro: qual nota esta sendo setada
        this.n[i] = n;
    }
    
    public void setM(int m, int i){ //primeiro parametro: numero de moedas; segundo parametro: qual moeda esta sendo setada
        this.m[i] = m;
    }
    
    public int[] getN(){
        return n;
    }
    
    public int[] getM(){
        return m;
    }
}
