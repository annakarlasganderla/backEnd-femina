package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.FuncionariosDAO;
import java.com.femina.produto.Model.Funcionarios;
import java.io.IOException;
import java.util.List;

public class FuncionariosController {

    FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

    public void cadastrarFuncionario(Funcionarios funcionarios){
        funcionariosDAO.cadastrarFuncionario(funcionarios);
    }

    public List<Funcionarios> listarFuncionarios(){
        return funcionariosDAO.listarFuncionariosDoBanco();
    }

    public void deletarFuncionarios(int idDelete){
        funcionariosDAO.deletarFuncionario(idDelete);
    }

    public List<Funcionarios> listarFuncionariosById(int idTam){
        return funcionariosDAO.listFuncionariosId(idTam);
    }


}
