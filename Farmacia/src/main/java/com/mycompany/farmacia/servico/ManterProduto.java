package com.mycompany.farmacia.servico;

/*import com.mycompany.farmacia.common.PersistenciaException;
import com.mycompany.farmacia.dao.ProdutoDAO;
import com.mycompany.farmacia.dto.Rotulo;
import com.mycompany.farmacia.dto.Produto;
import com.mycompany.farmacia.dao.RotuloDAO;
import java.util.List;*/

public class ManterProduto {
    /*public static void adicionarProduto(String nomeRotulo, double valor, boolean receita, String nome, String validade) throws PersistenciaException{
        List<Rotulo> rotulos = RotuloDAO.listarRotulo();
        List<Produto> produtos = ProdutoDAO.listarProdutos();
        Rotulo r = RotuloDAO.aderirRotulo(nomeRotulo);
        int codigo = 1;
        
        if (r == null) {
            r = new Rotulo(0, nomeRotulo);

            for (Rotulo rt : rotulos) {
                if (r.getCodigo() <= rt.getCodigo()) {
                    r.setCodigo(rt.getCodigo() + 1);
                }
            }

            RotuloDAO.cadastrar(r);
        }
        
        for(Produto pd: produtos)
            if(codigo <= pd.getCodigo())
                codigo = pd.getCodigo() + 1;
                    
        if(valor != 0){
            if(!nome.isEmpty()){
                if(!validade.isEmpty()){
                } else{
                    throw new PersistenciaException("Campo validade obrigatório");
                }
            } else{
                throw new PersistenciaException("Campo nome obrigatório");
            }
        } else{
            throw new PersistenciaException("Campo valor obrigatório");
        }
    }*/
}
