/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.common.NegocioException;
import com.mycompany.farmacia.dao.LoginDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ManterLogin {
    
    public ManterLogin(){}
    
    public static void verificarLogin(String usuario, String senha){
        if(usuario.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        else{
            LoginDAO.verificarLogin(usuario, senha);
        }
            
        
    }
}
