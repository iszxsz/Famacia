/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.dao.LoginDAO;
//import com.mycompany.farmacia.view.TelaInicial;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ManterLogin {

    public ManterLogin() {
    }

    public static boolean verificarLogin(String usuario, String senha) throws NegocioException {
        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            int flag = LoginDAO.verificarLogin(usuario, senha);
            switch (flag) {
                case 0:
                    throw new NegocioException(1, "Usuario não cadastrado");
                case 1:
                    throw new NegocioException(2, "Senha incorreta");
                case 2:
                    return false;
            }

        }
        
        return true;

    }
    
    public static boolean adicionarLogin(String usuario, String senha) {
        boolean retorno;
        retorno = LoginDAO.adicionarLogin(usuario, senha);
        return retorno;
        //false se nao for possivel
        //true se conseguiu cadastrar
    }
    
}