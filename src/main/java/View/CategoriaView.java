package View;

import Controller.CategoriaController;
import Model.Categoria;
import Model.Lojas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class CategoriaView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    CategoriaController categoriaController = new CategoriaController();

    public Categoria cadastraCategoria() {
        Categoria categoria = new Categoria();

        System.out.println("Informe o nome da categoria: ");
        categoria.setNome(leitor.next());

        categoriaController.criaTabelaCategoria();
        categoriaController.cadastraCategoria(categoria);
        return categoria;
    }

    public void mostrarCategorias() {
        System.out.println(categoriaController.listarCategorias());
    }

    public Categoria selectById () {
        this.mostrarCategorias();

        System.out.println("Selecione a categoria: ");
        int catSelecionada = leitor.nextInt();

        Categoria categoria = categoriaController.selectById(catSelecionada);

        System.out.println("A categoria selecionada foi: " + categoria);

        return categoria;
    }

    public void deletarCategoria (Categoria categoria) {
        int op;

        System.out.println("Tem certeza que deseja deletar a categoria? " + categoria.getNome() + " 1 - Sim | 0 - Não");
        op = leitor.nextInt();

        switch (op) {
            case 1:
                categoriaController.deletarCategoria(categoria);
                break;

            default:
                System.out.println("Opção invalida");
        }

        System.out.println("Categoria deletada com sucesso!");
    }

    public void menuCategoria(Lojas loja) throws SQLException, IOException {

        MenuView mv = new MenuView();

        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|            CATEGORIAS             |");
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Voltar                 |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Deletar                |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    mv.menuDeLoja(loja);
                    break;

                case 1:
                    do {
                        this.cadastraCategoria();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarCategorias();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.deletarCategoria(selectById());
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
