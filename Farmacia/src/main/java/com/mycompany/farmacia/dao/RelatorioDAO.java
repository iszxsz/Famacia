package com.mycompany.farmacia.dao;

import java.util.Date;
import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Rotulo;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RelatorioDAO {
    public static void cadastrarProdutoRelatorio(Produto p){
        Connection conn = EstoqueBD.conectar();
        Date data = new Date();
        
        try {
            String adicionar = "INSERT INTO relatorio (rotulo, codigo, valor, venda, nome, validade) VALUES ('" + p.getRotulo().getCodigo() + "', " + p.getCodigo() + ", " + p.getValor() +", " + data.toString() +", '" + p.getNome() +"', '" + p.getValidade() + "')";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
}
