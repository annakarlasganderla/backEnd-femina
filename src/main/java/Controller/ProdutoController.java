package Controller;

import Model.*;

import Dao.ProdutoDao;

import java.util.List;

public class ProdutoController {

    public ProdutoController(){
        this.criarTabelasProduto();
    }

    public void criarTabelasProduto(){
        ProdutoDao pd = new ProdutoDao();
        pd.criarTabelasProduto();
    }

    public void cadastrarProduto(Produto prod, Lojas lojas){
        ProdutoDao pd = new ProdutoDao();
        pd.cadastrarProduto(prod,lojas);
    }

    public List<Produto> listarProdutos(Lojas loja){
        ProdutoDao pd = new ProdutoDao();
        return pd.listaProdutoByIdLoja(loja);
    }

    public Produto selectById(int idProduto, Lojas loja){
        ProdutoDao pd = new ProdutoDao();
        return pd.selectById(idProduto, loja);
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

    public void updateTamanho(Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.updateTamanho(produto);
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

    public void deletarTamanhoProduto(Tamanho tamanho, Produto produto){
        ProdutoDao pd = new ProdutoDao();
        pd.deletarTamanhoProduto(tamanho, produto);
    }
}
