package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Model.Cor;
import main.java.com.femina.produto.Model.ModelosDosProdutos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloDao {

    public void cadastraModelo(List<ModelosDosProdutos> modelo) throws IOException {
        try {
            File arquivo = new File("modeloDosProdutos.txt");

            if(arquivo.isFile() ==  false){
                arquivo.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(arquivo, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0;i < modelo.size();i++) {
                if(modelo.get(i).getId() != Long.valueOf(i)+1) {
                    modelo.get(i).setId(Long.valueOf(i) + 1);
                    printWriter.println(modelo.get(i));
                }
            }

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ModelosDosProdutos> mostraModelo() throws IOException {  // retorna uma lista

        FileReader fileReader = new FileReader("modeloDosProdutos.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> transformToString = new ArrayList<>();

        List<ModelosDosProdutos> listaDeModelos = new ArrayList<>();

        String linha = " ";

        while((linha = bufferedReader.readLine()) != null) {
            if (linha != null) {
                transformToString.add(linha);
            }
        }

        fileReader.close();
        bufferedReader.close();

        for (String i: transformToString) {
            String[] model = i.split(";");

            ModelosDosProdutos models = new ModelosDosProdutos();

            models.setId(Long.valueOf(model[0]));
            models.setNomeTipo(model[1]);
            models.setIdProduto(Long.valueOf(model[2]));

            listaDeModelos.add(models);
        }
        return listaDeModelos;
    }

    public void editaModelo(List<ModelosDosProdutos> modelosDosProdutos) throws IOException {
        FileWriter fileWriter = new FileWriter("modeloDosProdutos.txt",false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int listModelos = 0; listModelos < modelosDosProdutos.size(); listModelos++) {
            printWriter.println(modelosDosProdutos.get(listModelos));
        }

        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

    public void deletaModelo(List<ModelosDosProdutos> modelosDosProdutos) throws IOException {
        FileWriter fileWriter = new FileWriter("modeloDosProdutos.txt",false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int l = 0; l < modelosDosProdutos.size();l++) {
            if(modelosDosProdutos.get(l).getIdProduto() != 1){
                modelosDosProdutos.get(l).setIdProduto(modelosDosProdutos.get(l).getIdProduto()-1);
            }
            modelosDosProdutos.get(l).setId(Long.valueOf(l)+1);
            printWriter.println(modelosDosProdutos.get(l));
        }

        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

    public List<ModelosDosProdutos> listarId(Long idProd) throws IOException {
        List<ModelosDosProdutos> modelsProd = new ArrayList<>();
        List<ModelosDosProdutos> models = mostraModelo();

        for (int i = 0;i < models.size();i++){
            if (models.get(i).getIdProduto() == idProd){
                modelsProd.add(models.get(i));
            }
        }

        return modelsProd;
    }

}
