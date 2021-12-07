package View;

import Controller.ProdutoController;
import Model.Contatos;


import Controller.ClienteController;
import Model.Cliente;
import Model.Endereco;
import java.util.*;

public class ClienteView {

    ClienteController clienteController = new ClienteController();

    public void cadastrarCliente() {

        ClienteController cc = new ClienteController();
        ContatoView cv = new ContatoView();
        EndereçoView ev = new EndereçoView();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        Cliente cliente = new Cliente();

        System.out.println("Informe o seu nome");
        cliente.setNome(entrada.next());

        System.out.println("Informe a sua idade");
        cliente.setIdade(entrada.nextInt());

        Contatos contato = cv.cadastraContato();
        cliente.setContatos(contato);

        Endereco endereco = ev.cadastraEndereco();
        cliente.setEndereco(endereco);

        System.out.println("Informe a sua Senha");
        cliente.setSenha(entrada.next());

//        System.out.println("Confirme sua senha");

        cc.cadastrarCliente(cliente);
        System.out.println("Cadastrado com Sucesso!");
    }

    public Cliente loginCliente(){

        ClienteController cc = new ClienteController();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        while(true) {
            System.out.print("NOME: ");
            String nome = entrada.next();

            System.out.print("SENHA: ");
            String senha = entrada.next();

            if(cc.userExist(nome) == false){
                System.out.println("Usuário Não Existe!");
            } else {
                if(cc.logar(nome,senha) != null){
                    Cliente cliente = cc.logar(nome,senha);
                    System.out.println("Logado Com sucesso!");
                    System.out.println("Seja Bem Vindo!");
                    return cliente;
                } else {
                    System.out.println("Login Inválido!");
                }
            }
        }

    }

    public List<Cliente> listarClientes(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        ClienteController cc = new ClienteController();
        List<Cliente> ldc = cc.listarClientes();

        if(ldc.isEmpty()){
            System.out.println("Nenhum Cliente cadastrado!");
            System.out.println("Deseja Cadastrar?");
            System.out.println("1-Sim;     2-Não;");
            switch (entrada.nextInt()){
                case 1:
                    this.cadastrarCliente();
                    break;
                case 2:
                    System.out.println("Voltando pro menu!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("CLIENTES: \n");
            for (int i = 0; i < ldc.size(); i++) {
                System.out.println((i + 1) + " - " + ldc.get(i).toString());
            }
        }
        return ldc;
    }

    public Cliente selectClienteById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ClienteController cc = new ClienteController();

        System.out.println("Selecione o Cliente:");
        List<Cliente> listaCliente = this.listarClientes();

        if(listaCliente.isEmpty()){
            System.out.println("Nenhum Cliente Cadastrado!");
            System.out.println("Cadastre um!");
            this.cadastrarCliente();
        }

        System.out.println("Escolha o cliente: ");

        Cliente cliente = cc.selectById(listaCliente.get(entrada.nextInt()-1).getId());

        System.out.println("-------------------------------");
        System.out.println("Cliente Selecionado: ");
        System.out.println(cliente.toString());
        System.out.println("-------------------------------");

        return cliente;

    }

    public void perfilCliente(Cliente cliente){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        int op = 1;

        System.out.println("----------------------------------");
        System.out.println("|             PERFIL             |");
        System.out.println("----------------------------------");
        System.out.println("  NOME:  " + cliente.getNome()     );
        System.out.println("  IDADE:  " +cliente.getIdade()    );
        System.out.println("  ENDEREÇO:  " + cliente.getEndereco());
        System.out.println("  CONTATOS:  " + cliente.getContatos());
        System.out.println("----------------------------------");

        while (op != 0) {
            System.out.println("Deseja editar?");
            System.out.println("1-SIM    2-NÃO");
            op = entrada.nextInt();
            switch (op){
                case 1:
                    this.editarClientes(cliente);
                    break;
                case 2:
                    op = 0;
                    break;
                case 0:
                    break;
            }
        }
    }

    public void editarClientes(Cliente cliente) {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ClienteController cc = new ClienteController();
        ContatoView contatoView = new ContatoView();
        EndereçoView enderecoView = new EndereçoView();

        System.out.println("EDITAR CLIENTE: \n");

        System.out.println("Selecione o que você quer editar!");
        System.out.println("1-Nome;2-Idade;3-Senha;4-Contato;5-Endereço");
        int selectItem = entrada.nextInt();
        switch (selectItem) {
            case 1:
                System.out.print("NOME: ");
                cliente.setNome(entrada.next());
                break;
            case 2:
                System.out.print("IDADE: ");
                cliente.setIdade(entrada.nextInt());
                break;
            case 3:
                System.out.print("NOVA SENHA: ");
                cliente.setSenha(entrada.next());
                break;
            case 4:
                contatoView.editarContatos(cliente.getContatos());
                break;
            case 5:
                enderecoView.editarEndereco(cliente.getEndereco());
                break;
            default:
                System.out.println("Opção Inválida");
        }

        cc.editarCliente(cliente);

        System.out.println("Cliente Editado!");
        System.out.println("Deseja Continuar?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                this.editarClientes(cliente);
                break;
            case 2:
                System.out.println("Retornando ao Menu");
                break;
            default:
                System.out.println("Opção invalida");
        }

    }

    public void deletarClientes() {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ClienteController cc = new ClienteController();

        System.out.println("DELETAR CLIENTE: \n");

        Cliente cliente = this.selectClienteById();

        System.out.println("Tem certeza que deseja deletar o cliente?");
        System.out.println("1-Sim;                            2-Não;");

        switch (entrada.nextInt()){
            case 1:
                cc.deletarCliente(cliente);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }

    public void clienteMenu() {

        Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        clienteController.criarTabela();
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
                        this.cadastrarCliente();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.listarClientes();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editarClientes(selectClienteById());
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    this.deletarClientes();
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
