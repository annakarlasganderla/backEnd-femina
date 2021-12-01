package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.ClienteDao;
import java.com.femina.produto.Model.Cliente;
import java.util.*;

public class ClienteController {

    public ClienteController() {
        this.criarTabela();
    }

    public void criarTabela(){
        ClienteDao cd = new ClienteDao();
        cd.criarTabelaClientes();
    }

    public void cadastrarCliente(Cliente cliente){
        ClienteDao cd = new ClienteDao();
        cd.cadastrarCliente(cliente);
    }

    public List<Cliente> listarClientes(){
        ClienteDao cd = new ClienteDao();
        return cd.listarClientes();
    }

    public Cliente selectById(int id){
        ClienteDao cd = new ClienteDao();
        return cd.selectById(id);
    }

    public void editarCliente(Cliente cliente){
        ClienteDao cd = new ClienteDao();
        cd.editarCliente(cliente);
    }

    public void deletarCliente(Cliente cliente){
        ClienteDao cd = new ClienteDao();
        cd.deletarCliente(cliente);
        ContatoController cc = new ContatoController();
        cc.deletaContato(cliente.getContatos());
        EnderecoController ec = new EnderecoController();
        ec.deletarEndereco(cliente.getEndereco());
    }

}


