package Controller;

import Dao.FuncionariosDAO;
import Model.Funcionarios;

import java.util.List;

public class FuncionariosController {

    FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

    public void cadastrarFuncionario(Funcionarios funcionario){
        funcionariosDAO.cadastrarFuncionario(funcionario);
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
