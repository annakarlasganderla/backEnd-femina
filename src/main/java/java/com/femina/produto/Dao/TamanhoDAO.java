package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Model.Funcionarios;
import main.java.com.femina.produto.Model.ModelosDosProdutos;
import main.java.com.femina.produto.Model.Tamanho;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TamanhoDAO {

    List<Tamanho> listaValidacao = new ArrayList<>();
    Tamanho tamanho = new Tamanho();

    public void cadastrarTamanho(List<Tamanho> tamanhos){

        File file = new File("tamanhos.txt");
        if(file.isFile()){
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for(int i = 0; i < tamanhos.size(); i++){
                    if(!validarTamanho(tamanhos.get(i))){
                        printWriter.println(validarId(tamanhos.get(i)));
                    }
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
                cadastrarTamanho(tamanhos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Tamanho> listarTamanhos(){
        int dadosInt = 0;
        List<String> listaDoArquivoTamanhos = new ArrayList<>();
        List<Tamanho> listaDeTamanhos = new ArrayList<>();
        Path path = Paths.get("tamanhos.txt");
        try {
            listaDoArquivoTamanhos = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < listaDoArquivoTamanhos.size(); i++){
            String func = listaDoArquivoTamanhos.get(i);
            String[] dadosFuncionario = func.split(";");
            if(isNumeric(dadosFuncionario[0])){
                dadosInt = (Integer.parseInt(dadosFuncionario[0]));
                Tamanho tamanho = new Tamanho();
                tamanho.setId(dadosInt);
                tamanho.setTam(dadosFuncionario[1]);
                tamanho.setIdProduto(Integer.valueOf(dadosFuncionario[2]));
                listaDeTamanhos.add(tamanho);
            }
        }
        return listaDeTamanhos;
    }

    public List<Tamanho> listTamanhosId(int idProd){

        List<Tamanho> newList = new ArrayList<>();
        List<Tamanho> listaTotal = listarTamanhos();

        for(int i = 0;i < listaTotal.size();i++) {
            if(listaTotal.get(i).getIdProduto() == idProd){
                newList.add(listaTotal.get(i));
            }
        }
        return newList;
    }

    public void deletaTamanho(List<Tamanho> listaTamanho) throws IOException {
        FileWriter fileWriter = new FileWriter("tamanhos.txt",false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int l = 0; l < listaTamanho.size();l++) {
            if(listaTamanho.get(l).getIdProduto() != 1){
                listaTamanho.get(l).setIdProduto(listaTamanho.get(l).getIdProduto()-1);
            }
            listaTamanho.get(l).setId(Integer.valueOf(l)+1);
            printWriter.println(listaTamanho.get(l));
        }

        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

    public Tamanho validarId(Tamanho tamanho){
        for(int i = 0; i<listaValidacao.size();i++){
            if(tamanho.getId() == listaValidacao.get(i).getId()){
                tamanho.setId(i+1);
            }
        }
        return tamanho;
    }

    public boolean validarTamanho(Tamanho tamanho){

        listaValidacao = listarTamanhos();

        for(int i = 0; i<listaValidacao.size();i++){
            if(tamanho.getTam().equals(listaValidacao.get(i).getTam())){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
