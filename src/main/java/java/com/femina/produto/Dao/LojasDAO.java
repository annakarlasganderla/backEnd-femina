//package main.java.com.femina.produto.Dao;
//
//import main.java.com.femina.produto.Model.Lojas;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LojasDAO {
//
//    List<String> lojasList = new ArrayList<>();
//    Lojas lojas = new Lojas();
//    List<Lojas> lojasListParaEditar = new ArrayList<>();
//
//    public void cadastrarLojas(List<Lojas> lojasList) throws IOException {
//
//        File arq = new File("lojas.txt");
//
//        if (!arq.isFile()) {
//            arq.createNewFile();
//        }
//        FileWriter fileWriter = new FileWriter(arq, true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//
//        for(int i = 0; i < lojasList.size(); i++){
//
//            printWriter.println(validarId(lojasList.get(i)));
//
//        }
//
//        printWriter.flush();
//        fileWriter.close();
//        printWriter.close();
//
//    }
//
//    public void cadastrarLojasEditadas(List<Lojas> lojasList) throws IOException {
//
//        File arq = new File("lojas.txt");
//
//        if (!arq.isFile()) {
//            arq.createNewFile();
//        }
//        FileWriter fileWriter = new FileWriter(arq);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//
//        for(int i = 0; i < lojasList.size(); i++){
//
//            lojasList.get(i).setId(i);
//            printWriter.println(lojasList.get(i));
//
//        }
//
//        printWriter.flush();
//        fileWriter.close();
//        printWriter.close();
//
//    }
//
//
//    public List<Lojas> listarLojas() throws IOException {
//        List<Lojas> lojasListParaEditar2 = new ArrayList<>();
//        File arq = new File("lojas.txt");
//
//        FileReader fileReader = new FileReader(arq);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        Path path = Paths.get("lojas.txt");
//        lojasList = Files.readAllLines(path);
//
//
//        for (int j = 0; j < lojasList.size(); j++) {
//
//            String lojasNaLista = lojasList.get(j);
//
//            String[] valorEditar = lojasNaLista.split(";");
//
//            lojas = new Lojas(Long.valueOf(valorEditar[0]), valorEditar[1]);
//
//            lojasListParaEditar2.add(lojas);
//
//        }
//
//        return lojasListParaEditar2;
//    }
//
//    public Lojas validarId(Lojas lojas) throws IOException {
//
//        lojasListParaEditar = listarLojas();
//
//        for(int i = 0; i<lojasListParaEditar.size();i++){
//
//            if(lojas.getId() == lojasListParaEditar.get(i).getId()){
//                lojas.setId((i+1));
//            }
//        }
//
//        return lojas;
//    }
//
//}
