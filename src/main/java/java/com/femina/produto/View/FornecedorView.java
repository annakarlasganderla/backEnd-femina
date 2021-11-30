package java.com.femina.produto.View;

import java.com.femina.produto.Controller.FornecedorController;
import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Endereco;
import java.com.femina.produto.Model.Fornecedor;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FornecedorView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    FornecedorController fornecedorController = new FornecedorController();

    ContatoView contatoView = new ContatoView();
    EndereçoView endereçoView = new EndereçoView();

    public void cadastrarFornecedor() {
        Fornecedor fornecedor = new Fornecedor();

        System.out.println("Informe o nome do fornecedor: ");
        fornecedor.setNomeFornecedor(leitor.next());

        System.out.println("Informe o cnpj do fornecedor: ");
        fornecedor.setCnpjFornecedor(leitor.next());

        Contatos contatos = contatoView.cadastraContato();
        fornecedor.setContatoFornecedor(contatos);

        Endereco endereco = endereçoView.cadastraEndereco();
        fornecedor.setEnderecoFornecedor(endereco);

        fornecedorController.criarTabela();
        fornecedorController.cadastrarFornecedor(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {

        List<Fornecedor> listaDeFornecedores = fornecedorController.listarFornecedores();

        if(listaDeFornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastro!");
            System.out.println("Deseja cadastrar?");
            System.out.println("1 - Sim | 2 - Não");
            switch (leitor.nextInt()) {
                case 1:
                    this.cadastrarFornecedor();
                    break;

                case 2:
                    System.out.println("Voltando para o menu!");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } else {
            System.out.println("-- Fornecedores --");
            for(int i = 0; i < listaDeFornecedores.size(); i++) {
                System.out.println((i + 1) + " - " + listaDeFornecedores.get(i).toString());
            }
        }

        return listaDeFornecedores;
    }

    public Fornecedor selectFornecedorById() {
        System.out.println("Selecione o fornecedor: ");
        List<Fornecedor> listaDeFornecedores = this.listarFornecedores();

        if(listaDeFornecedores.isEmpty()) {
            System.out.println("Nenhum fornecedor cadastrado");
            System.out.println("Deseja cadastrar?");
            System.out.println("1 - Sim | 2 - Não");
            switch (leitor.nextInt()) {
                case 1:
                    this.cadastrarFornecedor();
                    break;

                case 2:
                    System.out.println("Voltando para o menu!");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        System.out.println("Escolha o fornecedor: ");

        Fornecedor fornecedor = fornecedorController.selectFornecedorById(listaDeFornecedores.get(leitor.nextInt() - 1).getIdFornecedor());
        System.out.println("Fornecedor selecionado -> " + fornecedor.getNomeFornecedor());

        return fornecedor;
    }

    public void editarFornecedor(Fornecedor fornecedor) {

        System.out.println("Selecione o que você quer editar: ");
        System.out.println("|     1 - Nome            |");
        System.out.println("|     2 - Cnpj            |");
        System.out.println("|     3 - Contato         |");
        System.out.println("|     4 - Endereço        |");
        int selectForn = leitor.nextInt();

        switch (selectForn) {
            case 1:
                System.out.println("Nome: ");
                fornecedor.setNomeFornecedor(leitor.next());
                break;

            case 2:
                System.out.println("Fornecedor: ");
                fornecedor.setCnpjFornecedor(leitor.next());
                break;

            case 3:
                contatoView.editarContatos(fornecedor.getContatoFornecedor());
                break;

            case 4:
                endereçoView.editarEndereco(fornecedor.getEnderecoFornecedor());
                break;

            default:
                System.out.println("Opção inválida");
        }

        fornecedorController.editarFornecedor(fornecedor);

        System.out.println("Fornecedor Editado!");
        System.out.println("Deseja Continuar?");
        System.out.println("1-Sim;2-Não;");

        switch (leitor.nextInt()){
            case 1:
                this.editarFornecedor(fornecedor);
                break;
            case 2:
                System.out.println("Retornando ao Menu");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }

    public void deletarFornecedor() {
        Fornecedor fornecedor = this.selectFornecedorById();

        System.out.println("Tem certeza que deseja deletar esse fornecedor?");
        System.out.println(" 1 - Sim | 2 - Não");

        switch (leitor.nextInt()) {
            case 1:
                fornecedorController.deletarFornecedor(fornecedor);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");

        }
    }

    public void menuFornecedor() {
        int op = 0;
        char control = 's';

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
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastrarFornecedor();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.listarFornecedores();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editarFornecedor(selectFornecedorById());
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    this.deletarFornecedor();
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
