package View;

import Controller.CorController;
import Model.Cor;
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

        cc.criaCor(cor);
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
                break;

            default:
                System.out.println("Opção invalida");
        }

        System.out.println("Produto deletado com sucesso!");
    }
}
