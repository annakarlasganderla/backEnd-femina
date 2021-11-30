package Dao;

import Factory.ConectionFactory;
import Model.Contatos;
import Model.Endereco;
import Model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

    private Connection connection;

    public FornecedorDao(){
        this.connection = new ConectionFactory().getConection();
    }

    public void criarTabelaFornecedores() {
        String sql = "CREATE TABLE IF NOT EXISTS fornecedores (" +
                "idFornecedor INT PRIMARY KEY AUTO_INCREMENT, " +
                "nomeFornecedor VARCHAR(50) NOT NULL," +
                "cnpjFornecedor VARCHAR(50) NOT NULL," +
                "idContato INT," +
                "idEndereco INT," +
                //             nome que eu dei             nome que esta no banco
                "FOREIGN KEY (idContato) REFERENCES contatos(idContatos)," +
                "FOREIGN KEY (idEndereco) REFERENCES endereco(idEndereco)" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarFornecedor (Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedores" +
                "(nomeFornecedor, cnpjFornecedor, idContato, idEndereco) " +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCnpjFornecedor());
            stmt.setInt(3,fornecedor.getContatoFornecedor().getId());
            stmt.setInt(4,fornecedor.getEnderecoFornecedor().getIdEndereco());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while(resultSet.next()) {
                fornecedor.setIdFornecedor(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Fornecedor> listarFornecedores() {
        String sql = "SELECT * FROM fornecedores";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Fornecedor> listaFornecedores = new ArrayList<>();

            while(resultSet.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
                fornecedor.setCnpjFornecedor(resultSet.getString("cnpjFornecedor"));

                ContatoDao contatoDao = new ContatoDao();
                Contatos contatos = contatoDao.selecionaId(resultSet.getInt("idContato"));
                fornecedor.setContatoFornecedor(contatos);

                EnderecoDao enderecoDao = new EnderecoDao();
                Endereco enderecos = enderecoDao.selectEnderecoById(resultSet.getInt("idEndereco"));
                fornecedor.setEnderecoFornecedor(enderecos);

                listaFornecedores.add(fornecedor);
            }

            return listaFornecedores;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Fornecedor selectFornecedorById (int idFornecedor) {
        String sql = "SELECT * FROM fornecedores WHERE idFornecedor = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idFornecedor);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setIdFornecedor(resultSet.getInt("idFornecedor"));
                fornecedor.setNomeFornecedor(resultSet.getString("nomeFornecedor"));
                fornecedor.setCnpjFornecedor(resultSet.getString("cnpjFornecedor"));

                ContatoDao contatoDao = new ContatoDao();
                Contatos contatos = contatoDao.selecionaId(resultSet.getInt("idContato"));
                fornecedor.setContatoFornecedor(contatos);

                EnderecoDao enderecoDao = new EnderecoDao();
                Endereco enderecos = enderecoDao.selectEnderecoById(resultSet.getInt("idEndereco"));
                fornecedor.setEnderecoFornecedor(enderecos);

                return fornecedor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editarFornecedor (Fornecedor fornecedor) {
        String sql = "UPDATE fornecedores SET nomeFornecedor = ?, cnpjFornecedor = ?, idContato = ?, idEndereco = ? WHERE idFornecedor = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,fornecedor.getNomeFornecedor());
            stmt.setString(2,fornecedor.getCnpjFornecedor());
            stmt.setInt(3,fornecedor.getContatoFornecedor().getId());
            stmt.setInt(4,fornecedor.getEnderecoFornecedor().getIdEndereco());
            stmt.setInt(5,fornecedor.getIdFornecedor());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarFornecedor(Fornecedor fornecedor) {
        String sql = "DELETE FROM fornecedores WHERE idFornecedor = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,fornecedor.getIdFornecedor());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
