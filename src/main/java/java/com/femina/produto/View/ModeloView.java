package main.java.com.femina.produto.View;

import main.java.com.femina.produto.Controller.ModeloController;
import main.java.com.femina.produto.Model.ModelosDosProdutos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ModeloView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public ModelosDosProdutos cadastrarModelos(Long idProd) throws IOException {

        ModeloController modeloController = new ModeloController();
        ModelosDosProdutos modelosDosProdutos = new ModelosDosProdutos();

        System.out.println("Digite o nome do modelo: ");
        modelosDosProdutos.setNomeTipo(leitor.next());

        modelosDosProdutos.setIdProduto(idProd);

        List<ModelosDosProdutos> listModelos = modeloController.mostraModelos();
        listModelos.add(modelosDosProdutos);

        modeloController.cadastraModelo(listModelos);

        return modelosDosProdutos;
    }

    public void mostrarModelos(List<ModelosDosProdutos> modelosDosProdutos)  throws IOException {

       ModeloController modeloController = new ModeloController();

       List<ModelosDosProdutos> listaModelos = modeloController.mostraModelos();

       for(int i = 0; i < listaModelos.size();i++) {
           System.out.println((i+1) + " - " + listaModelos.get(i).toMostra());
       }

    }

    public void editaModelo(Long idProd) throws IOException {

        ModeloController modeloController = new ModeloController();

        List<ModelosDosProdutos> listaDeModelos = modeloController.listarModelosPeloIdProd(idProd);

        List<ModelosDosProdutos> listModelosTotal = modeloController.mostraModelos();

        for (int i = 0; i < listaDeModelos.size();i++) {
            System.out.println((i+1) + " - " + listaDeModelos.get(i).toMostra());
        }

        System.out.println("Escolha qual modelo você quer editar: ");
        int opModelo = leitor.nextInt();

        System.out.println("Digite o novo nome do modelo:");
        listModelosTotal.get((int)listaDeModelos.get(opModelo-1).getId()-1).setNomeTipo(leitor.next());

        modeloController.editaModelo(listModelosTotal);
    }

    public void deletaModelo (Long idProd) throws IOException {

        ModeloController modeloController = new ModeloController();

        List<ModelosDosProdutos> modelosDosProdutos = modeloController.mostraModelos();
        List<ModelosDosProdutos> novalist = new ArrayList<>();

        for(int i = 0;i < modelosDosProdutos.size();i++) {
            if (modelosDosProdutos.get(i).getIdProduto() != idProd) {
                novalist.add(modelosDosProdutos.get(i));
            }
        }

        modeloController.deletaModelo(novalist);

    }

    public List<ModelosDosProdutos> listarModelosDoProduto(Long idProd) throws IOException {
        ModeloController modeloController = new ModeloController();
        return modeloController.listarModelosPeloIdProd(idProd);
    }

}
