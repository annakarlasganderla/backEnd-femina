package Dao;

import Factory.ConectionFactory;

import Model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    private Connection conection;

    public CategoriaDao() {
        this.conection = new ConectionFactory().getConection();
    }

    public void criaTabelaCategoria() {
        String sql = "CREATE TABLE IF NOT EXISTS categoria (" +
                "idCategoria INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeCategoria VARCHAR(50) NOT NULL);";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastraCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria" +
                "(nomeCategoria)" +
                "VALUES (?)";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,categoria.getNome());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();
            while(resultSet.next()) {
                categoria.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> listarCategorias() {
        String sql = "SELECT * FROM categoria";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Categoria> listaDeCategorias = new ArrayList<>();

            while(resultSet.next()) {
                Categoria categoria = new Categoria();

                categoria.setId(resultSet.getInt("idCategoria"));
                categoria.setNome(resultSet.getString("nomeCategoria"));

                listaDeCategorias.add(categoria);
            }

            return listaDeCategorias;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Categoria selectById(int id) {
        String sql = "SELECT * FROM categoria WHERE idCategoria = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                Categoria categoria = new Categoria();

                categoria.setId(resultSet.getInt("idCategoria"));
                categoria.setNome(resultSet.getString("nomeCategoria"));

                return categoria;
            }
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deletarCategoria(Categoria categoria) {
        String sql = "DELETE FROM categoria WHERE idCategoria = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);

            stmt.setInt(1,categoria.getId());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
