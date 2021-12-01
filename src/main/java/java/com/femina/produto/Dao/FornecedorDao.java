package main.java.com.femina.produto.Dao;

import main.java.com.femina.produto.Controller.ContatoController;
import main.java.com.femina.produto.Controller.EnderecoController;
import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;
import main.java.com.femina.produto.Model.Fornecedor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

    public void gravarFornecedor(List<Fornecedor> forn){
        File arq = new File("fornecedores.txt");

        try {
            if(arq.isFile() ==  false){
                arq.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(arq, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0;i < forn.size();i++){
                if(forn.get(i).getId() != i+1){
                    forn.get(i).setId(i+1);
                    printWriter.println(forn.get(i));
                }
            }

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Fornecedor> retornaFornecedores(){
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            File arquivoDeTexto = new File ("fornecedores.txt");

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
                String[] forncedores = s.split(";");

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(Integer.valueOf(forncedores[0]));
                fornecedor.setNome(forncedores[1]);
                fornecedor.setCnpj(forncedores[2]);
                ContatoDao cd = new ContatoDao();
                List<Contatos> ldc = cd.mostraContato("fornecedor");
                for(int i = 0;i < ldc.size();i++){
                    if(ldc.get(i).getId() == Integer.valueOf(forncedores[3])){
                        fornecedor.setContatos(ldc.get(i));
                    }
                }
                EnderecoDao ed = new EnderecoDao();
                List<Endereco> lde = ed.mostraEndereco("fornecedor");
                for(int i = 0;i < lde.size();i++){
                    if(lde.get(i).getIdEndereco() == Long.valueOf(forncedores[4])){
                        fornecedor.setEndereco(lde.get(i));
                    }
                }

                fornecedores.add(fornecedor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fornecedores;
    }

    public void editFornecedor(List<Fornecedor> forn){
        try {

            FileWriter fileWriter = new FileWriter("fornecedores.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int list = 0; list < forn.size(); list++) {
                printWriter.println(forn.get(list));
            }

            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delFornecedor(List<Fornecedor> forn){
        try {

            FileWriter fileWriter = new FileWriter("fornecedores.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int list = 0; list < forn.size(); list++) {
                if(forn.get(list).getEndereco().getIdEndereco() != 1){
                    forn.get(list).getEndereco().setIdEndereco(forn.get(list).getEndereco().getIdEndereco()-1);
                }
                if(forn.get(list).getContatos().getId() != 1){
                    forn.get(list).getContatos().setId(forn.get(list).getContatos().getId()-1);
                }
                forn.get(list).setId(list+1);
                printWriter.println(forn.get(list));
            }

            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
