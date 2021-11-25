package java.com.femina.produto.Dao;

import main.java.com.femina.produto.Dao.ContatoDao;

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
        "id_cliente INT PRIMARY KEY AUTO_INCREMENT,"+
        "nome VARCHAR(40) NOT NULL," +
        "idade INTEGER(11),"+
        "senha VARCHAR(32) NOT NULL,"+
        "id_contatos INT,"+
        "id_endereco INT,"+
        "FOREIGN KEY (id_contatos) REFERENCE contatos(id),"+
        "FOREIGN KEY (id_endereco) REFERENCE endereco(id)"+
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
        "(nome, idade, senha, id_contatos, id_endereco) "+
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

                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setIdade(resultSet.getInt("idade"));
                cliente.setSenha(resultSet.getString("senha"));

                ContatoDao contatoDao = new ContatoDao();
                Contatos contato = contatoDao.selecionaContatoById(resultSet.getInt("id_contato"));
                cliente.setContatos(contato);

                EnderecoDao enderecoDao = new EnderecoDao();
                Endereco endereco = enderecoDao.selecionaEnderecoById(resultSet.getInt("id_endereco"));
                cliente.setEndereco(endereco);

                listaClientes.add(cliente);
            }

            return listaClientes;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
