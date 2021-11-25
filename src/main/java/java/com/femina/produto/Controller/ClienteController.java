package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.ClienteDao;
import java.com.femina.produto.Model.Cliente;
import java.util.*;

public class ClienteController {

    public void cadastrarCliente(Cliente cliente){
        ClienteDao cd = new ClienteDao();
        cd.cadastrarCliente(cliente);
    }

}