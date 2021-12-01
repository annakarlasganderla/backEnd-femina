package java.com.femina.produto.Dao;

import java.com.femina.produto.Dao.CargoDAO;
import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Funcionarios;
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
    LojaDAO lojaDAO = new LojaDAO();

    public FuncionariosDAO() {
        this.connection = ConectionFactory.getConection();
    }

    public void creatTable(){

        String sqlCreat = "CREATE TABLE IF NOT EXISTS funcionarios (" +
                "    idFuncionarios INT PRIMARY KEY AUTO_INCREMENT," +
                "    nome VARCHAR(244)," +
                "    idCargo INT," +
                "    idEndereco INT," +
                "    idLoja INT UNIQUE);";
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
//            preparedStatement.setInt(4, funcionario.getEmpresa().getId());
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
            System.out.println(funcionario);
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Funcionarios> listFuncionariosId(int idTam){
        String sqlSelect = "SELECT nome, cargo FROM funcionarios WHERE id = " + idTam;
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
