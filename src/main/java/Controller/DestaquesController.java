package Controller;

import Dao.DestaquesDao;
import Model.Destaques;
import Model.Lojas;

import java.util.List;

public class DestaquesController {

    public void criaTabelaDestaque(){
        DestaquesDao dd = new DestaquesDao();
        dd.criarTabelasDetaques();
    }

    public void cadastraDestaque(Destaques destaques)  {
        DestaquesDao dd = new DestaquesDao();
        dd.cadastraDestaque(destaques);
    }

    public List<Destaques> ListarDestaques(Lojas lojas){
        DestaquesDao dd = new DestaquesDao();
        return dd.listarDestaques(lojas);
    }

}