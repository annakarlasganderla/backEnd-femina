package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Controller.FuncionariosController;
import main.java.com.femina.produto.Model.Funcionarios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionariosDAO {

    public List<Funcionarios> cadastrar(List<Funcionarios> funcionarios) throws IOException {

        File arquivoFuncionario = new File("funcionarios.txt");

        if(!arquivoFuncionario.isFile()){

            arquivoFuncionario.createNewFile();

        }

        FileWriter fileWriter = new FileWriter(arquivoFuncionario, true);
        PrintWriter gravaFuncionarios = new PrintWriter(fileWriter);

        for(int i = 0; i < funcionarios.size(); i++) {

            funcionarios.get(i).setId(i);
            gravaFuncionarios.println(funcionarios.get(i));

        }

        fileWriter.close();
        gravaFuncionarios.close();
        return funcionarios;
    }

    public List<Funcionarios> mostrarFuncionarios() throws IOException {
        int dadosInt = 0;
        List<String> listaDoArquivoFuncionarios = new ArrayList<>();
        List<Funcionarios> listaDeFuncionarios = new ArrayList<>();
        Path path = Paths.get("funcionarios.txt");
        listaDoArquivoFuncionarios = Files.readAllLines(path);
        for(int i = 0; i < listaDoArquivoFuncionarios.size(); i++){
            String func = listaDoArquivoFuncionarios.get(i);
            String[] dadosFuncionario = func.split(";");
            if(isNumeric(dadosFuncionario[i])){
                dadosInt = (Integer.parseInt(dadosFuncionario[i]));
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setId(dadosInt);
                funcionarios.setNome(dadosFuncionario[1]);
                funcionarios.setCargo(dadosFuncionario[2]);
                //funcionarios.setEndereco(dadosFuncionario[3]); passar endereço como string vai ajudar aqui!!!
                funcionarios.setIdEmpresa(dadosInt);
                //funcionarios.setContatos(dadosFuncionario[5]); mesma coisa de endereco
                listaDeFuncionarios.add(funcionarios);
            }
        }
        return listaDeFuncionarios;
    }

    public List<Funcionarios> editar(List<Funcionarios> listaFuncionarios) throws IOException {

        File arquivoFuncionario = new File("funcionarios.txt");

        if(!arquivoFuncionario.isFile()){

            arquivoFuncionario.createNewFile();

        }

        FileWriter fileWriter = new FileWriter(arquivoFuncionario);
        PrintWriter gravaFuncionarios = new PrintWriter(fileWriter);

        gravaFuncionarios.println(listaFuncionarios);

        fileWriter.close();
        gravaFuncionarios.close();
        return null;
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
