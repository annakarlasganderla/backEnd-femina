package Controller;

import Dao.LojasDAO;
import Model.Lojas;

import java.util.List;

public class LojasController {

    LojasDAO lojasDAO = new LojasDAO();

    public void cadastrarLojas(Lojas loja){
        lojasDAO.cadastrarLojas(loja);
    }

    public List<Lojas> listarTodasAsLojas(){
        return lojasDAO.listarTodasAsLojas();
    }

    public void cadastrarProdutosNaLOja(Lojas loja){
        lojasDAO.cadastrarProdutosNaLOja(loja);
    }

    public void cadastrarFuncionariosNaLOja(Lojas loja){
        lojasDAO.cadastrarFuncionariosNaLOja(loja);
    }

    public void deleteLoja(int idLoja){
        lojasDAO.deleteLoja(idLoja);
    }

    public void editarLojas(Lojas loja, int idSelect){
        lojasDAO.editarNomeLoja(loja, idSelect);
    }

}
