package View;

import Controller.ModeloController;
import Model.ModelosDosProdutos;
import Model.Produto;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ModeloView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    ModeloController modeloController = new ModeloController();

    public void cadastrarModelos() {

        ModeloController modeloController = new ModeloController();
        ModelosDosProdutos modelosDosProdutos = new ModelosDosProdutos();

        System.out.println("Digite o nome do modelo: ");
        modelosDosProdutos.setNomeTipo(leitor.next());

        modeloController.cadastrarModelo(modelosDosProdutos);

        System.out.println("Deseja continuar cadastrando?");
        System.out.println("1-SIM;                 2-NÃO;");

        switch (leitor.nextInt()){
            case 1:
                this.cadastrarModelos();
            break;
            case 2:
                System.out.println("Voltando pro menu!");
            break;
            default:
                System.out.println("Opção inválida!");
        }

    }

    public List<ModelosDosProdutos> listarModelos() {

       ModeloController modeloController = new ModeloController();

       List<ModelosDosProdutos> listaModelos = modeloController.listarModelos();
       if(listaModelos.isEmpty()){
           System.out.println("Nenhum Modelo cadastrado!");
           System.out.println("Deseja Cadastrar?");
           System.out.println("1-Sim;     2-Não;");
           switch (leitor.nextInt()){
               case 1:
                   this.cadastrarModelos();
                   break;
               case 2:
                   System.out.println("Voltando pro menu!");
                   break;
               default:
                   System.out.println("Opção inválida!");
           }
       } else {
           System.out.println("MODELOS: ");
           for (int i = 0; i < listaModelos.size(); i++) {
               System.out.println("   " + (i + 1) + " - " + listaModelos.get(i).toString());
           }
       }

       return listaModelos;
    }

    public ModelosDosProdutos selecionaModeloById(){

        ModeloController modeloController = new ModeloController();

        List<ModelosDosProdutos> listaModelos = this.listarModelos();

        if(listaModelos.isEmpty()){
            this.cadastrarModelos();
        }

        System.out.println("Escolha o Modelo: ");

        ModelosDosProdutos modelo = modeloController.selecionaModeloById(listaModelos.get(leitor.nextInt()-1).getId());

        System.out.println("-------------------------------");
        System.out.println("Modelo Selecionado: ");
        System.out.println(modelo.toString());
        System.out.println("-------------------------------");

        return modelo;
    }

    public ModelosDosProdutos selectModeloProdutoId(Produto produto){

        ModeloController modeloController = new ModeloController();

        List<ModelosDosProdutos> listaModelos = modeloController.listarModelosProdutos(produto);

        if(listaModelos.isEmpty()){
            System.out.println("Esse produto não tem nenhum modelo!");
        } else {

            for(int i = 0; i < listaModelos.size();i++) {
                System.out.println(listaModelos.get(i).toString());
            }

            System.out.println("Escolha o Modelo: ");

            ModelosDosProdutos modelo = modeloController.selecionaModeloById(listaModelos.get(leitor.nextInt() - 1).getId());

            System.out.println("-------------------------------");
            System.out.println("Modelo Selecionado: ");
            System.out.println(modelo.toString());
            System.out.println("-------------------------------");

            return modelo;
        }
        return null;
    }

    public void deletaModelo (ModelosDosProdutos modelo) {

        ModeloController modeloController = new ModeloController();

        System.out.println("Tem certeza que deseja deletar o modelo?");
        System.out.println("1-Sim;                            2-Não;");

        switch (leitor.nextInt()){
            case 1:
                modeloController.deletarModelo(modelo);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }

    }

    public void menuModelo() {
        int op = 0;
        char control = 's';
        modeloController.criarTabela();

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|             MODELOS               |");
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Deletar                |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = leitor.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastrarModelos();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = leitor.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 2:
                    this.listarModelos();
                    System.out.println("5 - Voltar");
                    op = leitor.nextInt();
                    break;

                case 3:
                    this.deletaModelo(selecionaModeloById());
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
