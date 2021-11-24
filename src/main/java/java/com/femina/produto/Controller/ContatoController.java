package java.com.femina.produto.Controller;

import main.java.com.femina.produto.View.ContatoView;
import main.java.com.femina.produto.Dao.ContatoDao;
import main.java.com.femina.produto.Model.Contatos;

import java.com.femina.produto.Model.Contatos;
import java.io.IOException;
import java.util.List;

public class ContatoController {

    public void cadastraContato (List<Contatos> contato, String arq) throws IOException {

        ContatoDao contatoDao = new ContatoDao();
        contatoDao.cadastraContato(contato, arq);
    }

    public List<Contatos> mostraContato(String arq) throws IOException {

        ContatoDao contatoDao = new ContatoDao();
        List<Contatos> listaContato = contatoDao.mostraContato(arq);
        return listaContato;
    }

    public void editaContato(List<Contatos> contatos,String arq) throws IOException {

        ContatoDao contatoDao = new ContatoDao();
        contatoDao.editContatos(contatos,arq);
    }

    public void deletaContatos (List <Contatos> contatos,String arq) throws IOException {

        ContatoDao contatoDao = new ContatoDao();
        contatoDao.deletContatos(contatos,arq);

    }

}