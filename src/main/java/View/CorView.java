package View;

import Controller.CorController;
import Model.Cor;
import Model.Produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class CorView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);;
    CorController cc = new CorController();

    public void cadastraCor()throws SQLException,IOException{
        Cor cor = new Cor();

        System.out.println("Informe a cor:");
        cor.setNome(leitor.next());

        System.out.println("Informe o Hexadecimal:");
        cor.setHexadecimal(leitor.next());
        cc.cadastraCor(cor);
    }
    public void mostrarCores() throws SQLException, IOException {
        System.out.println(cc.listarCores());
    }

    public Cor selecionaCoresById() throws SQLException, IOException {
        this.mostrarCores();

        System.out.println("Selecione a Cor: ");
        int corSelecionada = leitor.nextInt();

        Cor cor = cc.selecionaCor(corSelecionada);

        System.out.println("A cor selecionada foi " + cor);

        return cor;
    }

    public void editarCor(Cor cor) throws SQLException {
        int op = 0;

        do {
            System.out.println("Escolha o que você quer editar: ");
            System.out.println("| 1 - Nome |");
            System.out.println("| 2 - Hexadecimal |");

            int selecionaAtributo = leitor.nextInt();

            switch (selecionaAtributo) {
                case 1:
                    System.out.println("Digite o novo nome: ");
                    cor.setNome(leitor.next());
                    break;

                case 2:
                    System.out.println("Digite o novo Hexadecimal: ");
                    cor.setHexadecimal(leitor.next());
                    break;

                default:
                    System.out.println("Opção invalida");
            }

            System.out.println("Deseja continuar? 1 - Sim | 0 - Não");
            op = leitor.nextInt();

        } while (op != 0);

        System.out.println("Cor editada com sucesso!");
        cc.editarCor(cor);
    }

    public void deletarCor(Cor cor) {
        int op;

        System.out.println("Tem certeza que deseja deletar está Cor? 1 - Sim | 0 - Não");
        op = leitor.nextInt();

        switch (op) {
            case 1:
                cc.deletaCor(cor);
                System.out.println("Produto deletado com sucesso!");
                break;

            default:
                System.out.println("Opção invalida");
        }
    }

    public Cor selectCorProdutoId(Produto produto){

        List<Cor> listCor = cc.listarCoresProduto(produto);

        for(int i = 0; i < listCor.size();i++){
            System.out.println(listCor.get(i).toString());
        }

        System.out.println("Selecione a Cor: ");
        int corSelecionada = leitor.nextInt();

        Cor cor = cc.selecionaCor(listCor.get(corSelecionada-1).getId());

        System.out.println("A cor selecionada foi " + cor);

        return cor;

    }

    public void menuCor() throws SQLException, IOException {
        int op = 0;
        char control = 's';
        cc.criaCor();

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|              CORES                |");
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Editar                 |");
                System.out.println("|        4 - Deletar                |");
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
                        this.cadastraCor();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarCores();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editarCor(selecionaCoresById());
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    this.deletarCor(selecionaCoresById());
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
