package java.com.femina.produto.View;

import java.com.femina.produto.Controller.EnderecoController;
import java.com.femina.produto.Model.Endereco;
import java.io.*;
import java.util.*;

public class EndereçoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    EnderecoController enderecoController = new EnderecoController();

    public void cadastraEndereco() {
        Endereco endereco = new Endereco();
        System.out.println("Informe o país: ");
        endereco.setPais(leitor.next());

        System.out.println("Informe o estado: ");
        endereco.setEstado(leitor.next());

        System.out.println("Informe a cidade: ");
        endereco.setCidade(leitor.next());

        System.out.println("Informe a rua: ");
        endereco.setRua(leitor.next());

        System.out.println("Informe o cep: ");
        endereco.setCep(leitor.next());

        System.out.println("Informe o número da casa:");
        endereco.setNumCasa(leitor.nextInt());

        enderecoController.criaTabelaEndereco(endereco);
        enderecoController.cadastraProduto(endereco);
    }


}