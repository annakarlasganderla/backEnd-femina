package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Controller.ContatoController;
import main.java.com.femina.produto.Controller.EnderecoController;
import main.java.com.femina.produto.Model.Cliente;
import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;
import main.java.com.femina.produto.Model.Fornecedor;

import java.io.*;
import java.util.*;

public class ClienteDao {

    public void gravarCliente(List<Cliente> cliente){
        File arq = new File("clientes.txt");

        try {
            if(arq.isFile() ==  false){
                arq.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(arq, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0;i < cliente.size();i++) {
                if(cliente.get(i).getId() != Long.valueOf(i)+1) {
                    cliente.get(i).setId(Long.valueOf(i)+1);
                    printWriter.println(cliente.get(i));
                }
            }

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> retornaCliente(){
        List<Cliente> clientes = new ArrayList<>();
        try {
            File arquivoDeTexto = new File ("clientes.txt");

            if(!arquivoDeTexto.isFile()){
                arquivoDeTexto.createNewFile();
            }

            FileReader fileReader = new FileReader(arquivoDeTexto);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";

            List<String> result = new ArrayList();

            while ((linha = bufferedReader.readLine()) != null) {
                if (linha != null && !linha.isEmpty()) {
                    result.add(linha);
                }
            }
            fileReader.close();
            bufferedReader.close();

            for (String s : result) {
                String[] cl = s.split(";");

                Cliente cliente = new Cliente();

                cliente.setId(Integer.valueOf(cl[0]));
                cliente.setNome(cl[1]);
                cliente.setIdade(Integer.valueOf(cl[2]));
                cliente.setSenha(cl[3]);
                ContatoController cc = new ContatoController();
                List<Contatos> ldc = cc.mostraContato("cliente");
                for(int i = 0;i < ldc.size();i++){
                    if(ldc.get(i).getId() == Integer.valueOf(cl[4])){
                        cliente.setContatos(ldc.get(i));
                    }
                }
                EnderecoController ec = new EnderecoController();
                List<Endereco> lde = ec.mostraEndereco("cliente");
                for(int i = 0;i < lde.size();i++){
                    if(lde.get(i).getIdEndereco() == Long.valueOf(cl[5])){
                        cliente.setEndereco(lde.get(i));
                    }
                }

                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void editCliente(List<Cliente> ldc){
        try {

            FileWriter fileWriter = new FileWriter("clientes.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int list = 0; list < ldc.size(); list++) {
                printWriter.println(ldc.get(list));
            }

            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delCliente(List<Cliente> ldc){
        try {

            FileWriter fileWriter = new FileWriter("clientes.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int list = 0; list < ldc.size(); list++) {
                if(ldc.get(list).getEndereco().getIdEndereco() != 1){
                    ldc.get(list).getEndereco().setIdEndereco(ldc.get(list).getEndereco().getIdEndereco()-1);
                }
                if(ldc.get(list).getContatos().getId() != 1){
                    ldc.get(list).getContatos().setId(ldc.get(list).getContatos().getId()-1);
                }
                ldc.get(list).setId(list+1);
                printWriter.println(ldc.get(list));
            }

            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
