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

    public List<Produto> listarProdutos() throws SQLException, IOException {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

        ProdutoController pc = new ProdutoController();
        List<Produto> listaProdutos = pc.listarProdutos();

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

//    public void alterarProduto() throws IOException {
//        ProdutoController pc = new ProdutoController();
//        FornecedorView fv = new FornecedorView();
//        CorView cv = new CorView();
//        ModeloView mv = new ModeloView();
//        TamanhoView tv = new TamanhoView();
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//
//        List<Produto> lpd = pc.listarProdutos();
//        for(int i = 0; i < lpd.size();i++){
//            System.out.println((i+1)+" - "+lpd.get(i).toMostra());
//        }
//        System.out.println("Escolha qual produto quer editar");
//        int select = entrada.nextInt();
//        System.out.println("Selecione: 1-Código;2-Nome;3-Preço;4-Quantidade;5-Trocar Fornecedor;6-Cor;7-Modelo");
//        int selectItem = entrada.nextInt();
//        switch (selectItem) {
//            case 1:
//                System.out.print("Código-" + lpd.get(select - 1).getCodigo() + ": ");
//                lpd.get(select-1).setCodigo(entrada.nextInt());
//                break;
//            case 2:
//                System.out.print("Nome-" + lpd.get(select - 1).getNome() + ": ");
//                lpd.get(select-1).setNome(entrada.next());
//                break;
//            case 3:
//                System.out.print("Preço-" + lpd.get(select - 1).getPreco() + ": ");
//                lpd.get(select-1).setPreco(entrada.nextDouble());
//                break;
//            case 4:
//                System.out.print("Quantidade-" + lpd.get(select - 1).getQtd() + ": ");
//                lpd.get(select-1).setQtd(entrada.nextInt());
//                break;
//            case 5:
//                System.out.println("Selecione o novo fornecedor:");
//                List<Fornecedor> lfd = fv.mostrarFornecedores();
//                lpd.get(select-1).setFornecedor(lfd.get(entrada.nextInt()  - 1));
//                break;
//            case 6:
//                cv.editaCor(lpd.get(select-1).getId());
//                break;
//            case 7:
//                mv.editaModelo(lpd.get(select-1).getId());
//                break;
//            default:
//                System.out.println("Opção Inválida");
//        }
//
//        pc.editarProduto(lpd);
//    }

}
