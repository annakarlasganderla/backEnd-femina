<<<<<<< HEAD
package Dao;

import Factory.ConectionFactory;
import Model.Contatos;

import java.sql.*;
import java.util.*;


public class ContatoDao {

    private Connection connection;

    public ContatoDao() {
        this.connection = new ConectionFactory().getConection();
    }

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS contatos ("+
                "idContatos INT PRIMARY KEY AUTO_INCREMENT," +
                "telefone VARCHAR(50) NOT NULL," +
                "email VARCHAR(50) NOT NULL" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Contatos criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(Contatos contatos){

        String sql = "INSERT INTO contatos" +
                " (telefone,email) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, contatos.getTel());
            stmt.setString(2, contatos.getEmail());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                contatos.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contatos> mostraLista(){

        String sql = "SELECT * FROM contatos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Contatos> contatos = new ArrayList<>();
            Contatos contato;

            while (resultSet.next()) {
                contato = new Contatos();
                contato.setTel(resultSet.getString("telefone"));
                contato.setEmail(resultSet.getString("email"));
                contato.setId(resultSet.getInt("idContatos"));
                contatos.add(contato);
            }

            return contatos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } }


    public Contatos SelecionaId (int id){

        String sql = "SELECT * FROM contatos WHERE idContatos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Contatos contato = new Contatos();
                contato.setId(resultSet.getInt("idContatos"));
                contato.setTel(resultSet.getString("telefone"));
                contato.setEmail(resultSet.getString("email"));

                return contato;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editarContatoDoBanco(Contatos contatos){
        String sql = "UPDATE contatos SET email = ?, telefone = ? WHERE idContatos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contatos.getEmail());
            stmt.setString(2, contatos.getTel());
            stmt.setInt(3, contatos.getId());


            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void removeContatoDoBanco(Contatos contatos){
        String sql = "DELETE FROM contatos WHERE idContatos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contatos.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
=======
//package main.java.com.femina.produto.Dao;
//import java.io.*;
//import java.util.*;
//
//import main.java.com.femina.produto.Model.Contatos;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//public class ContatoDao {
//
//
//    public void cadastraContato(List<Contatos> contato,String arq) throws IOException {
//        File arquivo = new File("listaDeContatos"+arq+".txt");
//
//        if(arquivo.isFile() ==  false){
//            arquivo.createNewFile();
//        }
//
//        FileWriter localDoArquivo = new FileWriter(arquivo, true);
//        PrintWriter escreveArquivo = new PrintWriter(localDoArquivo);
//
//        for (int i = 0;i < contato.size();i++) {
//            if(contato.get(i).getId() != Long.valueOf(i)+1) {
//                contato.get(i).setId(Long.valueOf(i)+1);
//                escreveArquivo.println(contato.get(i));
//            }
//        }
//        localDoArquivo.close();
//        escreveArquivo.flush();
//
//    }
//
//
//    public List<Contatos> mostraContato(String arq) throws IOException {
//
//        File arquivo = new File("listaDeContatos"+arq+".txt");
//
//        if(arquivo.isFile() ==  false){
//            arquivo.createNewFile();
//        }
//
//        FileReader arquivoTxt1 = new FileReader(arquivo);
//        BufferedReader lerArq = new BufferedReader(arquivoTxt1);
//
//        List<String> ListString = new ArrayList<>();
//        List<Contatos> listaDeContatos = new ArrayList<>();
//
//        String linha = "";
//
//        while ((linha = lerArq.readLine()) != null) {
//
//            if (linha != null) {
//                ListString.add(linha);
//            }
//        }
//
//        arquivoTxt1.close();
//        lerArq.close();
//
//        for( String i : ListString){
//
//            String[] prod = i.split(";");
//            Contatos contatos = new Contatos();
//
//            contatos.setId(Long.valueOf(prod[0]));
//            contatos.setTel(prod[1]);
//            contatos.setEmail(prod[2]);
//
//            listaDeContatos.add(contatos);
//        }
//
//        return listaDeContatos;
//
//    }
//
//    public void editContatos(List <Contatos> contatos,String arq) throws IOException {
//
//        FileWriter arquivoTxt = new FileWriter("listaDeContatos"+arq+".txt",false);
//        PrintWriter gravaArq = new PrintWriter(arquivoTxt);
//
//        for (int l = 0; l < contatos.size();l++ ) {
//            gravaArq.println(contatos.get(l));
//        }
//
//        gravaArq.flush();
//        gravaArq.close();
//        arquivoTxt.close();
//
//    }
//
//    public void deletContatos (List<Contatos> contatos,String arq) throws IOException {
//
//        FileWriter arquivoTxt = new FileWriter("listaDeContatos"+arq+".txt",false);
//        PrintWriter gravaArq = new PrintWriter(arquivoTxt);
//
//        for (int l = 0; l < contatos.size();l++ ) {
//            contatos.get(l).setId(Long.valueOf(l)+1);
//            gravaArq.println(contatos.get(l));
//        }
//
//        gravaArq.flush();
//        gravaArq.close();
//        arquivoTxt.close();
//
//    }
//
//}
>>>>>>> 2eef407d592c873b04e27a964b4054d98dbce436
