package com.mycompany.farmacia.dao;

import com.mycompany.farmacia.common.PersistenciaException;
import com.mycompany.farmacia.dto.Rotulo;
import java.util.ArrayList;
import java.util.List;

public class RotuloDAO {
   
    public static List<Rotulo> rotulo;
    private static int chave;
   
    static {
        rotulo = new ArrayList<>();
        chave = 1;
    }
   
    private RotuloDAO(){}
   
    public static Rotulo consultarPorNome (String nome){
       
        for (Rotulo r: rotulo){
            if(r.getNome().equals(nome)){
                return r;
            }
        }
       
        return null;
    }
   
    public static Rotulo cadastrar (String nome) throws PersistenciaException{
       
        if (consultarPorNome(nome) == null){
            Rotulo r = new Rotulo(chave, nome);
            rotulo.add(r);
            chave++;
            return r;
        }
     
        throw new PersistenciaException("Violação de campo único: nome");
    }
   
    public static List<Rotulo> listarRotulo(){
        if(rotulo.isEmpty()!= true){
            return rotulo;
        }
       
        return null;
    }
   
}
