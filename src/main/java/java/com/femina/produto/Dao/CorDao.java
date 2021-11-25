//package main.java.com.femina.produto.Dao;
//
//import main.java.com.femina.produto.Model.Cor;
//import main.java.com.femina.produto.Model.Endereco;
//import main.java.com.femina.produto.Model.Marca;
//
//import java.io.*;
//import java.util.*;
//
//public class CorDao {
//
//    public void cadastraCor(List<Cor> cor) {
//        try {
//            File arquivo = new File("cor.txt");
//
//            if(arquivo.isFile() ==  false){
//                arquivo.createNewFile();
//            }
//
//            FileWriter fileWriter = new FileWriter(arquivo, true);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            for(int i = 0;i < cor.size();i++) {
//                if(cor.get(i).getId() != Long.valueOf(i)+1) {
//                    cor.get(i).setId(Long.valueOf(i) + 1);
//                    printWriter.println(cor.get(i));
//                }
//            }
//
//            printWriter.flush();
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Cor> mostraCor() throws IOException {
//        FileReader fileReader = new FileReader("cor.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        List<String> tranformToString = new ArrayList<>();
//
//        List<Cor> listaCores = new ArrayList<>();
//
//        String linha = " ";
//
//        while ((linha = bufferedReader.readLine()) != null) {
//            if (linha != null) {
//                tranformToString.add(linha);
//            }
//        }
//        fileReader.close();
//        bufferedReader.close();
//
//        for (String i: tranformToString) {
//            String[] cs = i.split(";");
//
//            Cor cores = new Cor();
//
//            cores.setId(Long.valueOf(cs[0]));
//            cores.setNome(cs[1]);
//            cores.setHexadecimal(cs[2]);
//            cores.setIdProduto(Long.valueOf(cs[3]));
//
//            listaCores.add(cores);
//        }
//
//        return listaCores;
//    }
//
//    public void editaCores(List<Cor> cores) {
//        try {
//
//            FileWriter fileWriter = new FileWriter("cor.txt", false);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            for (int list = 0; list < cores.size(); list++) {
//                printWriter.println(cores.get(list));
//            }
//
//            printWriter.flush();
//            printWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delCor (List <Cor> cores) throws IOException {
//
//        FileWriter arquivoTxt = new FileWriter("cor.txt",false);
//        PrintWriter gravaArq = new PrintWriter(arquivoTxt);
//
//        for (int l = 0; l < cores.size();l++) {
//            if(cores.get(l).getIdProduto() != 1){
//                cores.get(l).setIdProduto(cores.get(l).getIdProduto()-1);
//            }
//            cores.get(l).setId(Long.valueOf(l)+1);
//            gravaArq.println(cores.get(l));
//        }
//
//        gravaArq.flush();
//        gravaArq.close();
//        arquivoTxt.close();
//
//    }
//
//    public List<Cor> listarId(Long idProd) throws IOException {
//
//        List<Cor> coresProd = new ArrayList<>();
//        List<Cor> cores = mostraCor();
//
//        for (int i = 0;i < cores.size();i++){
//            if (cores.get(i).getIdProduto() == idProd){
//                coresProd.add(cores.get(i));
//            }
//        }
//
//        return coresProd;
//
//    }
//
//}
