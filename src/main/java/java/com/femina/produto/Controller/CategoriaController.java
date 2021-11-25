package java.com.femina.produto.Controller;
import java.com.femina.produto.Dao.CategoriaDao;
import java.com.femina.produto.Model.Categoria;
import java.util.List;

public class CategoriaController {

    CategoriaDao categoriaDao = new CategoriaDao();

    public void criaTabelaCategoria(Categoria categoria) {
        categoriaDao.criaTabelaCategoria(categoria);
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
