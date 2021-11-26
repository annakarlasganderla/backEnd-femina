package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Cliente;
import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Endereco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private Connection connection;

    public ClienteDao(){
        this.connection = new ConectionFactory().getConection();
    }

    public void criarTabelaClientes(){
        String sql = "CREATE TABLE IF NOT EXISTS cliente (" +
        "idCliente INT PRIMARY KEY AUTO_INCREMENT,"+
        "nome VARCHAR(40) NOT NULL," +
        "idade INTEGER(11),"+
        "senha VARCHAR(32) NOT NULL,"+
        "idContatos INT,"+
        "idEndereco INT,"+
        "FOREIGN KEY (idContatos) REFERENCES contatos(idContatos),"+
        "FOREIGN KEY (idEndereco) REFERENCES endereco(idEndereco)"+
        ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente "+
        "(nome, idade, senha, idContatos, idEndereco) "+
        "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,cliente.getNome());
            stmt.setInt(2,cliente.getIdade());
            stmt.setString(3,cliente.getSenha());
            stmt.setInt(4, cliente.getContatos().getId());
            stmt.setInt(5, cliente.getEndereco().getIdEndereco());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                cliente.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarClientes(){
        String sql = "SELECT * FROM cliente";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Cliente> listaClientes = new ArrayList<>();

            while (resultSet.next()){
                Cliente cliente = new Cliente();

                cliente.setId(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setIdade(resultSet.getInt("idade"));
                cliente.setSenha(resultSet.getString("senha"));

                ContatoDao contatoDao = new ContatoDao();
                Contatos contato = contatoDao.selecionaId(resultSet.getInt("idContatos"));
                cliente.setContatos(contato);

                EnderecoDao enderecoDao = new EnderecoDao();
                Endereco endereco = enderecoDao.selectEnderecoById(resultSet.getInt("idEndereco"));
                cliente.setEndereco(endereco);

                listaClientes.add(cliente);
            }

            return listaClientes;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Cliente selectById(int id){
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){

                Cliente cliente = new Cliente();

                cliente.setId(resultSet.getInt("idCliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setIdade(resultSet.getInt("idade"));
                cliente.setSenha(resultSet.getString("senha"));

                ContatoDao contatoDao = new ContatoDao();
                Contatos contato = contatoDao.selecionaId(resultSet.getInt("idContatos"));
                cliente.setContatos(contato);

                EnderecoDao enderecoDao = new EnderecoDao();
                Endereco endereco = enderecoDao.selectEnderecoById(resultSet.getInt("idEndereco"));
                cliente.setEndereco(endereco);

                return cliente;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editarCliente(Cliente cliente){
        String sql = "UPDATE cliente SET nome = ?,idade = ?, senha = ?, idContatos = ?, idEndereco = ? WHERE idCliente = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getSenha());
            stmt.setInt(4,cliente.getContatos().getId());
            stmt.setInt(5, cliente.getEndereco().getIdEndereco());
            stmt.setInt(6, cliente.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletarCliente(Cliente cliente){
        String sql = "DELETE FROM cliente WHERE idCliente = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
