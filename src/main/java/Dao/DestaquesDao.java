package Dao;

import Factory.ConectionFactory;
import Model.Destaques;
import Model.Lojas;
import Model.Produto;
import Model.ProdutoDestaque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DestaquesDao {

    private Connection connection;

    public DestaquesDao(){
        this.connection = new ConectionFactory().getConection();
    }


    public void criarTabelasDetaques(){

        String sql = "CREATE TABLE IF NOT EXISTS destaques (" +
                "idDestaque INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL" +
                ");";

        String sqlDestaque = "CREATE TABLE IF NOT EXISTS produtoDestaque (" +
                "idDestaqueProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "idProduto INT," +
                "idDestaque_fk INT," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)," +
                "FOREIGN KEY (idDestaque_fk) REFERENCES destaques(idDestaque)" +
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

        String sqlDestaque = "INSERT INTO produtoDestaque" +
                "(idProduto, idDestaque_fk)" +
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
                stmt = connection.prepareStatement(sqlDestaque);
                stmt.setInt(1, dest.getProdutoDestaque().getProdutos().get(i).getId());
                stmt.setInt(2, dest.getIdDestaque());

                stmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Destaques> listarDestaques(Lojas lojas) {
        String sql = "SELECT * FROM destaques";

        String sqlDestaque = "SELECT idDestaqueProduto FROM produtodestaque pd JOIN destaques d " +
                "ON pd.idDestaque_fk = d.idDestaque WHERE pd.idProduto = ?";

        try {

            List<Destaques> listaDestaques = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                Destaques destaques = new Destaques();
                destaques.setNome(resultSet.getString("nome"));

                ProdutoDestaque produtoDes = new  ProdutoDestaque();
                stmt = connection.prepareStatement(sqlDestaque);

                stmt.setInt(1, destaques.getIdDestaque());
                ResultSet resultSet1 = stmt.executeQuery();

                while(resultSet1.next()) {

                    ProdutoDao prodDao = new ProdutoDao();
                    Produto produtos = prodDao.selectById(resultSet1.getInt("idProduto"),lojas);
                    produtoDes.getProdutos().add(produtos);
                }

                destaques.setProdutoDestaque(produtoDes);
                listaDestaques.add(destaques);
            }

            return listaDestaques;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}