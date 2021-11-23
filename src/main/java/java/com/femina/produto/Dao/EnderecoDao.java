package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {

    public void cadastraEndereco(List<Endereco> listEndereco,String arq) throws IOException {
        File arquivo = new File("listaDeEndereços"+arq+".txt");

        if(arquivo.isFile() ==  false){
            arquivo.createNewFile();
        }

        FileWriter localDoArquivo = new FileWriter(arquivo, true);
        PrintWriter escreveArquivo = new PrintWriter(localDoArquivo);

        for(int i = 0;i < listEndereco.size();i++) {
            if(listEndereco.get(i).getIdEndereco() != Long.valueOf(i)+1) {
                listEndereco.get(i).setIdEndereco(Long.valueOf(i)+1);
                escreveArquivo.println(listEndereco.get(i));
            }
        }
        localDoArquivo.close();
        escreveArquivo.flush();
    }

    public List<Endereco> mostraEndereco(String arq) throws IOException {

        File arquivo = new File("listaDeEndereços"+arq+".txt");

        if(arquivo.isFile() ==  false){
            arquivo.createNewFile();
        }

        FileReader arquivoTxt1 = new FileReader(arquivo);
        BufferedReader lerArq = new BufferedReader(arquivoTxt1);

        List<String> ListString = new ArrayList<>();
        List<Endereco> listaEndereco = new ArrayList<>();

        String linha = "";

        while ((linha = lerArq.readLine()) != null) {

            if (linha != null) {
                ListString.add(linha);
            }
        }

        arquivoTxt1.close();
        lerArq.close();

        for (String i : ListString) {

            String[] prod = i.split(";");
            Endereco endereco = new Endereco();

            endereco.setIdEndereco(Long.valueOf(prod[0]));
            endereco.setPais(prod[1]);
            endereco.setEstado(prod[2]);
            endereco.setCidade(prod[3]);
            endereco.setRua(prod[4]);
            endereco.setCep(prod[5]);
            endereco.setNumCasa(Integer.valueOf(prod[6]));

            listaEndereco.add(endereco);
        }

        return listaEndereco;
    }


    public void editEndereco (List <Endereco> endereco,String arq) throws IOException {

        FileWriter arquivoTxt = new FileWriter("listaDeEndereços"+arq+".txt",false);
        PrintWriter gravaArq = new PrintWriter(arquivoTxt);


        for (int l = 0; l < endereco.size();l++ ) {
            gravaArq.println(endereco.get(l));
        }

        gravaArq.flush();
        gravaArq.close();
        arquivoTxt.close();

    }

    public void delEndereco (List <Endereco> endereco,String arq) throws IOException {

        FileWriter arquivoTxt = new FileWriter("listaDeEndereços"+arq+".txt",false);
        PrintWriter gravaArq = new PrintWriter(arquivoTxt);

        for (int l = 0; l < endereco.size();l++ ) {
            endereco.get(l).setIdEndereco(Long.valueOf(l)+1);
            gravaArq.println(endereco.get(l));
        }

        gravaArq.flush();
        gravaArq.close();
        arquivoTxt.close();

    }
}