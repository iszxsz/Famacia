package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bd.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CaixaDAO {

    public static void adicionarValoresCaixa(double valor) {
        Connection conn = EstoqueBD.conectar();
        
        try {
            String adicionar = "UPDATE caixa SET valor += "+ valor +" WHERE valor >= 0";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Alterou valor no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu alterar valor no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }

    public static void venderProduto(Produto p) {
        //pegar o produto no estoque e manda-lo para o relatorio
        RelatorioDAO.cadastrarProdutoRelatorio(p);
        ProdutoDAO.removerProdutoEstoque(p);
    }
}
