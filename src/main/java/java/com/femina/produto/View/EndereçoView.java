package main.java.com.femina.produto.View;

import main.java.com.femina.produto.Controller.ContatoController;
import main.java.com.femina.produto.Controller.EnderecoController;
import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;

import java.io.*;
import java.util.*;

public class EndereçoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public Endereco cadastraEndereco(String arq) throws IOException{

        System.out.println("Digite o seu pais");
        String pais= leitor.next();

        System.out.println("Digite o seu estado:");
        String estado = leitor.next();

        System.out.println("Digite sua cidade: ");
        String cidade  = leitor.next();

        System.out.println("Digite sua Rua");
        String rua = leitor.next();

        System.out.println("Digite o seu cep:");
        String cep = leitor.next();

        System.out.println("Digite o numero da sua casa: ");
        int numCasa  = leitor.nextInt();

        Endereco endereco = new Endereco(pais, estado, cidade, rua, cep,numCasa);

        EnderecoController enderecoController = new EnderecoController();
        List<Endereco> listaEndereco = enderecoController.mostraEndereco(arq);
        listaEndereco.add(endereco);
        enderecoController.cadastraEndereco(listaEndereco,arq);

        return endereco;
    }

    public void mostraEndereco(String arq)throws IOException{

        EnderecoController cc = new EnderecoController();
        List<Endereco> listaEndereco = cc.mostraEndereco(arq);

        for(int i = 0; i < listaEndereco.size(); i++) {
            System.out.println(listaEndereco.get(i));
        }

    }

    public void editEndereco(int opProduto,String arq) throws IOException{

        EnderecoController enderecoController = new EnderecoController();

        List<Endereco> listaEndereco = enderecoController.mostraEndereco(arq);

        System.out.println("Escolha qual atributo você quer editar: ");

        System.out.println(" 1 - pais");
        System.out.println(" 2 - estado");
        System.out.println(" 3 - cidade");
        System.out.println(" 4 - rua");
        System.out.println(" 5 - cep");
        System.out.println(" 6 - Numero da minha casa");

        int opAtributo = leitor.nextInt();

        switch (opAtributo) {
            case 1:
                listaEndereco.get(opProduto - 1).setPais(leitor.next());
                break;

            case 2:
                listaEndereco.get(opProduto - 1).setEstado(leitor.next());
                break;

            case 3:
                listaEndereco.get(opProduto - 1).setCidade(leitor.next());
                break;

            case 4:
                listaEndereco.get(opProduto - 1).setRua(leitor.next());
                break;


            case 5:
                listaEndereco.get(opProduto - 1).setCep(leitor.next());
                break;

            case 6:
                listaEndereco.get(opProduto - 1).setNumCasa(leitor.nextInt());
                break;

            default:
                System.out.println("Opção inválida");
        }

        enderecoController.editaEndereco(listaEndereco,arq);

    }

    public void deletEndereco(int opDelete,String arq) throws IOException {

        EnderecoController enderecoController = new EnderecoController();

        List<Endereco> listaEndereco = enderecoController.mostraEndereco(arq);

        listaEndereco.remove(opDelete - 1);

        enderecoController.deletaEndereco(listaEndereco,arq);
        System.out.print(".");
    }

}