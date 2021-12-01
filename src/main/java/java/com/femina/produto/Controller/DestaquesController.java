package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.DestaquesDao;
import java.com.femina.produto.Model.Destaques;

public class DestaquesController {

    public void criaTabelaDestaque(){
        DestaquesDao dd = new DestaquesDao();
        dd.criarTabelasDetaques();
    }

    public void cadastraDestaque(Destaques destaques)  {
        DestaquesDao dd = new DestaquesDao();
        dd.cadastraDestaque(destaques);
    }

}
