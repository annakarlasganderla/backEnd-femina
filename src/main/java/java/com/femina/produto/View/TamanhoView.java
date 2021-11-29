package java.com.femina.produto.View;

import java.com.femina.produto.Controller.TamanhoController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import main.java.com.femina.produto.Model.Tamanho;

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
        List<Tamanho> listaTamanhos = tamanhoController.listaTamanho();

        for(int i = 0;i < listaTamanhos.size();i++){
            System.out.println(listaTamanhos.get(i).toMostra());
        }
    }

    public Tamanho listarTamanhosDoProduto(int idProd) throws IOException {
        return tamanhoController.listarTamanhosPeloIdProd(idProd);
    }

    public void deletarTamanho(int idProd) throws IOException {
        tamanhoController.deletaTamanho(idProd);
    }
}