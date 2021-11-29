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

//    public List<Produto> listarProdutos(){
//        ProdutoDao pd = new ProdutoDao();
//        return lpd;
//    }
//
//    public void editarProduto(Produto produto){
//        ProdutoDao pd = new ProdutoDao();
//        pd.editarProduto(produto);
//
//    }
//
//    public void deletarProduto(Produto produto){
//        ProdutoDao pd = new ProdutoDao();
//        pd.deletarProduto(produto);
//    }
//
//    public Produto pegaIdProduto(int index){
//        ProdutoDao pd = new ProdutoDao();
//        List<Produto> lpd = pd.retornaProdutos();
//        return lpd.get(index);
//    }
//
//    public List<Produto> listarProdutosPeloId(Long idLoja){
//        ProdutoDao pd = new ProdutoDao();
//        return pd.retornaProdutosPeloIdLoja(idLoja);
//    }

}
