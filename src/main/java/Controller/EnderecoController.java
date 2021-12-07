package Controller;

import Dao.EnderecoDao;
import Model.Endereco;

import java.util.List;

public class EnderecoController {

    EnderecoDao enderecoDao = new EnderecoDao();

    public void criaTabelaEndereco() {
        enderecoDao.criaTabelaEndereco();
    }

    public void cadastraEndereco(Endereco endereco) {
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