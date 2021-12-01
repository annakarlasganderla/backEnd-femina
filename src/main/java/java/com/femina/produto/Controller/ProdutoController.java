package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.ProdutoDao;
import java.com.femina.produto.Model.Cor;
import java.com.femina.produto.Model.ModelosDosProdutos;
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

    public ProdutosAux listarProdutos(int idLoja){
        ProdutoDao pd = new ProdutoDao();
        return pd.listarProdutos(idloja);
    }

    public Produto selectById(int idProduto){
        ProdutoDao pd = new ProdutoDao();
        return pd.selectById(idProduto);
    }

    public void editarProduto(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.editarProduto(produto);
    }

    public void updateModelo(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.updateModelo(produto);
    }

    public void updateCor(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.updateCor(produto);
    }

    public void deletarProduto(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.deletarProduto(produto);
    }

    public void deletarModeloProduto(ModelosDosProdutos modelo, Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.deletarModeloProduto(modelo, produto);
    }

    public void deletarCorProduto(Cor cor, Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.deletarCorProduto(cor, produto);
    }

}
