package main.java.com.femina.produto.Controller;
import main.java.com.femina.produto.Dao.ContatoDao;
import main.java.com.femina.produto.Dao.EnderecoDao;
import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;

import java.io.IOException;
import java.util.List;

public class EnderecoController {

    public void cadastraEndereco(List<Endereco> listEndereco,String arq) throws IOException {

        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.cadastraEndereco(listEndereco,arq);

    }

    public List<Endereco> mostraEndereco(String arq) throws IOException {

        EnderecoDao contatoDao = new EnderecoDao();
        List<Endereco> listaEndereco = contatoDao.mostraEndereco(arq);
        return listaEndereco;
    }

    public void editaEndereco(List<Endereco> endereco,String arq) throws IOException {

        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.editEndereco(endereco,arq);
    }

    public void deletaEndereco(List<Endereco> endereco,String arq) throws IOException {

        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.delEndereco(endereco,arq);
    }

}