package Controller;

import Dao.TamanhoDAO;
import Model.Tamanho;

import java.io.IOException;
import java.util.List;

public class TamanhoController {

    public TamanhoController(){
        this.criarTabelaTamanho();
    }

    TamanhoDAO tamanhoDAO = new TamanhoDAO();

    public void criarTabelaTamanho(){
        tamanhoDAO.creatTable();
    }

    public void cadastrarTamanho(Tamanho tamanho){

        tamanhoDAO.cadastrarTamanho(tamanho);

    }

    public List<Tamanho> listarTamanho(){

        return tamanhoDAO.listarTamanhos();

    }

    public Tamanho listarTamanhosPeloIdProd(int idProd) {

        return tamanhoDAO.listTamanhosId(idProd);

    }

    public void deletaTamanho(Tamanho idDelete) throws IOException {

        tamanhoDAO.deletaTamanho(idDelete);

    }

}