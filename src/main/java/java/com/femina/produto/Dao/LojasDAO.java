package java.com.femina.produto.Dao;

import java.com.femina.produto.Controller.ContatoController;
import java.com.femina.produto.Controller.EnderecoController;
import java.com.femina.produto.Controller.FuncionariosController;
import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Lojas;
import java.com.femina.produto.Model.ProdutosAux;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojasDAO {

    EnderecoDao enderecoDao = new EnderecoDao();
    ContatoDao contatoDao = new ContatoDao();
    FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
    private static Connection connection;

    public LojasDAO() {
        this.connection = ConectionFactory.getConection();
    }

    public void creatTable() {

        String sqlCreat = "CREATE TABLE IF NOT EXISTS lojas (" +
                "    idLoja INT PRIMARY KEY AUTO_INCREMENT," +
                "    nome VARCHAR(244)," +
                "    idEndereco INT," +
                "    idContato INT," +
                "FOREIGN KEY (idEndereco) REFERENCES endereco(id)," +
                "FOREIGN KEY (idContato) REFERENCES contatos(idContatos)" +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreat);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatTableAuxFunc() {

        String sqlCreatAux = "CREATE TABLE IF NOT EXISTS lojasXfuncionarios (" +
                "    idLoja INT," +
                "    idFuncionarios INT," +
                "FOREIGN KEY (idLoja) REFERENCES lojas(idLoja)," +
                "FOREIGN KEY (idFuncionarios) REFERENCES funcionarios(idFuncionarios)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreatAux);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creatTableAuxProd() {

        String sqlCreatAux = "CREATE TABLE IF NOT EXISTS lojasXprodutos (" +
                "    idLoja INT," +
                "    idProduto INT," +
                "FOREIGN KEY (idLoja) REFERENCES lojas(idLoja)," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(id)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreatAux);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarLojas(Lojas loja) {
        String sqlInsert = "INSERT INTO lojas " +
                "(nome, idEndereco, idContato) " +
                "VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, loja.getNome());
            preparedStatement.setInt(2, loja.getEndereco().getIdEndereco());
            preparedStatement.setInt(3, loja.getContatos().getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarProdutosNaLOja(Lojas loja) {

        String sqlInsert = "INSERT INTO lojasXprodutos (idLoja, " +
                "idProduto) " +
                "VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            for (int i = 0; i < loja.getProdutos().getProdutosList().size(); i++) {
                preparedStatement.setInt(1, loja.getId());
                preparedStatement.setInt(2, loja.getProdutos().getProdutosList().get(i).getId());
            }
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarFuncionariosNaLOja(Lojas loja) {

        String sqlInsert = "INSERT INTO lojasXfuncionarios (idLoja, " +
                "idProduto) " +
                "VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            for (int i = 0; i < loja.getFuncionarios().getFuncionariosList().size(); i++) {
                preparedStatement.setInt(1, loja.getId());
                preparedStatement.setInt(2, loja.getFuncionarios().getFuncionariosList().get(i).getId());
            }
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLoja(int idDelete) {
        String sqlDel = "DELETE * FROM lojas WHERE idLoja = " + idDelete;
        String sqlDelEndereco = "DELETE FROM enderecos WHERE idLoja = " + idDelete;
        String sqlDelContato = "DELETE FROM contatos WHERE idLoja = " + idDelete;
        String sqlDelFuncionarios = "DELETE FROM funcionarios WHERE idLoja = " + idDelete;
        String sqlDelProdutos = "DELETE FROM produtos WHERE idLoja = " + idDelete;
        try {
            PreparedStatement preparedStatement0 = connection.prepareStatement(sqlDel);
            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlDelEndereco);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlDelContato);
            PreparedStatement preparedStatement3 = connection.prepareStatement(sqlDelFuncionarios);
            PreparedStatement preparedStatement4 = connection.prepareStatement(sqlDelProdutos);
            preparedStatement0.execute();
            preparedStatement0.close();
            preparedStatement1.execute();
            preparedStatement1.close();
            preparedStatement2.execute();
            preparedStatement2.close();
            preparedStatement3.execute();
            preparedStatement3.close();
            preparedStatement4.execute();
            preparedStatement4.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarNomeLoja(Lojas loja, int idSelct){
        String nomeNovo = loja.getNome();
        String sqlUpdate = "UPDATE lojas SET nome = " + nomeNovo  +  " WHERE idLoja = "+ idSelct;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Lojas selectLojaById(int idSelect) {
        Lojas loja = new Lojas();
        String sqlSelectById = "SELECT * FROM lojas WHERE idLoja = " + idSelect;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectById);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                loja.setId(resultSet.getInt("idLoja"));
                loja.setNome(resultSet.getString("nome"));
                loja.setEndereco(enderecoDao.selectEnderecoById(resultSet.getInt("idEndereco")));
                loja.setContatos(contatoDao.selecionaId(resultSet.getInt("idContato")));
                loja.setFuncionarios(funcionariosDAO.listarFuncionariosIdLoja(resultSet.getInt("idLoja")));
                loja.setProdutos(produtoDAO.listaProdutoByIdLoja());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loja;
    }

    public List<Lojas> listarTodasAsLojas() {
        Lojas loja = new Lojas();
        String sqlSelectById = "SELECT * FROM lojas";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectById);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Lojas> retornoBanco = new ArrayList<>();
            while (resultSet.next()) {
                loja.setId(resultSet.getInt("idLoja"));
                loja.setNome(resultSet.getString("nome"));
                loja.setEndereco(enderecoDao.selectEnderecoById(resultSet.getInt("idEndereco")));
                loja.setContatos(contatoDao.selecionaId(resultSet.getInt("idContato")));
                retornoBanco.add(loja);
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}