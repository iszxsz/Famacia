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
   
    public static void cadastrar (Rotulo r) throws PersistenciaException{
        if(r.getNome().isEmpty())
            throw new PersistenciaException("Violação de campo único: nome");
        
        rotulo.add(r);
    }
   
    public static List<Rotulo> listarRotulo(){
        if(rotulo.isEmpty()!= true){
            return rotulo;
        }
       
        return null;
    }
   
}
