//package main.java.com.femina.produto.Controller;
//
//import main.java.com.femina.produto.Dao.ClienteDao;
//import main.java.com.femina.produto.Model.Cliente;
//
//import java.util.*;
//
//public class ClienteController {
//
//    public void cadastrarCliente(List<Cliente> cliente){
//        ClienteDao cd = new ClienteDao();
//        cd.gravarCliente(cliente);
//    }
//
//    public List<Cliente> listarClientes(){
//        ClienteDao cd = new ClienteDao();
//        List<Cliente> ldc = cd.retornaCliente();
//        return ldc;
//    }
//
//    public void editarCliente(List<Cliente> ldc){
//        ClienteDao cd = new ClienteDao();
//        cd.editCliente(ldc);
//    }
//
//    public void removerCliente(List<Cliente> ldc){
//        ClienteDao cd = new ClienteDao();
//        cd.delCliente(ldc);
//    }
//
//}
