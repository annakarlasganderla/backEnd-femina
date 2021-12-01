package Controller;
import Dao.CategoriaDao;
import Model.Categoria;

import java.util.List;

public class CategoriaController {

    CategoriaDao categoriaDao = new CategoriaDao();

    public void criaTabelaCategoria() {
        categoriaDao.criaTabelaCategoria();
    }

    public void cadastraCategoria(Categoria categoria) {
        categoriaDao.cadastraCategoria(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaDao.listarCategorias();
    }

    public Categoria selectById(int id) {
        return categoriaDao.selectById(id);
    }

    public void deletarCategoria(Categoria categoria) {
        categoriaDao.deletarCategoria(categoria);
    }

}
