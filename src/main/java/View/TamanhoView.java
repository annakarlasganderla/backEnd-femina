package View;

import Controller.TamanhoController;
import Dao.TamanhoDAO;

import Model.Tamanho;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TamanhoView {

    Scanner entrada = new Scanner(System.in);
    TamanhoController tamanhoController = new TamanhoController();
    List<Tamanho> tamanhos = new ArrayList<>();

    public void cadastrarTamanho(){
        Tamanho tamanho = new Tamanho();
        System.out.println("Tamanho:");
        String tamanhoValue = entrada.next();
        tamanho.setTam(tamanhoValue.toUpperCase(Locale.ROOT));
        tamanhos.add(tamanho);
        tamanhoController.cadastrarTamanho(tamanho);
    }

    public void mostrarTamanho(){
        List<Tamanho> listaTamanhos = tamanhoController.listarTamanho();

        for(int i = 0;i < listaTamanhos.size();i++){
            System.out.println(listaTamanhos.get(i).toString());
        }
    }

    public Tamanho listarTamanhosDoProduto() throws IOException {

        System.out.println("Selecione um tamanho:");
        this.mostrarTamanho();
        Tamanho tamanho = tamanhoController.listarTamanhosPeloIdProd(entrada.nextInt());
        System.out.println("O tamanho seleciona foi:");
        System.out.println(tamanho);
        return tamanho;
    }

    public void deletarTamanho(Tamanho idProd) throws IOException {
        this.listarTamanhosDoProduto();
        int op;

        System.out.println("Tem certeza que deseja deletar este Tamanho? 1 - Sim | 0 - Não");
        op = entrada.nextInt();

        switch (op) {
            case 1:
                tamanhoController.deletaTamanho(idProd);
                break;

            default:
                System.out.println("Opção invalida");
        }

    }

}