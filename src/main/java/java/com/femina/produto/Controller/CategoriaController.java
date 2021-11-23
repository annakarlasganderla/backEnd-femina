package main.java.com.femina.produto.Controller;
import main.java.com.femina.produto.Dao.CategoriasDao;
import main.java.com.femina.produto.Model.Categoria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    List<Categoria> categorias = new ArrayList<>();
    CategoriasDao categoriasDao = new CategoriasDao();

    public void cadastrarCategoria(Categoria categoria) throws IOException {
        categorias.add(categoria);
        categoriasDao.cadastrarCategoria(categorias);
    }


    public List<Categoria> mostrarListaDeCategoria() throws IOException {
        categoriasDao.mostrarListaDeCategoria();
        return categorias;
    }

    public void editaDeletaCategoria(List<Categoria> produtoDescontos) throws IOException {
        categoriasDao.editaDeletaCategorias(categorias);
    }

    public void removeCategoria(List<Categoria> categorias) throws IOException {
        categoriasDao.editaDeletaCategorias(categorias);
    }


}
