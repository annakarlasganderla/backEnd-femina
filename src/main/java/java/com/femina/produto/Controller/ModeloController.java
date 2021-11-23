package main.java.com.femina.produto.Controller;

import main.java.com.femina.produto.Dao.CorDao;
import main.java.com.femina.produto.Dao.ModeloDao;
import main.java.com.femina.produto.Model.ModelosDosProdutos;

import java.io.*;
import java.util.List;

public class ModeloController {

    public void cadastraModelo(List<ModelosDosProdutos> modelo) throws IOException {
        ModeloDao modeloDao = new ModeloDao();
        modeloDao.cadastraModelo(modelo);
    }

    public List<ModelosDosProdutos> mostraModelos() throws IOException {
        ModeloDao modeloDao = new ModeloDao();
        List<ModelosDosProdutos> listaDeModelos = modeloDao.mostraModelo();
        return listaDeModelos;
    }

    public void editaModelo(List<ModelosDosProdutos> modelosDosProdutos) throws IOException {
        ModeloDao modeloDao = new ModeloDao();
        modeloDao.editaModelo(modelosDosProdutos);
    }

    public void deletaModelo(List<ModelosDosProdutos> modelosDosProdutos) throws IOException {
        ModeloDao modeloDao = new ModeloDao();
        modeloDao.deletaModelo(modelosDosProdutos);
    }

    public List<ModelosDosProdutos> listarModelosPeloIdProd(Long idProd) throws IOException {
        ModeloDao modeloDao = new ModeloDao();
        return modeloDao.listarId(idProd);
    }

}
