package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Cliente;
import java.sql.*;


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
        "senha VARCHAR(32),"+
        "id_contatos INT,"+
        "id_endereco INT,"+
        "CONSTRAINT fk_id_contatos FOREIGN KEY (id_contatos) REFERENCE contatos(id_contatos),"+
        "CONSTRAINT fk_id_endereco FOREIGN KEY (id_endereco) REFERENCE endereco(id_endereco)"+
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

    }

}
