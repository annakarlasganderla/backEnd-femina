package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Controller.ContatoController;
import main.java.com.femina.produto.Controller.EnderecoController;
import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;
import main.java.com.femina.produto.Model.Marca;

import java.io.*;
import java.util.*;

public class MarcaDao {

    public void cadastraMarca(List<Marca> marca) {
        try {

            FileWriter fileWriter = new FileWriter("marcas.txt", true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0;i < marca.size();i++) {
                if (marca.get(i).getId() != i + 1) {
                    marca.get(i).setId(i+1);
                    printWriter.println(marca.get(i));
                }
            }

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Marca> mostraMarcas() throws IOException {

        FileReader fileReader = new FileReader("marcas.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> tranformToString = new ArrayList<>();

        List<Marca> listaMarcas = new ArrayList<>();

        String linha = " ";

        while((linha = bufferedReader.readLine()) != null) {
            if(linha != null) {
                tranformToString.add(linha);
            }
        }

        fileReader.close();
        bufferedReader.close();

        for (String i: tranformToString) {
            String[] marc = i.split(";");

            Marca marc2 = new Marca();

            marc2.setId(Long.valueOf(marc[0]));
            marc2.setNome(marc[1]);
            ContatoController cc = new ContatoController();
            List<Contatos> ldc = cc.mostraContato("marca");
            for(int j = 0;j < ldc.size();j++){
                if(ldc.get(j).getId() == Integer.valueOf(marc[2])){
                    marc2.setContatos(ldc.get(j));
                }
            }
            EnderecoController ec = new EnderecoController();
            List<Endereco> lde = ec.mostraEndereco("marca");
            for(int j = 0;j < lde.size();j++){
                if(lde.get(j).getIdEndereco() == Long.valueOf(marc[3])){
                    marc2.setEnderecoMarca(lde.get(j));
                }
            }

            listaMarcas.add(marc2);
        }
        return listaMarcas;
    }

    public void editaMarca(List<Marca> marcas) throws IOException {

        FileWriter fileWriter = new FileWriter("marcas.txt",false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int listMarcas = 0; listMarcas < marcas.size(); listMarcas++) {
            printWriter.println(marcas.get(listMarcas));
        }

        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

    public void deletaMarca(List<Marca> marcas) throws IOException {

        FileWriter fileWriter = new FileWriter("marcas.txt",false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int list = 0; list < marcas.size(); list++) {
            if(marcas.get(list).getEnderecoMarca().getIdEndereco() != 1){
                marcas.get(list).getEnderecoMarca().setIdEndereco(marcas.get(list).getEnderecoMarca().getIdEndereco()-1);
            }
            if(marcas.get(list).getContatos().getId() != 1){
                marcas.get(list).getContatos().setId(marcas.get(list).getContatos().getId()-1);
            }
            marcas.get(list).setId(list+1);
            printWriter.println(marcas.get(list));
        }

        printWriter.flush();
        printWriter.close();
        fileWriter.close();

    }
}
