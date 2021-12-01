package Controller;

import Dao.DestaquesDao;
import Model.Destaques;

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
