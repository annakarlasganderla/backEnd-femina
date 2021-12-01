package java.com.femina.produto.Dao;

import main.java.com.femina.produto.Dao.FornecedorDao;

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

        String sqlTamanho = "CREATE TABLE IF NOT EXISTS tamanhoproduto (" +
                "idTamanhoProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "idProduto INT," +
                "idTamanho INT," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)," +
                "FOREIGN KEY (idTamanho) REFERENCES tamanho(id)" +
                ");";

        String sqlFornecedor = "CREATE TABLE IF NOT EXISTS fornecedorproduto (" +
                "idFornecedorProduto INT PRIMARY KEY AUTO_INCREMENT," +
                "idProduto INT," +
                "idFornecedor_fk INT," +
                "FOREIGN KEY (idProduto) REFERENCES produtos(idProduto)," +
                "FOREIGN KEY (idFornecedor_fk) REFERENCES fornecedores(idFornecedor)" +
                ");";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt = connection.prepareStatement(sqlCor);
            stmt.execute();
            stmt = connection.prepareStatement(sqlModelo);
            stmt.execute();
            stmt = connection.prepareStatement(sqlTamanho);
            stmt.execute();
            stmt = connection.prepareStatement(sqlFornecedor);
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

        String sqlTamanho = "INSERT INTO tamanhoproduto" +
                "(idProduto, idTamanho)" +
                "VALUES (?,?)";

        String sqlFornecedor = "INSERT INTO fornecedorproduto" +
                "(idProduto, idFornecedor_fk)" +
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

            for(int i = 0; i < prod.getTamanhos().getTamanhos().size(); i++){
                stmt = connection.prepareStatement(sqlTamanho);
                stmt.setInt(1, prod.getId());
                stmt.setInt(2, prod.getTamanhos().getTamanhos().get(i).getId());

                stmt.execute();
            }

            for(int i = 0; i < prod.getFornecedor().getFornecedores().size(); i++){
                stmt = connection.prepareStatement(sqlFornecedor);
                stmt.setInt(1, prod.getId());
                stmt.setInt(2, prod.getFornecedor().getFornecedores().get(i).getIdFornecedor());

                stmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ProdutosAux listarProdutos(int idLoja){
        String sql = "SELECT * FROM produtos WHERE idLoja = " + idLoja;
        String sqlCor = "SELECT idCor FROM corproduto cp JOIN cores c " +
                "ON cp.idCor = c.id WHERE cp.idProduto = ?";
        String sqlModelo = "SELECT idModeloP FROM modeloproduto mp JOIN modelo m " +
                "ON mp.idModeloP = m.idModelo WHERE mp.idProduto = ?";
        String sqlTamanho = "SELECT idTamanho FROM tamanhoproduto tp JOIN tamanho t " +
                "ON tp.idTamanho = t.id WHERE tp.idProduto = ?";
        String sqlFornecedor = "SELECT idFornecedor_fk FROM fornecedorproduto fp JOIN fornecedores f " +
                "ON fp.idFornecedor_fk = f.idFornecedor WHERE fp.idProduto = ?";

        try {
            ProdutosAux produtosAux = new ProdutosAux();
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

                TamanhoProduto tamanhoProduto = new TamanhoProduto();
                stmt = connection.prepareStatement(sqlTamanho);
                stmt.setInt(1, produto.getId());
                ResultSet resultSet3 = stmt.executeQuery();
                while (resultSet3.next()){
                    TamanhoDAO tamanhoDAO = new TamanhoDAO();
                    Tamanho tamanho = tamanhoDAO.listTamanhosId(resultSet3.getInt("idTamanho"));
                    tamanhoProduto.getTamanhos().add(tamanho);
                }
                produto.setTamanhos(tamanhoProduto);

                FornecedorProduto fornecedorProduto = new FornecedorProduto();
                stmt = connection.prepareStatement(sqlFornecedor);
                stmt.setInt(1, produto.getId());
                ResultSet resultSet4 = stmt.executeQuery();
                while (resultSet4.next()) {
                    FornecedorDao fornecedorDao = new FornecedorDao();
                    Fornecedor fornecedor = fornecedorDao.selectFornecedorById(resultSet4.getInt("idFornecedor_fk"));
                    fornecedorProduto.getFornecedores().add(fornecedor);
                }
                produto.setFornecedor(fornecedorProduto);

                listaProdutos.add(produto);
            }
            produtosAux.setProdutosList(listaProdutos);
            return produtosAux;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Produto selectById(int idProduto){

        String sql = "SELECT * FROM produtos WHERE idProduto = ?";
        String sqlCor = "SELECT idCor FROM corproduto cp JOIN cores c " +
                "ON cp.idCor = c.id WHERE cp.idProduto = ?";
        String sqlModelo = "SELECT idModeloP FROM modeloproduto mp JOIN modelo m " +
                "ON mp.idModeloP = m.idModelo WHERE mp.idProduto = ?";
        String sqlTamanho = "SELECT idTamanho FROM tamanhoproduto tp JOIN tamanho t " +
                "ON tp.idTamanho = t.id WHERE tp.idProduto = ?";
        String sqlFornecedor = "SELECT idFornecedor_fk FROM fornecedorproduto fp JOIN fornecedores f " +
                "ON fp.idFornecedor_fk = f.idFornecedor WHERE fp.idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
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
                stmt.setInt(1, produto.getId());
                ResultSet resultSet1 = stmt.executeQuery();
                while (resultSet1.next()) {
                    CorDao corDao = new CorDao();
                    Cor cor = corDao.selectCorById(resultSet1.getInt("idCor"));
                    corProduto.getCores().add(cor);
                }
                produto.setCores(corProduto);

                ModeloProduto modeloProduto = new ModeloProduto();
                stmt = connection.prepareStatement(sqlModelo);
                stmt.setInt(1, produto.getId());
                ResultSet resultSet2 = stmt.executeQuery();
                while (resultSet2.next()) {
                    ModeloDao modeloDao = new ModeloDao();
                    ModelosDosProdutos modelo = modeloDao.selecionaModeloById(resultSet2.getInt("idModeloP"));
                    modeloProduto.getModelos().add(modelo);
                }
                produto.setModelo(modeloProduto);

                TamanhoProduto tamanhoProduto = new TamanhoProduto();
                stmt = connection.prepareStatement(sqlTamanho);
                stmt.setInt(1, produto.getId());
                ResultSet resultSet3 = stmt.executeQuery();
                while (resultSet3.next()) {
                    TamanhoDAO tamanhoDAO = new TamanhoDAO();
                    Tamanho tamanho = tamanhoDAO.listTamanhosId(resultSet3.getInt("idTamanho"));
                    tamanhoProduto.getTamanhos().add(tamanho);
                }
                produto.setTamanhos(tamanhoProduto);

                FornecedorProduto fornecedorProduto = new FornecedorProduto();
                stmt = connection.prepareStatement(sqlFornecedor);
                stmt.setInt(1, produto.getId());
                ResultSet resultSet4 = stmt.executeQuery();
                while (resultSet4.next()) {
                    FornecedorDao fornecedorDao = new FornecedorDao();
                    Fornecedor fornecedor = fornecedorDao.selectFornecedorById(resultSet4.getInt("idFornecedor_fk"));
                    fornecedorProduto.getFornecedores().add(fornecedor);
                }
                produto.setFornecedor(fornecedorProduto);

                return produto;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public void deletarProduto(Produto produto){
        String sql = "DELETE FROM produtos WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void editarProduto(Produto produto){
        String sql = "UPDATE produtos SET codigo = ?, nome = ?, valor = ?, quantidade = ?, " +
                "idMarca = ?, idCategoria= ? WHERE idProduto = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQtd());
            stmt.setInt(5, produto.getMarca().getId());
            stmt.setInt(6, produto.getCategoria().getId());
            stmt.setInt(7, produto.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateModelo(Produto produto){
        String sqlModelo = "INSERT INTO modeloproduto" +
                "(idProduto, idModeloP)" +
                "VALUES (?,?)";

        try {
            for(int i = 0; i < produto.getModelo().getModelos().size(); i++){
                PreparedStatement stmt = connection.prepareStatement(sqlModelo);
                stmt.setInt(1, produto.getId());
                stmt.setInt(2, produto.getModelo().getModelos().get(i).getId());

                stmt.execute();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateCor(Produto produto){
        String sqlModelo = "INSERT INTO corproduto" +
                "(idProduto, idCor)" +
                "VALUES (?,?)";

        try {
            for(int i = 0; i < produto.getModelo().getModelos().size(); i++){
                PreparedStatement stmt = connection.prepareStatement(sqlModelo);
                stmt.setInt(1, produto.getId());
                stmt.setInt(2, produto.getCores().getCores().get(i).getId());

                stmt.execute();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletarModeloProduto(ModelosDosProdutos modelo, Produto produto){
        String sql = "DELETE FROM modeloproduto WHERE idModeloP = ? AND idProduto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modelo.getId());
            stmt.setInt(2, produto.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void deletarCorProduto(Cor cor, Produto produto){
        String sql = "DELETE FROM corproduto WHERE idCor = ? AND idProduto = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cor.getId());
            stmt.setInt(2, produto.getId());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
