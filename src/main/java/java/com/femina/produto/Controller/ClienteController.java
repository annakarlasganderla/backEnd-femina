package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.ClienteDao;
import java.com.femina.produto.Model.Cliente;
import java.util.*;

public class ClienteController {

    public void cadastrarCliente(Cliente cliente){
        ClienteDao cd = new ClienteDao();
        cd.cadastrarCliente(cliente);
    }

//    public List<Cliente> listarClientes(){
//        ClienteDao cd = new ClienteDao();
//        List<Cliente> ldc = cd.listarCliente();
//        return ldc;
//    }
//
//    public void editarCliente(Cliente ldc){
//        ClienteDao cd = new ClienteDao();
//        cd.editarCliente(ldc);
//    }
//
//    public void deletarCliente(Cliente ldc){
//        ClienteDao cd = new ClienteDao();
//        cd.deletarCliente(ldc);
//    }

}
