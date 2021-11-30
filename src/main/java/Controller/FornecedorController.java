package Controller;

import Dao.FornecedorDao;
import Model.Fornecedor;

import java.util.List;

public class FornecedorController {

    FornecedorDao fornecedorDao = new FornecedorDao();

    public void criarTabela() {
        fornecedorDao.criarTabelaFornecedores();
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        fornecedorDao.cadastrarFornecedor(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorDao.listarFornecedores();
    }

    public Fornecedor selectFornecedorById(int idFornecedor) {
        return fornecedorDao.selectFornecedorById(idFornecedor);
    }

    public void editarFornecedor(Fornecedor fornecedor) {
        fornecedorDao.editarFornecedor(fornecedor);
    }

    public void deletarFornecedor(Fornecedor fornecedor) {
        fornecedorDao.deletarFornecedor(fornecedor);

        EnderecoController enderecoController = new EnderecoController();
        enderecoController.deletarEndereco(fornecedor.getEnderecoFornecedor());

        ContatoController contatoController = new ContatoController();
        contatoController.deletaContato(fornecedor.getContatoFornecedor());
    }
}
