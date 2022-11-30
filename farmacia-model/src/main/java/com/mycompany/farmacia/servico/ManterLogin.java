/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.common.PersistenciaException;
import com.mycompany.farmacia.dao.LoginDAO;
//import com.mycompany.farmacia.view.TelaInicial;

/**
 *
 * @author aluno
 */
public class ManterLogin {

    public ManterLogin(){}

    public static boolean verificarLogin(String usuario, String senha) throws NegocioException {
        if (usuario.isEmpty() || senha.isEmpty()) {
            throw new NegocioException("Preencha todos os campos!");
        }
        int flag = LoginDAO.verificarLogin(usuario, senha);
        switch (flag) {
            case 0:
                throw new NegocioException("Usuario não cadastrado");
            case 1:
                throw new NegocioException("Senha incorreta");
            case 2:
                return false;
        }
        return true;
    }
    
    public static void adicionarLogin(String usuario, String senha) throws NegocioException, PersistenciaException  {
        if (usuario.isEmpty() || senha.isEmpty()) {
            throw new NegocioException("Preencha todos os campos!");
        }
        if (!LoginDAO.adicionarLogin(usuario, senha)){
            throw new PersistenciaException("Não foi possivel cadastrar o funcionario.");
        }
    }
    
}