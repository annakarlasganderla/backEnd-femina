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

    public void mostrarEnderecos() {
        System.out.println(enderecoController.listarEndereco());
    }

    public Endereco selectEnderecoById () {
        this.mostrarEnderecos();

        System.out.println("Selecione o endereço: ");
        int endSelecionado = leitor.nextInt();

        Endereco endereco = enderecoController.selectById(endSelecionado);

        System.out.println("O endereço selecionado foi: " + endereco);

        return endereco;
    }

    public void editarEndereco(Endereco endereco) {
        int op = 0;

        do {
            System.out.println("Escolha o endereço que você quer editar: ");
            System.out.println("|     1 - País              |");
            System.out.println("|     2 - Estado            |");
            System.out.println("|     3 - Cidade            |");
            System.out.println("|     4 - Rua               |");
            System.out.println("|     5 - Cep               |");
            System.out.println("|     6 - Número da casa    |");

            int selecionaAtributo = leitor.nextInt();

            switch (selecionaAtributo) {
                case 1:
                    System.out.println("Digite o país");
                    endereco.setPais(leitor.next());
                    break;

                case 2:
                    System.out.println("Digite o estado");
                    endereco.setEstado(leitor.next());
                    break;

                case 3:
                    System.out.println("Digite a cidade");
                    endereco.setCidade(leitor.next());
                    break;

                case 4:
                    System.out.println("Digite o rua");
                    endereco.setRua(leitor.next());
                    break;

                case 5:
                    System.out.println("Digite o cep");
                    endereco.setCep(leitor.next());
                    break;

                case 6:
                    System.out.println("Digite o número da casa");
                    endereco.setNumCasa(leitor.nextInt());
                    break;

                default:
                    System.out.println("Opção invalida");
            }

            System.out.println("Deseja continuar? 1 - Sim | 0 - Não");
            op = leitor.nextInt();

        } while (op != 0);

        System.out.println("Endereço editado com sucesso!");
        enderecoController.editarEndereco(endereco);
    }

    public void deletarEndereco(Endereco endereco) {
        int op;

        System.out.println("Tem certeza que deseja deletar o endereço? 1 - Sim | 0 - Não");
        op = leitor.nextInt();

        switch (op) {
            case 1:
                enderecoController.deletarEndereco(endereco);
                break;

            default:
                System.out.println("Opção invalida");
        }

        System.out.println("Endereço deletado com sucesso!");

    }

}