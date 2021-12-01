//package main.java.com.femina.produto.View;
//
//import main.java.com.femina.produto.Controller.OfertasController;
//import main.java.com.femina.produto.Controller.ProdutoDescontoController;
//import main.java.com.femina.produto.Dao.OfertasDAO;
//import main.java.com.femina.produto.Model.Ofertas;
//import main.java.com.femina.produto.Model.ProdutoDesconto;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class OfertasView {
//
//    ProdutoDescontoController produtoDescontoController = new ProdutoDescontoController();
//    OfertasController ofertasController = new OfertasController();
//    Ofertas ofertas = new Ofertas();
//    Scanner entrada = new Scanner(System.in);
//
//    public void cadastrarOfertas() throws IOException {
//        List<ProdutoDesconto> listaOfertas = new ArrayList<>();
//        List<ProdutoDesconto> produtoDescontoList = produtoDescontoController.mostrarListaDeDescontos();
//        int tamanhoListaProd = produtoDescontoList.size();
//        ofertas.setProdutoDescontoList(produtoDescontoList);
//        for(int i = 0; i < tamanhoListaProd; i++){
//            System.out.println((i+1) + " "+produtoDescontoList.get(i));
//        }
//        System.out.println("Escolha o produto para adicionar as ofertas:");
//        int produtoSelecionado = entrada.nextInt();
//        listaOfertas.add(ofertas.getProdutoDescontoList().get((produtoSelecionado - 1)));
//        System.out.println(listaOfertas);
//        ofertasController.cadastrarOfertas(listaOfertas);
//    }
//
//    public void excluirOferta() throws IOException {
//        int tamanhoListaOferta = ofertasController.listarOfertas().size();
//        for(int i = 0; i < tamanhoListaOferta; i++){
//            System.out.println((i+1)+" "+ofertasController.listarOfertas().get(i));
//        }
//        System.out.println("Escolha a oferta a ser excluída:");
//        int produtoSelecionado = entrada.nextInt();
//        if(ofertasController.excluirOferta((produtoSelecionado-1))){
//            System.out.println("Oferta deletada com sucesso!");
//        }else{
//            System.out.println("Erro ao deletar oferta!");
//        }
//    }
//
//    public void listarOfertas(){
//        int tamanhoListaOferta = ofertasController.listarOfertas().size();
//        for(int i = 0; i < tamanhoListaOferta; i++){
//            System.out.println((i+1)+" "+ofertasController.listarOfertas().get(i));
//        }
//    }
//}
