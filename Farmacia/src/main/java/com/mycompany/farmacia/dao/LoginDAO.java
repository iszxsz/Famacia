/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.bancoDeDados.EstoqueBD;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class LoginDAO {
    public static void verificarLogin(String usuario, String senha){
        Connection conn = EstoqueBD.conectar();
        
        try{
            String consultar = "SELECT * FROM `login` WHERE usuario = '" + usuario + "'";
            ResultSet r = null;
    }
}
