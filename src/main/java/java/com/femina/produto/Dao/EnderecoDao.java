package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Endereco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {

    private Connection conection;

    public EnderecoDao() {
        this.conection = new ConectionFactory().getConection();
    }

    public void criaTabelaEndereco()  {
        try{
            String sql = "CREATE TABLE IF NOT EXISTS endereco (" +
                    "idEndereco INT PRIMARY KEY AUTO_INCREMENT," +
                    "pais VARCHAR(50) NOT NULL," +
                    "estado VARCHAR(50) NOT NULL," +
                    "cidade VARCHAR(50) NOT NULL," +
                    "rua VARCHAR(50) NOT NULL," +
                    "cep VARCHAR(50) NOT NULL," +
                    "numCasa INT NOT NULL);";

            PreparedStatement stmt = conection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastraEndereco(Endereco endereco) {
        try {

            String sql = "INSERT INTO endereco" +
                    " (pais,estado,cidade,rua,cep,numCasa) " +
                    " VALUES (?,?,?,?,?,?) ";

            PreparedStatement stmt = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, endereco.getPais());
            stmt.setString(2, endereco.getEstado());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getCep());
            stmt.setInt(6,endereco.getNumCasa());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while(resultSet.next()) {
                endereco.setIdEndereco(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Endereco> listarEnderecos() {
        try {
            String sql = "SELECT * FROM endereco";
            PreparedStatement stmt = conection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Endereco> listaDeEnderecos = new ArrayList<Endereco>();

            while(resultSet.next()) {
                Endereco endereco = new Endereco();

                endereco.setIdEndereco(resultSet.getInt("idEndereco"));
                endereco.setPais(resultSet.getString("pais"));
                endereco.setEstado(resultSet.getString("estado"));
                endereco.setCidade(resultSet.getString("cidade"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setCep(resultSet.getString("cep"));
                endereco.setNumCasa(resultSet.getInt("numCasa"));

                listaDeEnderecos.add(endereco);
            }

            return listaDeEnderecos;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Endereco selectEnderecoById(int id) {
        String sql = "SELECT * FROM endereco WHERE idEndereco = ?";
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Endereco endereco = new Endereco();

                endereco.setIdEndereco(resultSet.getInt("idEndereco"));
                endereco.setPais(resultSet.getString("pais"));
                endereco.setEstado(resultSet.getString("estado"));
                endereco.setCidade(resultSet.getString("cidade"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setCep(resultSet.getString("cep"));
                endereco.setNumCasa(resultSet.getInt("numCasa"));

                return endereco;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editarEndereco(Endereco endereco) {
        String sql = "UPDATE endereco SET pais = ?, estado = ?, cidade = ?, rua = ?, cep = ?, numCasa = ? WHERE idEndereco = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);

            stmt.setString(1, endereco.getPais());
            stmt.setString(2,endereco.getEstado());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5,endereco.getCep());
            stmt.setInt(6, endereco.getNumCasa());
            stmt.setInt(7, endereco.getIdEndereco());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletaEndereco(Endereco endereco) {

        String sql = "DELETE FROM endereco WHERE idEndereco = ?";

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);

            stmt.setInt(1,endereco.getIdEndereco());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}