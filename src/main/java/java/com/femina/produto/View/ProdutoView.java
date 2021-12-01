package java.com.femina.produto.View;

import main.java.com.femina.produto.View.CategoriaView;
import main.java.com.femina.produto.View.CorView;
import main.java.com.femina.produto.View.FornecedorView;
import main.java.com.femina.produto.View.MarcaView;

import java.com.femina.produto.Controller.ProdutoController;
import java.com.femina.produto.Model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ProdutoView {

    public void cadastrarProdutos() throws SQLException, IOException {

        ProdutoController pc = new ProdutoController();
        CategoriaView categoriaView = new CategoriaView();
        ModeloView modeloView = new ModeloView();
        CorView cv = new CorView();
        MarcaView mv = new MarcaView();
        TamanhoView tv = new TamanhoView();
        FornecedorView fv = new FornecedorView();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        Produto prod = new Produto();
        int op = 1;

        System.out.println("Informe o Código do Produto:");
        prod.setCodigo(entrada.nextInt());

        System.out.println("Informe o Nome:");
        prod.setNome(entrada.next());

        System.out.println("Informe o Preco:");
        prod.setPreco(entrada.nextDouble());

        System.out.println("Informe a Quantidade:");
        prod.setQtd(entrada.nextInt());

        System.out.println("Selecione a Categoria do Produto:");
        Categoria categoria = categoriaView.selectById();
        prod.setCategoria(categoria);

        System.out.println("Selecione os Modelos do Produto");
        ModeloProduto modeloProduto = new ModeloProduto();
        while (op != 0) {
            ModelosDosProdutos modelo = modeloView.selecionaModeloById();
            modeloProduto.getModelos().add(modelo);
            System.out.println("Deseja Selecionar mais um Modelo para esse Produto?");
            System.out.println("1 - SIM;                                   0 - NÃO;");
            op = entrada.nextInt();
        }
        prod.setModelo(modeloProduto);

        System.out.println("Selecione a Marca do Produto:");
        Marca marca = mv.retornaById();
        prod.setMarca(marca);

        op = 1;
        System.out.println("Selecione as Cores do produto:");
        CorProduto corProduto = new CorProduto();
        while (op != 0) {
            Cor cor = cv.selecionaCoresById();
            corProduto.getCores().add(cor);
            System.out.println("Deseja Selecionar mais uma Cor para esse Produto?");
            System.out.println("1 - SIM;                                 0 - NÃO;");
            op = entrada.nextInt();
        }
        prod.setCores(corProduto);

        op = 1;
        System.out.println("Selecione os Tamanhos do produto:");
        TamanhoProduto tamanhoProduto = new TamanhoProduto();
        while (op != 0){
            Tamanho tamanho = tv.listarTamanhosDoProduto();
            tamanhoProduto.getTamanhos().add(tamanho);
            System.out.println("Deseja Selecionar mais Tamanhos para esse Produto?");
            System.out.println("1 - SIM;                                  0 - NÃO;");
            op = entrada.nextInt();
        }
        prod.setTamanhos(tamanhoProduto);

        op = 1;
        System.out.println("Selecione os Fornecedores do produto:");
        FornecedorProduto fornecedorProduto = new FornecedorProduto();
        while (op != 0) {
            Fornecedor fornecedor = fv.selectFornecedorById();
            fornecedorProduto.getFornecedores().add(fornecedor);
            System.out.println("Deseja Selecionar mais Fornecedor para esse Produto?");
            System.out.println("1 - SIM;                                    0 - NÃO;");
            op = entrada.nextInt();
        }
        prod.setFornecedor(fornecedorProduto);

        pc.cadastrarProduto(prod);

    }

    public ProdutoAux listarProdutos(int idLoja) throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        ProdutoController pc = new ProdutoController();
        ProdutoAux listaProdutos = pc.listarProdutos(idLoja);

        if(listaProdutos.isEmpty()){
            System.out.println("Nenhum Produto Cadastrado!");
            System.out.println("Deseja Cadastrar?");
            System.out.println("1-Sim;     2-Não;");

            switch (entrada.nextInt()){
                case 1:
                    this.cadastrarProdutos();
                    break;
                case 2:
                    System.out.println("Voltando Para o Menu!");
                    break;
                default:
                    System.out.println("Opção Inválidada!");
            }
        } else {
            System.out.println("PRODUTOS: \n");
            for (int i = 0; i < listaProdutos.size(); i++){
                System.out.println((i+1) + " - " + listaProdutos.get(i).toString());
            }
        }
        return listaProdutos;
    }

    public Produto retornaById() throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ProdutoController pc = new ProdutoController();

        System.out.println("Selecione o Produto: ");
        List<Produto> listaProduto = this.listarProdutos();

        if(listaProduto.isEmpty()){
            System.out.println("Nenhum Produto Cadastrado!");
            System.out.println("Cadastre um!");
            this.cadastrarProdutos();
        }

        System.out.println("Escolha o Produto");

        Produto produto = pc.selectById(listaProduto.get(entrada.nextInt()-1).getId());

        System.out.println("----------------------");
        System.out.println("Produto Selecionado: ");
        System.out.println(produto.toString());

        return produto;
    }

    public void deletarProduto() throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ProdutoController pc = new ProdutoController();

        System.out.println("DELETAR PRODUTO");

        Produto produto = this.retornaById();

        System.out.println("Tem certeza que deseja deletar o Produto?");
        System.out.println("1-SIM;                             2-NÃO;");

        switch (entrada.nextInt()){
            case 1:
                pc.deletarProduto(produto);
                break;
            case 2:
                System.out.println("Operação Cancelada!");
                break;
            default:
                System.out.println("Opção Inválida!");
        }
    }

    public void editarProduto() throws IOException, SQLException {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ProdutoController pc = new ProdutoController();
        CategoriaView categoriaView = new CategoriaView();
        ModeloView modeloView = new ModeloView();
        MarcaView mv = new MarcaView();
        CorView cv = new CorView();
        int op = 1;

        System.out.println("EDITAR PRODUTO");

        Produto produto = this.retornaById();

        System.out.println("Selecione o que você quer editar!");
        System.out.println("0-Codigo;1-Nome;2-Preço;3-Quantidade;4-Categoria;5-Modelo;6-Marca;7-Cor;8-Tamanho;9-Fornecedor");

        switch (entrada.nextInt()) {
            case 0:
                System.out.print("CÓDIGO: ");
                produto.setCodigo(entrada.nextInt());
                break;
            case 1:
                System.out.print("NOME: ");
                produto.setNome(entrada.next());
                break;
            case 2:
                System.out.print("PREÇO: ");
                produto.setPreco(entrada.nextDouble());
                break;
            case 3:
                System.out.print("QUANTIDADE: ");
                produto.setQtd(entrada.nextInt());
                break;
            case 4:
                System.out.println("CATEGORIA:");
                Categoria categoria = categoriaView.selectById();
                produto.setCategoria(categoria);
                break;
            case 5:
                System.out.println("1-Adicionar Modelos;2-Remover Modelos");
                switch (entrada.nextInt()){
                    case 1:
                        ModeloProduto modeloProduto = new ModeloProduto();
                        while (op != 0) {
                            ModelosDosProdutos modelo = modeloView.selecionaModeloById();
                            modeloProduto.getModelos().add(modelo);
                            System.out.println("Deseja Selecionar mais um Modelo para esse Produto?");
                            System.out.println("1 - SIM;                                   0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        produto.setModelo(modeloProduto);
                        break;
                    case 2:
                        while (op != 0) {
                            ModelosDosProdutos modelo = modeloView.selectModeloProdutoId(produto);
                            pc.deletarModeloProduto(modelo,produto);
                            produto.getModelo().getModelos().remove(modelo);
                            System.out.println("Deseja Deletar mais um Modelo desse Produto?");
                            System.out.println("1 - SIM;                            0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
                break;
            case 6:
                System.out.println("MARCA");
                Marca marca = mv.retornaById();
                produto.setMarca(marca);
                break;
            case 7:
                System.out.println("1-Adicionar Cor;2-Remover Cor");
                switch (entrada.nextInt()){
                    case 1:
                        CorProduto corProduto = new CorProduto();
                        while (op != 0) {
                            Cor cor = cv.selecionaCoresById();
                            corProduto.getCores().add(cor);
                            System.out.println("Deseja Selecionar mais uma Cor para esse Produto?");
                            System.out.println("1 - SIM;                                 0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        produto.setCores(corProduto);
                        break;
                    case 2:
                        while (op != 0) {
                            Cor cor = cv.selectCorProdutoId(produto);
                            pc.deletarCorProduto(cor,produto);
                            produto.getCores().getCores().remove(cor);
                            System.out.println("Deseja Deletar mais uma Cor desse Produto?");
                            System.out.println("1 - SIM;                          0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                System.out.println("Opção Inválida");
        }

        pc.editarProduto(produto);
    }

}
