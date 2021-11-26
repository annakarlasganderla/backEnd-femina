//package main.java.com.femina.produto.View;
//
//import main.java.com.femina.produto.Controller.FavoritosController;
//import main.java.com.femina.produto.Dao.FavoritosDao;
//import main.java.com.femina.produto.Model.Favoritos;
//import main.java.com.femina.produto.Model.Produto;
//
//import java.io.IOException;
//import java.util.*;
//
//public class FavoritosView {
//
//    FavoritosController favoritosController = new FavoritosController();
//    ClienteView clientes = new ClienteView();
//    Scanner leitor = new Scanner(System.in);
//
//    public void favoritar (long idLoja, long idCliente) throws IOException {
//
//        ProdutoView produtos = new ProdutoView();
//
//        System.out.println("Selecione o seu favorito:");
//        List<Produto> listaProdutos = produtos.listarProdutosDaLoja(idLoja);
//
//        Favoritos favoritos = new Favoritos();
//
//        favoritos.setIdProduto(listaProdutos.get(leitor.nextInt()-1).getId());
//        favoritos.setIdCliente(idCliente);
//
//        favoritosController.cadastrarFavoritos(favoritos);
//
//    }
//    public void vizualizar() throws IOException {
//
//        List<Favoritos> listaDeFavoritos = favoritosController.listaFavoritos();
//        System.out.println(listaDeFavoritos);
//    }
//}
