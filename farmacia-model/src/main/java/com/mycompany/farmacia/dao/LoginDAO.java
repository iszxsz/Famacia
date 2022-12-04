package com.mycompany.farmacia.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest ;
import java.security.NoSuchAlgorithmException;
import com.mycompany.farmacia.bd.EstoqueBD;
import java.math.BigInteger;
import java.sql.*;

/**
 *
 * @author aluno
 */
public class LoginDAO {

    public static int verificarLogin(String nome, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Connection conn = EstoqueBD.conectar();
        int flag = 0;
        String senhaCripto = criptografarSenha(senha);
        String userG = "logGerente";
        String senhaG = "cefet123";

        try {
            String consultar = "SELECT * FROM `login`";
            ResultSet r = null;

            if (nome.equals(userG)) {
                if (senha.equals(senhaG)) {
                    System.out.println("3");
                    flag = 3; //Acessado pelo gerente
                } else {
                    System.out.println("1");
                    flag = 1; //senha errada porem usuario
                }
            } else {
                Statement stm = conn.createStatement();
                r = stm.executeQuery(consultar);
                while (r.next()) {
                    System.out.println("oi1");
                    if (nome.equals(r.getString("usuario"))) {
                        if (senhaCripto.equals(r.getString("senha"))) {
                            flag = 2; //usuario existe
                        } else {
                            flag = 1; // senha errada porem usuario existe
                        }
                    }
                }
            }

            r.close();
        } catch (SQLException ex) {
            System.out.println("NÃ£o conseguiu consultar um produto no BD.");
        } finally {
            EstoqueBD.desconectar(conn);
            return flag;
        }
    }

    public static boolean adicionarLogin(String usuario, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Connection conn = EstoqueBD.conectar();
        String senhaNova = criptografarSenha(senha);
        try {
            String adicionar = "INSERT INTO `login` (usuario, senha) VALUES ('" + usuario + "', '" + senhaNova + "')";

            Statement stm = conn.createStatement();
            stm.execute(adicionar);
            System.out.println("Adicionou no BD.");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode() + "\n \n" + ex.getSQLState() + "\n \n" + ex.getMessage());
            return false;
        } finally {
            EstoqueBD.desconectar(conn);
        }
    }

    

    public static String criptografarSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        String senhaCripto;
        md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes("UTF-8")));

        senhaCripto = hash.toString(16);
        return senhaCripto;
    }
}