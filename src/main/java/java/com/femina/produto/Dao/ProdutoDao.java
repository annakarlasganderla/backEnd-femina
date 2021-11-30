package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.*;
import java.io.*;
import java.sql.*;
import java.util.*;


public class ProdutoDao {

    private Connection connection;

    public ProdutoDao(){
        this.connection = new ConectionFactory().getConection();
    }

    public void criarTabelasProduto(){
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "idProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "codigo INT NOT NULL," +
                "nome VARCHAR(50) NOT NULL," +
                "valor DECIMAL(10,2)," +
                "quantidade INT," +
                "idMarca INT," +
                "idCategoria INT," +
                "FOREIGN KEY (idMarca) REFERENCES marca(idMarca)," +
                "FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria)" +
                ");";

        String sqlCor = "CREATE TABLE IF NOT EXISTS corProduto (" +
                "idCorProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "idProduto INT," +
                "idCor INT," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)," +
                "FOREIGN KEY (idCor) REFERENCES cores(id)" +
                ");";

        String sqlModelo = "CREATE TABLE IF NOT EXISTS modeloproduto (" +
                "idModeloProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "idProduto INT," +
                "idModeloP INT," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)," +
                "FOREIGN KEY (idModeloP) REFERENCES modelo(idModelo)" +
                ");";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt = connection.prepareStatement(sqlCor);
            stmt.execute();
            stmt = connection.prepareStatement(sqlModelo);
            stmt.execute();

            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarProduto(Produto prod){

        String sql = "INSERT INTO produtos" +
                "(codigo,nome,valor,quantidade,idMarca,idCategoria) " +
                "VALUES (?,?,?,?,?,?)";

        String sqlCor = "INSERT INTO corproduto" +
                "(idProduto, idCor)" +
                "VALUES (?,?)";

        String sqlModelo = "INSERT INTO modeloproduto" +
                "(idProduto, idModeloP)" +
                "VALUES (?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, prod.getCodigo());
            stmt.setString(2, prod.getNome());
            stmt.setDouble(3, prod.getPreco());
            stmt.setInt(4, prod.getQtd());
            stmt.setInt(5, prod.getMarca().getId());
            stmt.setInt(6, prod.getCategoria().getId());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()){
                prod.setId(resultSet.getInt(1));
            }

            for(int i = 0; i < prod.getCores().getCores().size(); i++){
                stmt = connection.prepareStatement(sqlCor);
                stmt.setInt(1, prod.getId());
                stmt.setInt(2, prod.getCores().getCores().get(i).getId());

                stmt.execute();
            }

            for(int i = 0; i < prod.getModelo().getModelos().size(); i++){
                stmt = connection.prepareStatement(sqlModelo);
                stmt.setInt(1, prod.getId());
                stmt.setInt(2, prod.getModelo().getModelos().get(i).getId());

                stmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Produto> listarProdutos(){
        String sql = "SELECT * FROM produtos";
        String sqlCor = "SELECT idCor FROM corproduto cp JOIN cores c ON cp.idCor = c.id WHERE cp.idProduto = ?";
        String sqlModelo = "SELECT idModeloP FROM modeloproduto mp JOIN modelo m ON mp.idModeloP = m.idModelo WHERE mp.idProduto = ?";

        try {

            List<Produto> listaProdutos = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();

                produto.setId(resultSet.getInt("idProduto"));
                produto.setCodigo(resultSet.getInt("codigo"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getDouble("valor"));
                produto.setQtd(resultSet.getInt("quantidade"));

                MarcaDao md = new MarcaDao();
                Marca marca = md.SelecionaId(resultSet.getInt("idMarca"));
                produto.setMarca(marca);

                CategoriaDao cd = new CategoriaDao();
                Categoria categoria = cd.selectById(resultSet.getInt("idCategoria"));
                produto.setCategoria(categoria);

                CorProduto corProduto = new CorProduto();
                stmt = connection.prepareStatement(sqlCor);
                stmt.setInt(1,produto.getId());
                ResultSet resultSet1 = stmt.executeQuery();
                while (resultSet1.next()){
                    CorDao corDao = new CorDao();
                    Cor cor = corDao.selectCorById(resultSet1.getInt("idCor"));
                    corProduto.getCores().add(cor);
                }
                produto.setCores(corProduto);


                ModeloProduto modeloProduto = new ModeloProduto();
                stmt = connection.prepareStatement(sqlModelo);
                stmt.setInt(1, produto.getId());
                ResultSet resultSet2 = stmt.executeQuery();

                while (resultSet2.next()){
                    ModeloDao modeloDao = new ModeloDao();

                    ModelosDosProdutos modelo = modeloDao.selecionaModeloById(resultSet2.getInt("idModeloP"));
                    modeloProduto.getModelos().add(modelo);
                }
                produto.setModelo(modeloProduto);

                listaProdutos.add(produto);
            }

            return listaProdutos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void updateProd(List<Produto> prod){
//        try {
//
//            FileWriter fileWriter = new FileWriter("produtos.txt", false);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            for (int list = 0; list < prod.size(); list++) {
//                printWriter.println(prod.get(list));
//            }
//
//            printWriter.flush();
//            printWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void delProd(List<Produto> prod){
//        try {
//
//            FileWriter fileWriter = new FileWriter("produtos.txt", false);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            for (int list = 0; list < prod.size(); list++) {
//                prod.get(list).setId(list+1);
//                printWriter.println(prod.get(list));
//            }
//
//            printWriter.flush();
//            printWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Produto> retornaProdutosPeloIdLoja(Long idLoja){
//
//        List<Produto> novaListaProdutosIdLoja = new ArrayList<>();
//        List<Produto> listaDeProdutos = retornaProdutos();
//
//        for (int i = 0;i < listaDeProdutos.size();i++){
//            if (listaDeProdutos.get(i).getIdLoja() == idLoja){
//                novaListaProdutosIdLoja.add(listaDeProdutos.get(i));
//            }
//        }
//
//        return novaListaProdutosIdLoja;
//
//    }

}
