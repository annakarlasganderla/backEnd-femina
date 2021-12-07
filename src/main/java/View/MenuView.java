package View;

import Model.Cliente;
import Model.Lojas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuView {

    public void menuInicial() throws SQLException, IOException {
        Scanner entrada = new Scanner(System.in);
        int op = 1;
        do{
            System.out.println("----------------------");
            System.out.println("|    FEMINA SYSTEM   |");
            System.out.println("|--------------------|");
            System.out.println("|  1 - Cliente       |");
            System.out.println("|  2 - Funcionário   |");
            System.out.println("----------------------");

            switch (entrada.nextInt()){
                case 1:
                    menuLogin();
                    break;
                case 2:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (op!=0);
    }

    public void menuLogin() throws SQLException, IOException {
        Scanner entrada = new Scanner(System.in);
        ClienteView clienteView = new ClienteView();

        System.out.println("---------------------------");
        System.out.println("|       FEMINA SYSTEM     |");
        System.out.println("|-------------------------|");
        System.out.println("|     0 - Sair            |");
        System.out.println("|     1 - Cadastrar-se    |");
        System.out.println("|     2 - Logar           |");
        System.out.println("---------------------------");

        switch (entrada.nextInt()){
            case 1:
                System.out.println("---------------------------");
                System.out.println("|         CADASTRO        |");
                System.out.println("---------------------------");
                clienteView.cadastrarCliente();
                break;
            case 2:
                System.out.println("---------------------------");
                System.out.println("|         LOGIN           |");
                System.out.println("---------------------------");
                Cliente cliente = clienteView.loginCliente();
                if(cliente != null){
                    menuViewCliente(cliente);
                }
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

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
        System.out.println("5 - Clientes                ");
        System.out.println("6 - Cor/Tamanho/Modelo      ");
        System.out.println("7 - Destaques               ");
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
                menuClientes();
                break;
            case 6:
                menuOutros();
                break;
            case 7:
                menuDestaques(idLoja);
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

    public void menuClientes() throws IOException, SQLException {
        ClienteView clienteView = new ClienteView();
        clienteView.clienteMenu();
    }

    public void menuDestaques(Lojas lojas) throws SQLException, IOException {
        Scanner entrada = new Scanner(System.in);
        DestaquesView dv = new DestaquesView();

        System.out.println("----------------------------");
        System.out.println("|         DESTAQUES        |");
        System.out.println("----------------------------");
        System.out.println("    1 - Cadastrar           ");
        System.out.println("    2 - Mostrar             ");
        System.out.println("    0 - Voltar              ");
        System.out.println("----------------------------");

        switch (entrada.nextInt()){
            case 1:
                dv.cadastroDeDestaque(lojas);
                menuDestaques(lojas);
                break;
            case 2:
                dv.listarDestaques(lojas);
                menuDestaques(lojas);
                break;
            case 0:
                menuInicial();
                break;
        }
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

    public void menuViewCliente(Cliente cliente) throws SQLException, IOException {
        Scanner entrada = new Scanner(System.in);
        ProdutoView produtoView = new ProdutoView();
        LojasView lojasView = new LojasView();
        ClienteView cv = new ClienteView();
        DestaquesView dv = new DestaquesView();

        System.out.println("---------------------------");
        System.out.println("|          FEMINA         |");
        System.out.println("|-------------------------|");
        System.out.println("|     0 - Sair            |");
        System.out.println("|     1 - Ver Produtos    |");
        System.out.println("|     2 - Ver Perfil      |");
//        System.out.println("|     3 - Ver Favoritos   |");
        System.out.println("|     4 - Ver Destaques   |");
        System.out.println("---------------------------");

        switch (entrada.nextInt()){
            case 0:
                menuInicial();
                break;
            case 1:
                produtoView.listarProdutos(lojasView.selectLojaById());
                System.out.println("Deseja Favoritar Algum Produto?");
                System.out.println("1-SIM                     2-NÃO");
                switch (entrada.nextInt()){
                    case 1:

                        break;
                    case 2:
                        menuViewCliente(cliente);
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }
                break;
            case 2:
                cv.perfilCliente(cliente);
                menuViewCliente(cliente);
                break;
            case 3:
                break;
            case 4:
                Lojas idLoja = lojasView.selectLojaById();
                dv.listarDestaques(idLoja);
                menuViewCliente(cliente);
                break;
        }
    }
}
