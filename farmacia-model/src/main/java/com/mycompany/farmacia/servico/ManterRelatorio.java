package com.mycompany.farmacia.servico;

import com.mycompany.farmacia.dao.RelatorioDAO;
import com.mycompany.farmacia.dto.Relatorio;
import java.util.List;

public class ManterRelatorio {
    public static List<Relatorio> montarRelatorio(){
        return RelatorioDAO.consultarBD();
    }
}
