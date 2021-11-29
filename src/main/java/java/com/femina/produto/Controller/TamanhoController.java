package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.TamanhoDAO;
import main.java.com.femina.produto.Model.Tamanho;

import java.io.IOException;
import java.util.List;

public class TamanhoController {

    TamanhoDAO tamanhoDAO = new TamanhoDAO();

    public void cadastrarTamanho(Tamanho tamanho){

        tamanhoDAO.cadastrarTamanho(tamanho);

    }

    public List<Tamanho> listaTamanho(){

        return tamanhoDAO.listarTamanhos();

    }

    public Tamanho listarTamanhosPeloIdProd(int idProd) {

        return tamanhoDAO.listTamanhosId(idProd);

    }

    public void deletaTamanho(int idDelete) throws IOException {

        tamanhoDAO.deletaTamanho(idDelete);

    }

}