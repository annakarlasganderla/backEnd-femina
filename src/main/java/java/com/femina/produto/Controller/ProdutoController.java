package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.ProdutoDao;
import java.com.femina.produto.Model.Produto;
import java.util.List;

public class ProdutoController {

    public ProdutoController(){
        this.criarTabelasProduto();
    }

    public void criarTabelasProduto(){
        ProdutoDao pd = new ProdutoDao();
        pd.criarTabelasProduto();
    }

    public void cadastrarProduto(Produto prod){
        ProdutoDao pd = new ProdutoDao();
        pd.cadastrarProduto(prod);
    }

    public List<Produto> listarProdutos(){
        ProdutoDao pd = new ProdutoDao();
        return pd.listarProdutos();
    }

    public Produto selectById(int idProduto){
        ProdutoDao pd = new ProdutoDao();
        return pd.selectById(idProduto);
    }

    public void editarProduto(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.editarProduto(produto);
    }

    public void deletarProduto(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.deletarProduto(produto);
    }

}
