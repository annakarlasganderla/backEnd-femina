package Dao;

import Factory.ConectionFactory;
import Model.Funcionarios;
import Model.FuncionariosAux;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionariosDAO {

    private static Connection connection;
    Funcionarios funcionario = new Funcionarios();
    CargoDAO cargoDAO = new CargoDAO();
    EnderecoDao enderecoDao = new EnderecoDao();
    LojasDAO lojaDAO = new LojasDAO();

    public FuncionariosDAO() {
        this.connection = ConectionFactory.getConection();
    }

    public void creatTable(){

        String sqlCreat = "CREATE TABLE IF NOT EXISTS funcionarios (" +
                "    idFuncionarios INT PRIMARY KEY AUTO_INCREMENT," +
                "    nome VARCHAR(244)," +
                "    idCargo INT," +
                "    idEndereco INT," +
                "    idLoja INT," +
                "    UNIQUE(idLoja));";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreat);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarFuncionario(Funcionarios funcionario){

        String sqlInsert = "INSERT INTO funcionarios (nome, idCargo, idEndereco, idEmpresa) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setInt(2, funcionario.getCargo().getIdCargo());
            preparedStatement.setInt(3, funcionario.getEndereco().getIdEndereco());
            preparedStatement.setInt(4, funcionario.getLoja().getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deletarFuncionario(int idDelete){

        String sqlDel = "DELETE FROM funcionarios WHERE idFuncionarios = " + idDelete;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDel);
            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Funcionarios> listarFuncionariosDoBanco(){
        String sqlSelect = "SELECT * FROM funcionarios";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Funcionarios> retornoBanco = new ArrayList<>();
            Funcionarios funcionario = new Funcionarios();

            while(resultSet.next()){
                funcionario.setId(resultSet.getInt("idFuncionarios"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCargo(cargoDAO.getCargoById(resultSet.getInt("idCargo")));
                funcionario.setEndereco(enderecoDao.selectEnderecoById(resultSet.getInt("idCargo")));
                funcionario.setLoja(lojaDAO.selectLojaById(resultSet.getInt("idLoja")));
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FuncionariosAux listarFuncionariosIdLoja(int idSelect){
        String sqlSelect = "SELECT * FROM funcionarios WHERE idLoja = " + idSelect;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Funcionarios> retornoBanco = new ArrayList<>();
            FuncionariosAux funcionariosAux = new FuncionariosAux();
            Funcionarios funcionario = new Funcionarios();

            while(resultSet.next()){
                funcionario.setId(resultSet.getInt("idFuncionarios"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCargo(cargoDAO.getCargoById(resultSet.getInt("idCargo")));
                funcionario.setEndereco(enderecoDao.selectEnderecoById(resultSet.getInt("idCargo")));
                funcionario.setLoja(lojaDAO.selectLojaById(resultSet.getInt("idLoja")));
            }
            funcionariosAux.setProdutosList(retornoBanco);
            return funcionariosAux;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Funcionarios> listFuncionariosId(int idFunc){
        String sqlSelect = "SELECT nome, cargo FROM funcionarios WHERE id = " + idFunc;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Funcionarios> retornoBanco = new ArrayList<>();
            Funcionarios funcionario = new Funcionarios();
            while(resultSet.next()){
                funcionario.setId(resultSet.getInt("idFuncionarios"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCargo(cargoDAO.getCargoById(resultSet.getInt("idCargo")));
                funcionario.setEndereco(enderecoDao.selectEnderecoById(resultSet.getInt("idCargo")));
                funcionario.setLoja(lojaDAO.selectLojaById(resultSet.getInt("idLoja")));
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
