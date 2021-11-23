package main.java.com.femina.produto.Controller;

import main.java.com.femina.produto.Dao.MarcaDao;
import main.java.com.femina.produto.Model.Cor;
import main.java.com.femina.produto.Dao.CorDao;
import main.java.com.femina.produto.Model.Marca;

import java.io.IOException;
import java.util.List;

public class CorController {

    public void cadastraCor(List<Cor> cor) {
        CorDao cd = new CorDao();
        cd.cadastraCor(cor);
    }
    public List<Cor> mostraCorCadastrada() throws IOException {
        CorDao corDao = new CorDao();
        List<Cor> listaCores = corDao.mostraCor();
        return listaCores;
    }

    public void editaCores(List<Cor> cor) {
        CorDao corDao = new CorDao();
        corDao.editaCores(cor);
    }

    public void apagaCores(List<Cor> cor) throws IOException {
        CorDao corDao = new CorDao();
        corDao.delCor(cor);
    }

    public List<Cor> listarCoresPeloId(Long idProd) throws IOException {
        CorDao corDao = new CorDao();
        return corDao.listarId(idProd);
    }
}

