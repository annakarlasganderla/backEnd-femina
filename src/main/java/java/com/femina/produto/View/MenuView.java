//package main.java.com.femina.produto.View;
//
//import main.java.com.femina.produto.Model.Fornecedor;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class MenuView {
//
//    public void menuPrincipal() throws IOException {
//        Scanner entrada = new Scanner(System.in);
//        LojasView lojasView = new LojasView();
//        System.out.println("-------------------");
//        System.out.println("1 - Acessar Lojas  ");
//        System.out.println("2 - Cadastrar Lojas");
//        System.out.println("3 - Listar Lojas   ");
//        System.out.println("0 - Sair           ");
//        System.out.println("-------------------");
//        int escolha = entrada.nextInt();
//        switch (escolha){
//            case 1:
//                lojasView.acessarLoja();
//                menuPrincipal();
//                break;
//            case 2:
//                lojasView.cadastrarLoja();
//                menuPrincipal();
//                break;
//            case 3:
//                lojasView.verLojas();
//                menuPrincipal();
//                break;
//            case 0:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public void menuDeLoja(long idLoja) throws IOException {
//        Scanner entrada = new Scanner(System.in);
//        System.out.println("----------------------------");
//        System.out.println("1 - Acessar Funcionarios    ");
//        System.out.println("2 - Acessar Categorias      ");
//        System.out.println("3 - Ofertas                 ");
//        System.out.println("4 - Todos os Produtos       ");
//        System.out.println("5 - Fornecedores            ");
//        System.out.println("0 - Sair                    ");
//        System.out.println("----------------------------");
//        int escolha = entrada.nextInt();
//        switch (escolha){
//
//            case 1:
//                menuFuncionarios(idLoja);
//                break;
//            case 2:
//                menuCategorias(idLoja);
//                break;
//            case 3:
//                menuOfertas(idLoja);
//                break;
//            case 4:
//                menuProdutos(idLoja);
//                break;
//            case 5:
//                menuFornecedor(idLoja);
//                break;
//            case 0:
//                menuPrincipal();
//                break;
//        }
//    }
//
//    public void menuFuncionarios(long idLoja) throws IOException {
//        ViewFuncionarios viewFuncionarios = new ViewFuncionarios();
//        Scanner entrada = new Scanner(System.in);
//        System.out.println("-------------------------");
//        System.out.println("1 - Cadastrar Funcionario");
//        System.out.println("2 - Listar Funcionarios  ");
//        System.out.println("3 - Editar Funcionarios  ");
//        System.out.println("0 - Sair                 ");
//        System.out.println("-------------------------");
//        int escolha = entrada.nextInt();
//        switch (escolha){
//            case 1:
//                viewFuncionarios.cadastrarFuncionarios();
//                menuFuncionarios(idLoja);
//                break;
//            case 2:
//                viewFuncionarios.mostrarFuncionarios();
//                menuFuncionarios(idLoja);
//                break;
//            case 3:
//                System.out.println("Com um bug na hora de salvar o funcionario editado");
////                viewFuncionarios.editFuncionarios();
//                menuFuncionarios(idLoja);
//                break;
//            case 0:
//                menuDeLoja(idLoja);
//                break;
//        }
//    }
//
//    public void menuCategorias(long idLoja) throws IOException {
//
//         CategoriaView CV = new CategoriaView();
//
//        Scanner entrada = new Scanner(System.in);
//        System.out.println("-----------------------");
//        System.out.println("1 - Cadastrar Categoria");
//        System.out.println("2 - Ver Categorias      ");
//        System.out.println("3 - Editar Categoria   ");
//        System.out.println("4 - Remover Categoria  ");
//        System.out.println("0 - Voltar             ");
//        System.out.println("-----------------------");
//
//        int escolha = entrada.nextInt();
//        switch (escolha){
//            case 0:
//                menuDeLoja(idLoja);
//                break;
//            case 1:
//                CV.cadastrarCategoria();
//                menuDeLoja(idLoja);
//                break;
//            case 2:
//                CV.mostrarListaDeCategorias();
//                menuDeLoja(idLoja);
//                break;
//            case 3:
//                CV.editarCategoriaByIdProduto();
//                menuDeLoja(idLoja);
//                break;
//            case 4:
//                CV.removerCategoriaByIdProduto();
//                menuDeLoja(idLoja);
//                break;
//        }
//    }
//
//    public void menuOfertas(long idLoja) throws IOException {
//        Scanner entrada = new Scanner(System.in);
//        OfertasView ofertasView = new OfertasView();
//        System.out.println("--------------------");
//        System.out.println("1 - Cadastrar Oferta");
//        System.out.println("2 - Listar Ofertar  ");
//        System.out.println("3 - Excluir Oferta  ");
//        System.out.println("0 - Sair            ");
//        System.out.println("--------------------");
//        int escolha = entrada.nextInt();
//        switch (escolha){
//            case 1:
//                ofertasView.cadastrarOfertas();
//                menuOfertas(idLoja);
//                break;
//            case 2:
//                ofertasView.listarOfertas();
//                menuOfertas(idLoja);
//                break;
//            case 3:
//                ofertasView.excluirOferta();
//                menuOfertas(idLoja);
//                break;
//            case 0:
//                menuDeLoja(idLoja);
//                break;
//        }
//    }
//
//    public void menuProdutos(long idLoja) throws IOException {
//        Scanner entrada = new Scanner(System.in);
//        ProdutoView produtoView = new ProdutoView();
//        System.out.println("----------------------");
//        System.out.println("1 - Cadastrar Produto ");
//        System.out.println("2 - Mostrar Produto   ");
//        System.out.println("3 - Editar Produto    ");
//        System.out.println("4 - Deletar Produto   ");
//        System.out.println("0 - Sair              ");
//        System.out.println("----------------------");
//        int escolha = entrada.nextInt();
//        switch (escolha){
//            case 1:
//                produtoView.cadastro(idLoja);
//                menuProdutos(idLoja);
//                break;
//            case 2:
//                produtoView.mostrarProdutos();
//                menuProdutos(idLoja);
//                break;
//            case 3:
//                produtoView.alterarProduto();
//                menuProdutos(idLoja);
//                break;
//            case 4:
//                produtoView.deletarProduto();
//                menuProdutos(idLoja);
//                break;
//            case 0:
//                menuDeLoja(idLoja);
//                break;
//        }
//    }
//
//    public void menuFornecedor(long idLoja) throws IOException {
//        Scanner entrada = new Scanner(System.in);
//        FornecedorView fornecedorView = new FornecedorView();
//        System.out.println("-------------------------");
//        System.out.println("1 - Cadastrar Fornecedor ");
//        System.out.println("2 - Mostrar Fornecedor   ");
//        System.out.println("3 - Editar Fornecedor    ");
//        System.out.println("4 - Deletar Fornecedor   ");
//        System.out.println("0 - Sair                 ");
//        System.out.println("-------------------------");
//        int escolha = entrada.nextInt();
//        switch (escolha){
//            case 1:
//                fornecedorView.cadastro();
//                menuFornecedor(idLoja);
//                break;
//            case 2:
//                fornecedorView.mostrarFornecedores();
//                menuFornecedor(idLoja);
//                break;
//            case 3:
//                fornecedorView.alterarFornecedor();
//                menuFornecedor(idLoja);
//                break;
//            case 4:
//                fornecedorView.deletarFornecedor();
//                menuFornecedor(idLoja);
//                break;
//            case 0:
//                menuDeLoja(idLoja);
//                break;
//        }
//    }
//}
