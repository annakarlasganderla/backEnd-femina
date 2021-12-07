package View;

import Controller.TamanhoController;
import Dao.TamanhoDAO;

import Model.Cor;
import Model.Produto;
import Model.Tamanho;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TamanhoView {

    Scanner entrada = new Scanner(System.in);
    TamanhoController tamanhoController = new TamanhoController();
    List<Tamanho> tamanhos = new ArrayList<>();

    public void cadastrarTamanho(){
        Tamanho tamanho = new Tamanho();
        System.out.println("Tamanho:");
        String tamanhoValue = entrada.next();
        tamanho.setTam(tamanhoValue.toUpperCase(Locale.ROOT));
        tamanhos.add(tamanho);
        tamanhoController.cadastrarTamanho(tamanho);
    }

    public List<Tamanho> mostrarTamanho(){
        List<Tamanho> listaTamanhos = tamanhoController.listarTamanho();

        for(int i = 0;i < listaTamanhos.size();i++){
            System.out.println(listaTamanhos.get(i).toString());
        }

        return listaTamanhos;
    }

    public Tamanho selectTamanhoProdutoId(Produto produto){

        List<Tamanho> listTamanho = tamanhoController.listarTamanhoProduto(produto);

        for(int i = 0; i < listTamanho.size();i++){
            System.out.println(listTamanho.get(i).toString());
        }

        System.out.println("Selecione o Tamanho: ");
        int tamanhoSelecionado = entrada.nextInt();

        Tamanho tamanho = tamanhoController.listarTamanhosPeloIdProd(listTamanho.get(tamanhoSelecionado-1).getId());

        System.out.println("O Tamanho selecionado foi " + tamanho);

        return tamanho;

    }

    public Tamanho listarTamanhosDoProduto() throws IOException {

        System.out.println("Selecione um tamanho:");
        List<Tamanho> listaTamanho = this.mostrarTamanho();
        Tamanho tamanho = tamanhoController.listarTamanhosPeloIdProd(listaTamanho.get(entrada.nextInt()-1).getId());
        System.out.println("O tamanho seleciona foi:");
        System.out.println(tamanho);
        return tamanho;
    }

    public void deletarTamanho() throws IOException {
        Tamanho idProd = this.listarTamanhosDoProduto();
        int op;

        System.out.println("Tem certeza que deseja deletar este Tamanho? 1 - Sim | 0 - Não");
        op = entrada.nextInt();

        switch (op) {
            case 1:
                tamanhoController.deletaTamanho(idProd);
                break;

            default:
                System.out.println("Opção invalida");
        }

    }

    public void menuTamanho() throws IOException {
        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|              Tamanho              |");
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Deletar                |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = entrada.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastrarTamanho();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = entrada.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 2:
                    this.mostrarTamanho();
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 3:
                    this.deletarTamanho();
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida");
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;
            }

        } while (op != 0);

    }
}