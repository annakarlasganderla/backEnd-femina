package java.com.femina.produto.Dao;

import java.com.femina.produto.Factory.ConectionFactory;
import java.com.femina.produto.Model.Produto;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt = connection.prepareStatement(sqlCor);
            stmt.execute();

            stmt.close();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

//    public void cadastrarProduto(Produto prod){
//
//       String sql = "";
//
//        try {
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public List<Produto> retornaProdutos(){
//        List<Produto> produtos = new ArrayList<>();
//        try {
//            File arquivoDeTexto = new File ("produtos.txt");
//
//            if(!arquivoDeTexto.isFile()){
//                arquivoDeTexto.createNewFile();
//            }
//
//            FileReader fileReader = new FileReader(arquivoDeTexto);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String linha = "";
//
//            List<String> result = new ArrayList();
//
//            while ((linha = bufferedReader.readLine()) != null) {
//                if (linha != null && !linha.isEmpty()) {
//                    result.add(linha);
//                }
//            }
//            fileReader.close();
//            bufferedReader.close();
//
//            for (String s : result) {
//                String[] produts = s.split(";");
//
//                Produto p = new Produto();
//
//                p.setId(Integer.valueOf(produts[0]));
//                p.setCodigo(Integer.valueOf(produts[1]));
//                p.setNome(produts[2]);
//                p.setPreco(Double.valueOf(produts[3]));
//                p.setQtd(Integer.valueOf(produts[4]));
//                FornecedorController fc = new FornecedorController();
//                List<Fornecedor> lfd = fc.listarFornecedores();
//                for (int i = 0;i < lfd.size();i++){
//                    if(lfd.get(i).getId() == Integer.valueOf(produts[5])){
//                        p.setFornecedor(lfd.get(i));
//                    }
//                }
//                p.setIdLoja(Long.valueOf(produts[6]));
//
//                produtos.add(p);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return produtos;
//    }
//
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
