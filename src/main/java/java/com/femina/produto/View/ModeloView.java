package java.com.femina.produto.View;

import Controller.ModeloController;
import Model.ModelosDosProdutos;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ModeloView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

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

        modeloController.deletarModelo(modelo);

    }


}
