package Controller;
import Dao.ContatoDao;
import Model.Contatos;

import java.util.List;

public class ContatoController {

    public void criaTabela(){

        ContatoDao contDao = new ContatoDao();
        contDao.criaTabela();

    }

    public void cadastraContato(Contatos cont){

        ContatoDao contDao = new ContatoDao();
        contDao.gravaNoBanco(cont);

    }

    public List<Contatos> mostraTabela(){

        ContatoDao contDao = new ContatoDao();
        return contDao.mostraLista();

    }

    public Contatos seleionaById(int id){

        ContatoDao contDao = new ContatoDao();
        return contDao.SelecionaId(id);
    }

    public void editarContato(Contatos contatos){
        ContatoDao contDao = new ContatoDao();
        contDao.editarContatoDoBanco(contatos);
    }

    public void deletaContato(Contatos contatos){
        ContatoDao contDao = new ContatoDao();
        contDao.removeContatoDoBanco(contatos);
    }


}