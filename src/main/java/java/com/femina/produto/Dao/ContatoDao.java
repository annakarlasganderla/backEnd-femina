
package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Contatos;
import java.sql.*;
import java.util.*;

package Dao;

import Factory.ConectionFactory;
import Model.Contatos;

import java.sql.*;
import java.util.*;

public class ContatoDao {


    private Connection connection;

    public ContatoDao() {
        this.connection = new ConectionFactory().getConection();
    }

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS contatos ("+
                "idContatos INT PRIMARY KEY AUTO_INCREMENT," +
                "telefone VARCHAR(50) NOT NULL," +
                "email VARCHAR(50) NOT NULL" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Contatos criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
  
    public void gravaNoBanco(Contatos contatos){

        String sql = "INSERT INTO contatos" +
                " (telefone,email) " +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, contatos.getTel());
            stmt.setString(2, contatos.getEmail());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                contatos.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contatos> mostraLista(){

        String sql = "SELECT * FROM contatos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Contatos> contatos = new ArrayList<>();
            Contatos contato;

            while (resultSet.next()) {
                contato = new Contatos();
                contato.setTel(resultSet.getString("telefone"));
                contato.setEmail(resultSet.getString("email"));
                contato.setId(resultSet.getInt("idContatos"));
                contatos.add(contato);
            }

            return contatos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } }


    public Contatos selecionaId (int id){

        String sql = "SELECT * FROM contatos WHERE idContatos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            Contatos contato = new Contatos();
            while (resultSet.next()){
                contato.setId(resultSet.getInt("idContatos"));
                contato.setTel(resultSet.getString("telefone"));
                contato.setEmail(resultSet.getString("email"));
            }
            return  contato;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarContatoDoBanco(Contatos contatos){
        String sql = "UPDATE contatos SET email = ?, telefone = ? WHERE idContatos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contatos.getEmail());
            stmt.setString(2, contatos.getTel());
            stmt.setInt(3, contatos.getId());


            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void removeContatoDoBanco(Contatos contatos){
        String sql = "DELETE FROM contatos WHERE idContatos = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, contatos.getId());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

