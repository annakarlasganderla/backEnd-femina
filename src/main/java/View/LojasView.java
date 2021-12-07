package View;

import Controller.LojasController;
import Model.Lojas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LojasView {

    Scanner entrada = new Scanner(System.in);
    Lojas lojas = new Lojas();
    EndereçoView endereçoView = new EndereçoView();
    LojasController lojasController = new LojasController();
    ContatoView contatoView = new ContatoView();

    public void cadastrarLoja(){
        System.out.println("Digite o nome da Loja:");
        lojas.setNome(entrada.next());
        System.out.println("Endereço:");
        lojas.setEndereco(endereçoView.cadastraEndereco());
        System.out.println("Contato:");
        lojas.setContatos(contatoView.cadastraContato());
        lojasController.cadastrarLojas(lojas);
    }

    public void verLojas(){

        System.out.println("Lojas cadastradas: ");
        List<Lojas> lojas = lojasController.listarTodasAsLojas();
        if(lojas.isEmpty()){
            System.out.println("Nenhuma loja cadastrada.");
        }else{
            int tamanhoLista = lojasController.listarTodasAsLojas().size();
            for(int i = 0; i < tamanhoLista; i++){
                System.out.println(lojasController.listarTodasAsLojas().get(i));
            }
        }
    }

    public void editarLojas(){
        System.out.println(lojasController.listarTodasAsLojas());
        System.out.print("Escolha a loja para editar:");
        int escolha = entrada.nextInt();
        System.out.println("Loja escolhida");
        System.out.println(lojasController.listarTodasAsLojas().get(escolha));
        System.out.println("O que deseja editar?");
        System.out.println("1 - Nome    2 - Endereço");
        System.out.println("3 - Contato");
        int editar = entrada.nextInt();
        switch (editar){
            case 1:
                lojasController.editarNomeLoja(lojasController.listarTodasAsLojas().get(escolha), lojasController.listarTodasAsLojas().get(escolha).getId());
                break;
            case 2:
                endereçoView.editarEndereco(lojasController.listarTodasAsLojas().get(escolha).getEndereco());
                break;
            case 3:
                contatoView.editarContatoLoja(lojasController.selectLojaById(escolha).getContatos());
                break;
        }
    }

    public void excluirLojas(){
        Scanner entrada = new Scanner(System.in);
        List<Lojas> listaDeLojas = lojasController.listarTodasAsLojas();
        System.out.println(listaDeLojas);
        System.out.println("Escolha  a loja a ser deletada:");
        int lojaEscolhida = entrada.nextInt();
        lojasController.deleteLoja(listaDeLojas.get(lojaEscolhida).getId());
    }

    public Lojas selectLojaById(){

        this.verLojas();

        System.out.println("Selecione uma Loja");
        Lojas loja = lojasController.selectLojaById(entrada.nextInt());

        System.out.println("A loja seleciona foi:");
        System.out.println(loja.toString());

        return loja;
    }

    public Lojas acessarLoja() throws IOException, SQLException {

        Lojas lojas = this.selectLojaById();
        MenuView menuView = new MenuView();

        menuView.menuDeLoja(lojas);
        return lojas;
    }

    public void menuEndereco() {
        int op = 0;
        char control = 's';
        lojasController.criaTabelaLoja();

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Editar                 |");
                System.out.println("|        4 - Deletar                |");
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
                        this.cadastrarLoja();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = entrada.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 2:
                    this.verLojas();
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 3:
                    this.editarLojas();
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 4:
                    this.excluirLojas();
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
