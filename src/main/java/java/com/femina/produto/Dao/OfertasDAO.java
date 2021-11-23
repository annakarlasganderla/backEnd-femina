package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Model.ProdutoDesconto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OfertasDAO {

    public void cadastrarOfertas(List<ProdutoDesconto> listaOfertas){

        File file = new File("ofertas.txt");
        if(file.isFile()){
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for(int i = 0; i < listaOfertas.size(); i++){
                    printWriter.println(listaOfertas.get(i));
                }
                printWriter.flush();
                fileWriter.close();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                file.createNewFile();
                cadastrarOfertas(listaOfertas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean cadastrarOfertasEditado(List<String> listaOfertas){

        File file = new File("ofertas.txt");
        if(file.isFile()){
            try {
                FileWriter fileWriter = new FileWriter(file, false);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for(int i = 0; i < listaOfertas.size(); i++){
                    printWriter.println(listaOfertas.get(i));
                }
                printWriter.flush();
                fileWriter.close();
                printWriter.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            try {
                file.createNewFile();
                cadastrarOfertasEditado(listaOfertas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean excluirOferta(int indexDelete){
        List<String> listaDeOfertas = new ArrayList<>();
        listaDeOfertas = listarOfertas();
        listaDeOfertas.remove(indexDelete);
        return cadastrarOfertasEditado(listaDeOfertas);
    }

    public List<String> listarOfertas(){

        List<String> listaDoArquivoOfertas = new ArrayList<>();
        List<String> listaRetorno = new ArrayList<>();
        Path path = Paths.get("ofertas.txt");
        try {
            listaDoArquivoOfertas = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < listaDoArquivoOfertas.size(); i++){
            String func = listaDoArquivoOfertas.get(i);
            listaRetorno.add(func);
        }
        return listaRetorno;
    }
}
