package Dao;

import Factory.ConectionFactory;
import Model.Cor;
import Model.Produto;

import java.io.*;
import java.sql.*;
import java.util.*;

public class CorDao {

    private Connection conection ;

    public CorDao(){
        this.conection = new ConectionFactory().getConection();
    }
    public void criaTabelaCor(Cor cor)throws IOException, SQLException{
        String sql =  "CREATE TABLE IF NOT EXISTS cores (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "hexadecimal VARCHAR(10) );";

        PreparedStatement stmt = conection.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }
    public void cadastraCor(Cor cores) throws SQLException{
        String sql = "INSERT INTO cores" +
                " (nome, hexadecimal) " +
                "VALUES (?,?)";

        PreparedStatement stmt = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, cores.getNome());
        stmt.setString(2, cores.getHexadecimal());

        stmt.execute();

        ResultSet resultSet = stmt.getGeneratedKeys();

        while (resultSet.next()) {
            cores.setId(resultSet.getInt(1));
        }
    }
    public List<Cor>listarCores() throws SQLException{
        String sql = "SELECT * FROM cores";

        PreparedStatement stmt = conection.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();

        List<Cor> listaDeCores = new ArrayList<>();

        while(resultSet.next()) {
            Cor cor = new Cor();

            cor.setId(resultSet.getInt("id"));
            cor.setNome(resultSet.getString("nome"));
            cor.setHexadecimal((resultSet.getString("Hexadecimal")));
            listaDeCores.add(cor);
        }
        return listaDeCores;
    }

    public List<Cor> listarCoresProduto(Produto produto){
        String sql = "SELECT * FROM cores c JOIN corproduto cp ON c.id = cp.idCor WHERE cp.idProduto = ?";

        try {

            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            ResultSet resultSet = stmt.executeQuery();

            List<Cor> listaDeCores = new ArrayList<>();

            while(resultSet.next()) {
                Cor cor = new Cor();

                cor.setId(resultSet.getInt("id"));
                cor.setNome(resultSet.getString("nome"));
                cor.setHexadecimal((resultSet.getString("Hexadecimal")));
                listaDeCores.add(cor);
            }
            return listaDeCores;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public  Cor selectCorById(int id) {
        String sql = "SELECT * FROM cores WHERE id = ?";

        try {

            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                Cor color = new Cor();
                color.setId(resultSet.getInt("id"));
                color.setNome(resultSet.getString("nome"));
                color.setHexadecimal(resultSet.getString("Hexadecimal"));
                return color;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    public void editarCor(Cor cor) {
        String sql = "UPDATE cores SET nome = ?, hexadecimal = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);

            stmt.setString(1, cor.getNome());
            stmt.setString(2, cor.getHexadecimal());
            stmt.setInt(3, (int) cor.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletaProduto(Cor cor) {
        String sql = "DELETE FROM cores WHERE id = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, (int) cor.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
