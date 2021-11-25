//package main.java.com.femina.produto.View;
//import main.java.com.femina.produto.Controller.CategoriaController;
//import main.java.com.femina.produto.Model.Categoria;
//import main.java.com.femina.produto.Controller.ProdutoController;
//import main.java.com.femina.produto.Model.Produto;
//import main.java.com.femina.produto.Model.ProdutoDesconto;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;
//import java.util.Scanner;
//
//public class CategoriaView {
//
//    Scanner leitor = new Scanner(System.in).useLocale(Locale.US);
//    CategoriaController categoriaController = new CategoriaController();
//
//    public void cadastrarCategoria() throws IOException {
//
//        Categoria categoria = new Categoria();
//        ProdutoController ProdutoController = new ProdutoController();
//        List<Produto> listaProdutos = ProdutoController.listarProdutos();
//
//        for(int i = 0; i < listaProdutos.size();i++) {
//            System.out.println(listaProdutos.get(i));
//        }
//
//        System.out.println("Em porduto você quer adicionar uma categoria: ");
//
//        int idProdutoSelecionado = leitor.nextInt();
//        categoria.setIdProduto(Long.valueOf(idProdutoSelecionado));
//
//        System.out.println("Digite o nome da categoria ");
//        categoria.setNome(leitor.next());
//
//        System.out.println("Digite o Id da categoria ");
//        categoria.setId(leitor.nextLong());
//
//
//        categoriaController.cadastrarCategoria(categoria);
//    }
//
//    public List<Categoria> mostrarListaDeCategorias() throws IOException {
//
//        CategoriaController categoriaController = new CategoriaController();
//        List<Categoria>  listaDeCategorias = categoriaController.mostrarListaDeCategoria();
//        System.out.println(listaDeCategorias);
//        return listaDeCategorias;
//    }
//
//    public void editarCategoriaByIdProduto() throws IOException {
//        ProdutoController produtoController = new ProdutoController();
//        List<Produto> listaDeProdutos = produtoController.listarProdutos();
//
//        System.out.println(listaDeProdutos);
//
//        System.out.println("Qual produto você quer editar a categoria: ");
//        int idProdutoSelecionado = leitor.nextInt();
//
//        System.out.println("Qual a nova categoria: ");
//        String categoria = leitor.next();
//
//        List<Categoria> listaDeCategorias = mostrarListaDeCategorias();
//
//        for (int i = 0; i < listaDeCategorias.size();i++) {
//            if(listaDeCategorias.get(i).getIdProduto() == listaDeProdutos.get(idProdutoSelecionado - 1).getId()) {
//                listaDeCategorias.get(i).setNome();
//            }
//        }
//
//        categoriaController.removeCategoria(listaDeCategorias);
//    }
//
//    public void removerCategoriaByIdProduto() throws IOException {
//        ProdutoController produtoController = new ProdutoController();
//        List<Produto> listaDeProdutos = produtoController.listarProdutos();
//
//        System.out.println(listaDeProdutos);
//
//        System.out.println("Qual produto você quer remover a categoria: ");
//        int idProdutoSelecionado = leitor.nextInt();
//
//        List<Categoria> listaDeCategorias = mostrarListaDeCategorias();
//
//        for (int i = 0; i < listaDeCategorias.size(); i++) {
//            if (listaDeCategorias.get(i).getIdProduto() == listaDeProdutos.get(idProdutoSelecionado - 1).getId()) {
//                listaDeCategorias.remove(i);
//            }
//            categoriaController.removeCategoria(listaDeCategorias);
//        }
//
//    } }
//
//
