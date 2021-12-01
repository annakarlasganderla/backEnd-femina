//package main.java.com.femina.produto.Dao;
//
//import main.java.com.femina.produto.Model.Destaques;
//import main.java.com.femina.produto.Model.ProdutoDesconto;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DestaquesDao {
//
//    public void cadastraDestaque(List<Destaques> destaquesList) throws IOException {
//
//        FileWriter destaqueFile = new FileWriter("destaques.txt",true);
//        PrintWriter printaDestaque = new PrintWriter(destaqueFile);
//
//        for(int i = 0; i < destaquesList.size();i++) {
//            printaDestaque.println(destaquesList.get(i));
//        }
//
//        printaDestaque.flush();
//        printaDestaque.close();
//
//    }
//
//    public List<Destaques> mostraListaDeDestaques() throws IOException {
//        FileReader fileReader = new FileReader("destaques.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        List<String> transformToString = new ArrayList<>();
//
//        List<Destaques> listaDeDestaques = new ArrayList<>();
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
//            Destaques destaques = new Destaques();
//
//            destaques.setIdProduto(Long.valueOf(descs[0]));
//
//            listaDeDestaques.add(destaques);
//        }
//        return listaDeDestaques;
//    }
//
//    public void removeDestaque(List<Destaques> destaquesList) throws IOException {
//        FileWriter fileWriter = new FileWriter("destaques.txt",false);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//
//        for (int listDestaques = 0; listDestaques < destaquesList.size(); listDestaques++) {
//            printWriter.println(destaquesList.get(listDestaques));
//        }
//
//        printWriter.flush();
//        printWriter.close();
//        fileWriter.close();
//    }
//
//}
