//package main.java.com.femina.produto.Dao;
//
//import main.java.com.femina.produto.Model.ModelosDosProdutos;
//import main.java.com.femina.produto.Model.ProdutoDesconto;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProdutosComDescontoDao {
//
//    public void cadastrarDesconto(List<ProdutoDesconto> descontoList, Double precoComDesconto) throws IOException {
//        FileWriter descontoFile = new FileWriter("descontos.txt",true);
//        PrintWriter printaDesconto = new PrintWriter(descontoFile);
//
//        for(int i = 0; i < descontoList.size();i++) {
//            descontoList.get(i).setPreco(precoComDesconto);
//            printaDesconto.println(descontoList.get(i));
//
//        }
//
//        printaDesconto.flush();
//        printaDesconto.close();
//    }
//
//    public List<ProdutoDesconto> mostrarListaDeDesconto () throws IOException {
//        FileReader fileReader = new FileReader("descontos.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        List<String> transformToString = new ArrayList<>();
//
//        List<ProdutoDesconto> listaDeDescontos = new ArrayList<>();
//
//        String linha = " ";
//
//        while((linha = bufferedReader.readLine()) != null) {
//            if (linha != null) {
//                transformToString.add(linha);
//            }
//        }
//
//        fileReader.close();
//        bufferedReader.close();
//
//        for (String i: transformToString) {
//            String[] descs = i.split(";");
//
//            ProdutoDesconto descontos = new ProdutoDesconto();
//
//            descontos.setPreco(Double.valueOf(descs[0]));
//            descontos.setIdProduto(Long.valueOf(descs[1]));
//
//            listaDeDescontos.add(descontos);
//        }
//        return listaDeDescontos;
//    }
//
//    public void editaDeletaDesconto(List<ProdutoDesconto> produtoDescontos) throws IOException {
//        FileWriter fileWriter = new FileWriter("descontos.txt",false);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//
//        for (int listDescontos = 0; listDescontos < produtoDescontos.size(); listDescontos++) {
//            printWriter.println(produtoDescontos.get(listDescontos));
//        }
//
//        printWriter.flush();
//        printWriter.close();
//        fileWriter.close();
//    }
//
//
//
//
//
//}
