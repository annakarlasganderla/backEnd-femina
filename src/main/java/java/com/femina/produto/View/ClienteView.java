package java.com.femina.produto.View;

import java.com.femina.produto.Controller.ClienteController;
import java.com.femina.produto.Model.Cliente;
import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Endereco;
import java.com.femina.produto.View.EndereçoView;

import java.io.IOException;
import java.util.*;

public class ClienteView {
    public void cadastro() throws IOException {

        ClienteController cc = new ClienteController();
        EndereçoView ev = new EndereçoView();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        Cliente cliente = new Cliente();

        System.out.println("Informe o seu nome");
        cliente.setNome(entrada.next());

        System.out.println("Informe a sua idade");
        cliente.setIdade(entrada.nextInt());

        System.out.println("Informe a sua Senha");
        cliente.setSenha(entrada.next());

        cc.cadastrarCliente(cliente);
    }
}