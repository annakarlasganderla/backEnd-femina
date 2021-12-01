package Dao;

import Factory.ConectionFactory;
import Model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    private static Connection connection;

    public CargoDAO() {
        this.connection = ConectionFactory.getConection();
        this.createTable();
    }

    public void createTable(){

        String sqlCreate = "CREATE TABLE IF NOT EXISTS `cargos` (\n" +
                "idCargo INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    nomeCargo VARCHAR(244)\n" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void cadastrarCargo(Cargo cargo){
        String sqlInsert = "INSERT INTO cargos (nomeCargo) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, cargo.getCargo());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deletarCargo(int idDelete){

        String sqlDel = "DELETE FROM cargo WHERE idCargo = " + idDelete;
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

    public List<Cargo> listarCargos(){
        Cargo cargo = new Cargo();
        List<Cargo> retornoBanco = new ArrayList<>();

        String sqlSelect = "SELECT * FROM cargos";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                cargo.setIdCargo(resultSet.getInt("idCargo"));
                cargo.setCargo(resultSet.getString("nomeCargo"));
                retornoBanco.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retornoBanco;
    }

    public Cargo getCargoById(int id){

        Cargo cargo = new Cargo();

        String sqlGetById = "SELECT idCargo, nomeCargo FROM cargos WHERE idCargo = "+id;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetById);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                cargo.setIdCargo(resultSet.getInt("idCargo"));
                cargo.setCargo(resultSet.getString("nomeCargo"));
            }
            System.out.println(cargo);
            return cargo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

