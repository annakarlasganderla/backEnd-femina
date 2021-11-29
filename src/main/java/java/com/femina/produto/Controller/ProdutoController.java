package java.com.femina.produto.Controller;

import main.java.com.femina.produto.Dao.ProdutoDao;

import java.com.femina.produto.Model.Produto;

public class ProdutoController {

    public Produto cadastrarProduto(Produto prod){
        ProdutoDao pd = new ProdutoDao();
        return pd.gravaProduto(prod);
    }

    public List<Produto> listarProdutos(){
        ProdutoDao pd = new ProdutoDao();
        List<Produto> lpd = pd.retornaProdutos();
        return lpd;
    }

    public void editarProduto(List<Produto> lpd){
        ProdutoDao pd = new ProdutoDao();
        pd.updateProd(lpd);

    }

    public void removerProduto(List<Produto> lpd){
        ProdutoDao pd = new ProdutoDao();
        pd.delProd(lpd);
    }

    public Produto pegaIdProduto(int index){
        ProdutoDao pd = new ProdutoDao();
        List<Produto> lpd = pd.retornaProdutos();
        return lpd.get(index);
    }

    public List<Produto> listarProdutosPeloId(Long idLoja){
        ProdutoDao pd = new ProdutoDao();
        return pd.retornaProdutosPeloIdLoja(idLoja);
    }

}
