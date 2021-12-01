package Dao;

import Factory.ConectionFactory;
import Model.Tamanho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TamanhoDAO {

    private static Connection connection;

    public TamanhoDAO() {
        this.connection = ConectionFactory.getConection();
    }

    public void creatTable() {
        String sqlCreat = "CREATE TABLE IF NOT EXISTS tamanho(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "tam VARCHAR(10) NOT NULL," +
                "CONSTRAINT uni_Tam UNIQUE (tam)" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreat);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarTamanho(Tamanho tamanho) {
        String sqlInsert = "INSERT INTO tamanho" +
                " (tam) " +
                "VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, tamanho.getTam());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tamanho> listarTamanhos() {
        String sqlSelect = "SELECT * FROM tamanho";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Tamanho> retornoBanco = new ArrayList<>();
            Tamanho tamanho;

            while (resultSet.next()) {
                tamanho = new Tamanho();
                tamanho.setId(resultSet.getInt("id"));
                tamanho.setTam(resultSet.getString("tam"));
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Tamanho listTamanhosId(int idTam) {
        String sqlSelect = "SELECT id, tam FROM tamanho WHERE id = " + idTam;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            Tamanho tamanho = new Tamanho();

            while (resultSet.next()) {
                tamanho.setId(resultSet.getInt("id"));
                tamanho.setTam(resultSet.getString("tam"));
            }
            return tamanho;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deletaTamanho(Tamanho idTam) {
        String sqlDel = "DELETE FROM tamanho WHERE id=" + idTam.getId();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDel);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}