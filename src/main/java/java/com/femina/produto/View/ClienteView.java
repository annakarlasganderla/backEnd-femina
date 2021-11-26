package java.com.femina.produto.View;

import main.java.com.femina.produto.View.ContatoView;

import java.com.femina.produto.Controller.ClienteController;
import java.com.femina.produto.Model.Cliente;
import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Endereco;
import java.util.*;

public class ClienteView {
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

        return listarClientes();
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

    public void editarClientes() {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ClienteController cc = new ClienteController();
        ContatoView contatoView = new ContatoView();
        EndereçoView enderecoView = new EndereçoView();

        System.out.println("EDITAR CLIENTE: \n");

        Cliente cliente = this.selectClienteById();

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
                contatoView.editContato(cliente.getContatos());
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
                this.editarClientes();
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
}
