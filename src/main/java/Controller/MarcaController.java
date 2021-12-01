package Controller;

import Dao.MarcaDao;
import Model.Marca;


import java.io.*;
import java.util.*;

public class MarcaController {


    public void criaTabela(){
        MarcaDao marcDao = new MarcaDao();
        marcDao.criaTabela();
    }

    public void cadastraMarca(Marca marc){
        MarcaDao marcDao = new MarcaDao();
        marcDao.gravaNoBanco(marc);
    }

    public List<Marca> mostraTabela(){
        MarcaDao marcDao = new MarcaDao();
        return marcDao.listaMarca();
    }

    public Marca seleionaById(int id){
        MarcaDao marcDao = new MarcaDao();
        return marcDao.SelecionaId(id);
    }

    public void deletaMarca(Marca marca){

        ContatoController cc = new ContatoController();
        cc.deletaContato(marca.getContatos());
        MarcaDao marcDao = new MarcaDao();
        marcDao.removeMarcaDoBanco(marca);

    }

}
