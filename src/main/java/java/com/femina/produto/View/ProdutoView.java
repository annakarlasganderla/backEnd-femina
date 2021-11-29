package java.com.femina.produto.View;

import main.java.com.femina.produto.View.CategoriaView;
import main.java.com.femina.produto.View.CorView;
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
        CorView cv = new CorView();
        MarcaView mv = new MarcaView();
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

        System.out.println("Selecione a Marca do Produto:");
        Marca marca = mv.retornaById();
        prod.setMarca(marca);

        System.out.println("Selecione as cores do produto:");
        CorProduto corProduto = new CorProduto();
        while (op != 0) {
            Cor cor = cv.selecionaCoresById();
            corProduto.getCores().add(cor);
            System.out.println("Deseja Selecionar mais uma cor para esse produto?");
            System.out.println("1 - SIM;                                 0 - NÃO;");
            op = entrada.nextInt();
        }
        prod.setCores(corProduto);
        pc.cadastrarProduto(prod);
//        System.out.println("Selecione um Fornecedor");
//
//        List<Fornecedor> lfd = fv.mostrarFornecedores();
//        prod.setFornecedor(lfd.get(entrada.nextInt() - 1));

    }

    public void listarProdutos() throws SQLException, IOException {

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
//
//    public void deletarProduto() throws IOException {
//        ProdutoController pc = new ProdutoController();
//        CorView cv = new CorView();
//        ModeloView mv = new ModeloView();
//        TamanhoView tv = new TamanhoView();
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//
//        for(int i = 0; i < lpd.size();i++){
//            System.out.println((i+1)+" - "+lpd.get(i).toMostra());
//        }
//
//        System.out.println("Escolha qual produto quer Deletar");
//        int select = entrada.nextInt();
//
//        cv.removeCor(lpd.get(select-1).getId());
//        mv.deletaModelo(lpd.get(select-1).getId());
//        tv.deletarTamanho((int) lpd.get(select-1).getId());
//
//        lpd.remove(select - 1);
//
//        pc.removerProduto(lpd);
//    }



}
