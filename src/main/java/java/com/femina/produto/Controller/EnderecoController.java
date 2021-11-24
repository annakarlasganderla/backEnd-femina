package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.EnderecoDao;
import java.com.femina.produto.Model.Endereco;
import java.io.IOException;
import java.util.List;

public class EnderecoController {

    EnderecoDao enderecoDao = new EnderecoDao();

    public void criaTabelaEndereco(Endereco endereco) {
        enderecoDao.criaTabelaEndereco(endereco);
    }

    public void cadastraProduto(Endereco endereco) {
        enderecoDao.cadastraEndereco(endereco);
    }




}