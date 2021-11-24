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

    public List<Endereco> listarEndereco() {
        return enderecoDao.listarEnderecos();
    }

    public Endereco selectById(int id) {
        return enderecoDao.selectEnderecoById(id);
    }

    public void editarEndereco(Endereco endereco) {
        enderecoDao.editarEndereco(endereco);
    }

    public void deletarEndereco(Endereco endereco) {
        enderecoDao.deletaEndereco(endereco);
    }


}