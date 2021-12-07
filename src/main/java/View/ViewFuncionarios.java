package View;

import Controller.EnderecoController;
import Controller.FuncionariosController;
import Model.Endereco;
import Model.Funcionarios;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ViewFuncionarios {
    CargosView cargosView = new CargosView();
    LojasView lojasView = new LojasView();
    EndereçoView endereçoView = new EndereçoView();
    EnderecoController enderecoController = new EnderecoController();
    public void mostrarFuncionarios() throws IOException {

        FuncionariosController funcionariosController = new FuncionariosController();

        List<Funcionarios> listaDeFuncionarios = funcionariosController.listarFuncionarios();

        System.out.println(listaDeFuncionarios);
    }

    public void cadastrarFuncionarios() throws IOException {

        Scanner entrada = new Scanner(System.in);
        Funcionarios funcionario = new Funcionarios();
        FuncionariosController funcionariosController = new FuncionariosController();

        System.out.println("Nome: ");
        funcionario.setNome(entrada.next());

        System.out.println("Cargo: ");
        funcionario.setCargo(cargosView.selectCargo());

        funcionariosController.cadastrarFuncionario(funcionario);

        System.out.println("Cadastro de funcionario realizado com sucesso!");
    }

    public void editFuncionarios() throws IOException {

        Scanner entrada = new Scanner(System.in);

        FuncionariosController funcionariosController = new FuncionariosController();

        List<Funcionarios> listaFuncionarios = funcionariosController.listarFuncionarios();

        System.out.println(listaFuncionarios);

        System.out.println("Escolha o funcionario que deseja editar.");
        int editFunc = entrada.nextInt();

        System.out.println("1 - Editar valores \n2 - Excluir\n0 - Voltar");
        int escolha = entrada.nextInt();

        switch (escolha){

            case 1:

                System.out.println("Qual valor deseja editar?");
                System.out.println("1 - Nome\n2 - Cargo\n 3 - Endereço\n4 - Empresa");
                int valorEdit = entrada.nextInt();

                switch (valorEdit){

                    case 1:
                        System.out.println("Digite o novo nome:");
                        String nome = entrada.next();
                        listaFuncionarios.get(editFunc-1).setNome(nome);
                        break;
                    case 2:
                        System.out.println("Escolha o novo cargo:");
                        listaFuncionarios.get(editFunc-1).setCargo(cargosView.selectCargo());
                        break;
                    case 3:
                        Endereco endereco = enderecoController.selectById(listaFuncionarios.get(editFunc-1).getEndereco().getIdEndereco());
                        endereçoView.editarEndereco(endereco);
                        break;
                    case 4:
                        System.out.println("Digite a nova empresa:");
                        listaFuncionarios.get(editFunc-1).setLoja(lojasView.selectLojaById());
                        break;
                }
                break;
            case 2:
                FuncionariosController funcionariosController1 = new FuncionariosController();
                funcionariosController1.deletarFuncionarios(editFunc-1);
                break;
            case 0:
                editFuncionarios();
                break;
        }

        System.out.println("Lista editada com sucesso!\n" + listaFuncionarios);
    }

    public void menuFuncionario() throws IOException {
        Scanner leitor = new Scanner(System.in);
        int op = 0;
        char control = 's';
        FuncionariosController funcionariosController = new FuncionariosController();
        funcionariosController.criaTabelaFuncionarios();

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
                        this.cadastrarFuncionarios();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.mostrarFuncionarios();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editFuncionarios();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    // deletar funcionarios
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
