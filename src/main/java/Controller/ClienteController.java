package Controller;

import Dao.ClienteDao;
import Model.Cliente;
import Model.Contatos;

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

    public boolean userExist(String nome){
        ClienteDao cd = new ClienteDao();
        return cd.userExist(nome);
    }

    public Cliente logar(String nome, String senha){
        ClienteDao cd = new ClienteDao();
        return cd.logar(nome,senha);
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
