//package main.java.com.femina.produto.View;
//
//
//import main.java.com.femina.produto.Controller.ModeloController;
//import main.java.com.femina.produto.Controller.TamanhoController;
//import main.java.com.femina.produto.Model.ModelosDosProdutos;
//import main.java.com.femina.produto.Model.Tamanho;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Scanner;
//
//public class TamanhoView {
//
//    Scanner entrada = new Scanner(System.in);
//    TamanhoController tamanhoController = new TamanhoController();
//    List<Tamanho> tamanhos = new ArrayList<>();
//
//    public void cadastrarTamanho(int idProd){
//        Tamanho tamanho = new Tamanho();
//        System.out.println("Tamanho:");
//        String tamanhoValue = entrada.next();
//        tamanho.setTam(tamanhoValue.toUpperCase(Locale.ROOT));
//        tamanho.setIdProduto(idProd);
//        tamanhos.add(tamanho);
//        System.out.println("Deseja continuar?\n1 - SIM\n2 - NÃO");
//        int continuar = entrada.nextInt();
//        if(continuar == 2){
//            System.out.println(tamanhos);
//            tamanhoController.cadastrarTamanho(tamanhos);
//        }else{
//            cadastrarTamanho(idProd);
//        }
//    }
//
//    public void mostrarTamanho(){
//        List<Tamanho> listaTamanhos = tamanhoController.listaTamanho();
//
//        for(int i = 0;i < listaTamanhos.size();i++){
//            System.out.println(listaTamanhos.get(i).toMostra());
//        }
//    }
//
//    public List<Tamanho> listarTamanhosDoProduto(int idProd) throws IOException {
//        return tamanhoController.listarTamanhosPeloIdProd(idProd);
//    }
//
//    public void deletarTamanho(int idProd) throws IOException {
//
//
//        List<Tamanho> tamanhoDosProdutos = tamanhoController.listaTamanho();
//        List<Tamanho> novalist = new ArrayList<>();
//
//        for(int i = 0;i < tamanhoDosProdutos.size();i++) {
//            if (tamanhoDosProdutos.get(i).getIdProduto() != idProd) {
//                novalist.add(tamanhoDosProdutos.get(i));
//            }
//        }
//
//        tamanhoController.deletaTamanho(novalist);
//
//    }
//}
