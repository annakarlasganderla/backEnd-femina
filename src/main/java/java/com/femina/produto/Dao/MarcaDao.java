package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Marca;

import java.sql.*;
import java.util.*;

public class MarcaDao {

    private Connection connection;

    public MarcaDao() {
        this.connection = new ConectionFactory().getConection();
    }

    public void criaTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS marca (" +
                "idMarca INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "idContatos INT," +
                "CONSTRAINT fk_idContatos FOREIGN KEY (idContatos)" +
                "REFERENCES contatos(idContatos)" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Marca criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(Marca marca) {

        String sql = "INSERT INTO marca" +
                " (nome,idContatos) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, marca.getNome());
            stmt.setInt(2, marca.getContatos().getId());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                marca.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Marca> listaMarca() {
        String sql = "SELECT * FROM marca";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Marca> marcaList = new ArrayList<>();
            Marca marca;

            while (resultSet.next()) {
                marca = new Marca();
                marca.setId(resultSet.getInt("idMarca"));
                marca.setNome(resultSet.getString("nome"));


                ContatoDao contatosDao = new ContatoDao();
                Contatos contatos1 = contatosDao.selecionaId(resultSet.getInt("idContatos"));
                marca.setContatos(contatos1);

                marcaList.add(marca);
            }

            return marcaList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Marca SelecionaId(int id) {

        String sql = "SELECT * FROM marca WHERE idMarca = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Marca marca = new Marca();
                marca.setId(resultSet.getInt("idMarca"));
                marca.setNome(resultSet.getString("Nome"));

                ContatoDao cd = new ContatoDao();
                Contatos contatos = cd.selecionaId(resultSet.getInt("idContatos"));
                marca.setContatos(contatos);

                return marca;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public void removeMarcaDoBanco(Marca marca) {

        String sql = "DELETE FROM marca WHERE idMarca = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, marca.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
