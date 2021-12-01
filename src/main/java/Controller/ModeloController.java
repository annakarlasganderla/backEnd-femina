package Controller;

import Model.ModelosDosProdutos;
import Model.Produto;

import Dao.ModeloDao;
import java.util.List;

public class ModeloController {

    public ModeloController() {
        this.criarTabela();
    }

    public void criarTabela(){
        ModeloDao modeloDao = new ModeloDao();
        modeloDao.criarTabelaModelo();
    }

    public void cadastrarModelo(ModelosDosProdutos modelo) {
        ModeloDao modeloDao = new ModeloDao();
        modeloDao.cadastrarModelo(modelo);
    }

    public List<ModelosDosProdutos> listarModelos(){
        ModeloDao modeloDao = new ModeloDao();
        return modeloDao.listarModelos();
    }

    public List<ModelosDosProdutos> listarModelosProdutos(Produto produto){
        ModeloDao modeloDao = new ModeloDao();
        return modeloDao.listarModelosProdutos(produto);
    }

    public ModelosDosProdutos selecionaModeloById(int id){
        ModeloDao modeloDao = new ModeloDao();
        return modeloDao.selecionaModeloById(id);
    }

    public void deletarModelo(ModelosDosProdutos modelo){
        ModeloDao modeloDao = new ModeloDao();
        modeloDao.deletarModelo(modelo);
    }

}
