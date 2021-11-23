package main.java.com.femina.produto.Dao;
import java.io.*;
import java.util.*;

import main.java.com.femina.produto.Model.Contatos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ContatoDao {


    public void cadastraContato(List<Contatos> contato,String arq) throws IOException {
        File arquivo = new File("listaDeContatos"+arq+".txt");

        if(arquivo.isFile() ==  false){
            arquivo.createNewFile();
        }

        FileWriter localDoArquivo = new FileWriter(arquivo, true);
        PrintWriter escreveArquivo = new PrintWriter(localDoArquivo);

        for (int i = 0;i < contato.size();i++) {
            if(contato.get(i).getId() != Long.valueOf(i)+1) {
                contato.get(i).setId(Long.valueOf(i)+1);
                escreveArquivo.println(contato.get(i));
            }
        }
        localDoArquivo.close();
        escreveArquivo.flush();

    }


    public List<Contatos> mostraContato(String arq) throws IOException {

        File arquivo = new File("listaDeContatos"+arq+".txt");

        if(arquivo.isFile() ==  false){
            arquivo.createNewFile();
        }

        FileReader arquivoTxt1 = new FileReader(arquivo);
        BufferedReader lerArq = new BufferedReader(arquivoTxt1);

        List<String> ListString = new ArrayList<>();
        List<Contatos> listaDeContatos = new ArrayList<>();

        String linha = "";

        while ((linha = lerArq.readLine()) != null) {

            if (linha != null) {
                ListString.add(linha);
            }
        }

        arquivoTxt1.close();
        lerArq.close();

        for( String i : ListString){

            String[] prod = i.split(";");
            Contatos contatos = new Contatos();

            contatos.setId(Long.valueOf(prod[0]));
            contatos.setTel(prod[1]);
            contatos.setEmail(prod[2]);

            listaDeContatos.add(contatos);
        }

        return listaDeContatos;

    }

    public void editContatos(List <Contatos> contatos,String arq) throws IOException {

        FileWriter arquivoTxt = new FileWriter("listaDeContatos"+arq+".txt",false);
        PrintWriter gravaArq = new PrintWriter(arquivoTxt);

        for (int l = 0; l < contatos.size();l++ ) {
            gravaArq.println(contatos.get(l));
        }

        gravaArq.flush();
        gravaArq.close();
        arquivoTxt.close();

    }

    public void deletContatos (List<Contatos> contatos,String arq) throws IOException {

        FileWriter arquivoTxt = new FileWriter("listaDeContatos"+arq+".txt",false);
        PrintWriter gravaArq = new PrintWriter(arquivoTxt);

        for (int l = 0; l < contatos.size();l++ ) {
            contatos.get(l).setId(Long.valueOf(l)+1);
            gravaArq.println(contatos.get(l));
        }

        gravaArq.flush();
        gravaArq.close();
        arquivoTxt.close();

    }

}