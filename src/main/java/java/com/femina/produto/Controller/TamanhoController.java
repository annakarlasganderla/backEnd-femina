package main.java.com.femina.produto.Controller;

import main.java.com.femina.produto.Dao.TamanhoDAO;
import main.java.com.femina.produto.Model.Tamanho;

import java.io.IOException;
import java.util.List;

public class TamanhoController {

    TamanhoDAO tamanhoDAO = new TamanhoDAO();

    public void cadastrarTamanho(List<Tamanho> tamanhos){

        tamanhoDAO.cadastrarTamanho(tamanhos);

    }

    public List<Tamanho> listaTamanho(){

       return tamanhoDAO.listarTamanhos();

    }

    public List<Tamanho> listarTamanhosPeloIdProd(int idProd) {

        return tamanhoDAO.listTamanhosId(idProd);

    }

    public void deletaTamanho(List<Tamanho> listTamanho) throws IOException {

        tamanhoDAO.deletaTamanho(listTamanho);

    }

}
