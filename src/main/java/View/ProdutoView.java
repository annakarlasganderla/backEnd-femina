package View;

import Model.*;

import Controller.ProdutoController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class ProdutoView {

    public void cadastrarProdutos(Lojas loja) throws SQLException, IOException {

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

        pc.cadastrarProduto(prod, loja);

    }

    public List<Produto> listarProdutos(Lojas loja) throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        ProdutoController pc = new ProdutoController();
        List<Produto> listaProdutos = pc.listarProdutos(loja);

        if(listaProdutos.isEmpty()){
            System.out.println("Nenhum Produto Cadastrado!");
            System.out.println("Deseja Cadastrar?");
            System.out.println("1-Sim;     2-Não;");

            switch (entrada.nextInt()){
                case 1:
                    this.cadastrarProdutos(loja);
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

    public Produto retornaById(Lojas loja) throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ProdutoController pc = new ProdutoController();

        System.out.println("Selecione o Produto: ");
        List<Produto> listaProduto = this.listarProdutos(loja);

        if(listaProduto.isEmpty()){
            System.out.println("Nenhum Produto Cadastrado!");
            System.out.println("Cadastre um!");
            this.cadastrarProdutos(loja);
        }

        System.out.println("Escolha o Produto");

        Produto produto = pc.selectById(listaProduto.get(entrada.nextInt()-1).getId(), loja);

        System.out.println("--------------------------");
        System.out.println("Produto Selecionado:      ");
        System.out.println(produto.toString());

        return produto;
    }

    public void deletarProduto(Lojas loja) throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ProdutoController pc = new ProdutoController();

        System.out.println("DELETAR PRODUTO");

        Produto produto = this.retornaById(loja);

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

    public void editarProduto(Lojas loja) throws IOException, SQLException {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        ProdutoController pc = new ProdutoController();
        CategoriaView categoriaView = new CategoriaView();
        ModeloView modeloView = new ModeloView();
        TamanhoView tamanhoView = new TamanhoView();
        MarcaView mv = new MarcaView();
        CorView cv = new CorView();
        FornecedorView fv = new FornecedorView();
        int op = 1;

        System.out.println("EDITAR PRODUTO");

        Produto produto = this.retornaById(loja);

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
                System.out.println("CATEGORIA: ");
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
                        pc.updateModelo(produto);
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
                        pc.updateCor(produto);
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
                System.out.println("1-Adicionar Tamanho;2-Remover Tamanho");
                switch (entrada.nextInt()){
                    case 1:
                        TamanhoProduto tamanhoProduto = new TamanhoProduto();
                        while (op != 0) {
                            Tamanho tamanho = tamanhoView.listarTamanhosDoProduto();
                            tamanhoProduto.getTamanhos().add(tamanho);
                            System.out.println("Deseja Selecionar mais um Tamanho para esse Produto?");
                            System.out.println("1 - SIM;                                   0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        produto.setTamanhos(tamanhoProduto);
                        pc.updateTamanho(produto);
                        break;
                    case 2:
                        while (op != 0) {
                            Tamanho tamanho = tamanhoView.selectTamanhoProdutoId(produto);
                            pc.deletarTamanhoProduto(tamanho,produto);
                            produto.getTamanhos().getTamanhos().remove(tamanho);
                            System.out.println("Deseja Deletar mais um Tamanho desse Produto?");
                            System.out.println("1 - SIM;                             0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
                break;
            case 9:
                System.out.println("1-Adicionar Fornecedor;2-Remover Fornecedor");
                switch (entrada.nextInt()){
                    case 1:
                        FornecedorProduto fornecedorProduto = new FornecedorProduto();
                        while (op != 0) {
                            Fornecedor fornecedor = fv.selectFornecedorById();
                            fornecedorProduto.getFornecedores().add(fornecedor);
                            System.out.println("Deseja Selecionar mais um Fornecedor para esse Produto?");
                            System.out.println("1 - SIM;                                       0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        produto.setFornecedor(fornecedorProduto);
                        pc.updateFornecedor(produto);
                        break;
                    case 2:
                        while (op != 0) {
                            Fornecedor fornecedor = fv.selectFornecedorProdutoId(produto);
                            pc.deletarFornecedorProduto(fornecedor,produto);
                            produto.getFornecedor().getFornecedores().remove(fornecedor);
                            System.out.println("Deseja Deletar mais um Fornecedor desse Produto?");
                            System.out.println("1 - SIM;                                0 - NÃO;");
                            op = entrada.nextInt();
                        }
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
                break;
            default:
                System.out.println("Opção Inválida");
        }
        pc.editarProduto(produto);
    }

    public void menuProduto(Lojas loja) throws SQLException, IOException {
        Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        MenuView mv = new MenuView();
        ProdutoController produtoController = new ProdutoController();
        produtoController.criarTabelasProduto();

        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|             PRODUTOS              |");
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Voltar                 |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Editar                 |");
                System.out.println("|        4 - Deletar                |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    mv.menuDeLoja(loja);
                    break;

                case 1:
                    do {
                        this.cadastrarProdutos(loja);

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.listarProdutos(loja);
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.editarProduto(loja);
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 4:
                    this.deletarProduto(loja);
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida");
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;
            }

        } while (op != 0);

    }

}
