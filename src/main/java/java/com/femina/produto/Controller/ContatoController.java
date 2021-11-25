<<<<<<< HEAD
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
=======
//package main.java.com.femina.produto.Controller;
//
//import main.java.com.femina.produto.View.ContatoView;
//import main.java.com.femina.produto.Dao.ContatoDao;
//import main.java.com.femina.produto.Model.Contatos;
//
//import java.io.IOException;
//import java.util.List;
//
//public class ContatoController {
//
//    public void cadastraContato (List<Contatos> contato,String arq) throws IOException {
//
//        ContatoDao contatoDao = new ContatoDao();
//        contatoDao.cadastraContato(contato, arq);
//    }
//
//    public List<Contatos> mostraContato(String arq) throws IOException {
//
//        ContatoDao contatoDao = new ContatoDao();
//        List<Contatos> listaContato = contatoDao.mostraContato(arq);
//        return listaContato;
//    }
//
//    public void editaContato(List<Contatos> contatos,String arq) throws IOException {
//
//        ContatoDao contatoDao = new ContatoDao();
//        contatoDao.editContatos(contatos,arq);
//    }
//
//    public void deletaContatos (List <Contatos> contatos,String arq) throws IOException {
//
//        ContatoDao contatoDao = new ContatoDao();
//        contatoDao.deletContatos(contatos,arq);
//
//    }
//
//}
>>>>>>> 2eef407d592c873b04e27a964b4054d98dbce436
