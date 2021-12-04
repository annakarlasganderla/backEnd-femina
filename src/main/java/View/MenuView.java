package View;

import Model.Lojas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuView {

    public void menuPrincipal() throws IOException, SQLException {
        Scanner entrada = new Scanner(System.in);
        LojasView lojasView = new LojasView();
        System.out.println("-------------------");
        System.out.println("|  FEMINA SYSTEM  |");
        System.out.println("-------------------");
        System.out.println("1 - Acessar Lojas  ");
        System.out.println("2 - Cadastrar Lojas");
        System.out.println("3 - Listar Lojas   ");
        System.out.println("0 - Sair           ");
        System.out.println("-------------------");
        int escolha = entrada.nextInt();
        switch (escolha){
            case 1:
                lojasView.acessarLoja();
                menuPrincipal();
                break;
            case 2:
                lojasView.cadastrarLoja();
                menuPrincipal();
                break;
            case 3:
                lojasView.verLojas();
                menuPrincipal();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public void menuDeLoja(Lojas idLoja) throws IOException, SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("        Loja: "+idLoja.getNome()+"       ");
        System.out.println("----------------------------");
        System.out.println("1 - Acessar Funcionarios    ");
        System.out.println("2 - Acessar Categorias      ");
        System.out.println("3 - Todos os Produtos       ");
        System.out.println("4 - Fornecedores            ");
        System.out.println("5 - Cor/Tamanho/Modelo      ");
        System.out.println("0 - Sair                    ");
        System.out.println("----------------------------");
        int escolha = entrada.nextInt();
        switch (escolha){

            case 1:
//                menuFuncionarios(idLoja);
                break;
            case 2:
                menuCategorias(idLoja);
                break;
            case 3:
                menuProdutos(idLoja);
                break;
            case 4:
                menuFornecedor(idLoja);
                break;
            case 5:
                menuOutros();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }

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
//                viewFuncionarios.editFuncionarios();
//                menuFuncionarios(idLoja);
//                break;
//            case 0:
//                menuDeLoja(idLoja);
//                break;
//        }
//    }

    public void menuCategorias(Lojas loja) throws IOException, SQLException {

        CategoriaView CV = new CategoriaView();

        CV.menuCategoria(loja);

    }

    public void menuProdutos(Lojas idLoja) throws IOException, SQLException {
        ProdutoView produtoView = new ProdutoView();

        produtoView.menuProduto(idLoja);

    }

    public void menuFornecedor(Lojas loja) throws IOException, SQLException {
        FornecedorView fv = new FornecedorView();
        fv.menuFornecedor(loja);
    }

    public void menuOutros() throws SQLException, IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("|          MENU            |");
        System.out.println("----------------------------");
        System.out.println("    1 - Cores               ");
        System.out.println("    2 - Tamanhos            ");
        System.out.println("    3 - Modelos             ");
        System.out.println("    0 - Voltar              ");
        System.out.println("----------------------------");
        int escolha = entrada.nextInt();
        switch (escolha){

            case 1:
                CorView corView = new CorView();
                corView.menuCor();
                break;
            case 2:
                TamanhoView tamanhoView= new TamanhoView();
                tamanhoView.menuTamanho();
                break;
            case 3:
                ModeloView modeloView = new ModeloView();
                modeloView.menuModelo();
                break;
            case 0:
                menuPrincipal();
                break;
        }
    }
}
