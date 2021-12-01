package Dao;

import Factory.ConectionFactory;
import Model.Destaques;

import java.sql.*;

public class DestaquesDao {

    private Connection connection;

    public DestaquesDao(){
        this.connection = new ConectionFactory().getConection();
    }


    public void criarTabelasDetaques(){

        String sql = "CREATE TABLE IF NOT EXISTS destaques (" +
                "idDestaque INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                ");";

        String sqlDestaque = "CREATE TABLE IF NOT EXISTS produtoDestaque (" +
                "idCorProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "idProduto INT," +
                "idCor INT," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)," +
                "FOREIGN KEY (idDestaque) REFERENCES destaques(idDestaque)" +
                ");";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt = connection.prepareStatement(sqlDestaque);
            stmt.execute();

            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void cadastraDestaque(Destaques dest){


        String sql = "INSERT INTO destaques" +
                "(idDestaque,nome) " +
                "VALUES (?,?)";

        String sqlCor = "INSERT INTO produtoDestaque" +
                "(idProduto, idDestaque)" +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, dest.getIdDestaque());
            stmt.setString(2, dest.getNome());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                dest.setIdDestaque(resultSet.getInt(1));
            }

            for(int i = 0; i < dest.getProdutoDestaque().getProdutos().size(); i++){
                stmt = connection.prepareStatement(sqlCor);
                stmt.setInt(1, dest.getIdDestaque());
                stmt.setInt(2, dest.getProdutoDestaque().getProdutos().get(i).getId());

                stmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}