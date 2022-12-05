package com.mycompany.farmacia.dao;

import java.util.Date;
import com.mycompany.farmacia.bd.EstoqueBD;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dto.Relatorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static javax.print.attribute.Size2DSyntax.MM;

public class RelatorioDAO {
    private static List<Relatorio> relatorio;
    
    static{
        relatorio = new ArrayList<>();
    }
    
    public static void cadastrarProdutoRelatorio(Produto p){
        Connection conn = EstoqueBD.conectar();
        Date data = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.format(data);
        
        try {
            String adicionar = "INSERT INTO `relatorio` (rotulo, codigo, valor, venda, nome, validade) VALUES (" + p.getRotulo().getCodigo() + ", " + p.getCodigo() + ", " + p.getValor() +", '" + data.toString() +"', '" + p.getNome() +"', '" + p.getValidade() + "')";
            
            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar um produto no BD.");
            System.out.println(ex.getErrorCode() + "\n \n" + ex.getSQLState() + "\n \n" + ex.getMessage());
        } finally {
           EstoqueBD.desconectar(conn);
        }
    }
    
    public static List<Relatorio> consultarBD(){
        relatorio.clear();
        Connection conn = EstoqueBD.conectar();
        
        try{
            String consultar = "SELECT * FROM `relatorio` ORDER BY codigo";
            ResultSet r = null;
            
            Statement stm = conn.createStatement();
            r = stm.executeQuery(consultar);
            while(r.next()){
                relatorio.add(new Relatorio(r.getInt("rotulo"), r.getInt("codigo"), r.getDouble("valor"), r.getString("venda"), r.getString("nome"), r.getString("validade")));
            }
            r.close();
        } catch (SQLException ex) {
            System.out.println("Não conseguiu consultar um produto no BD.");
        } finally {
           EstoqueBD.desconectar(conn);
        }
        
        return relatorio;
    }
}
