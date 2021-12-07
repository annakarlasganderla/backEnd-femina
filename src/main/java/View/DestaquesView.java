package View;

import Controller.DestaquesController;
import Model.Destaques;
import Model.Lojas;
import Model.Produto;
import Model.ProdutoDestaque;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DestaquesView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n");
    ProdutoView pv = new ProdutoView();
    DestaquesController destaquesController = new DestaquesController();

    public void cadastroDeDestaque(Lojas loja) throws SQLException, IOException {

        DestaquesController dc = new DestaquesController();
        dc.criaTabelaDestaque();

        int op = 1;

        ProdutoDestaque produtoDestaque = new ProdutoDestaque();

        System.out.println("Digite o Nome da coleção de destaque: ");
        String nome = leitor.next();
        Destaques destaques = new Destaques(nome);

        System.out.println("Digite o id dos produtos dessa coleção ");

        while (op != 0) {
            Produto produtos = pv.retornaById(loja);
            produtoDestaque.getProdutos().add(produtos);
            System.out.println("Deseja Selecionar mais um produto para essa colecão ?");
            System.out.println("1 - SIM;                                 0 - NÃO;");
            op = leitor.nextInt();
        }

        destaques.setProdutoDestaque(produtoDestaque);

        dc.cadastraDestaque(destaques);
    }

    public void menuDestaque() {
        int op = 0;
        char control = 's';

        destaquesController.criaTabelaDestaque();


        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastroDeDestaque();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarEnderecos();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editarEndereco(selectEnderecoById());
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    this.deletarEndereco(selectEnderecoById());
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida");
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;
            }

        } while (op != 0);

    }

}