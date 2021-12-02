package View;

import Controller.LojasController;
import Dao.LojasDAO;
import Model.Lojas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LojasView {

    Scanner entrada = new Scanner(System.in);
    Lojas lojas = new Lojas();
    EndereçoView endereçoView = new EndereçoView();
    LojasController lojasController = new LojasController();
    ContatoView contatoView = new ContatoView();

    public void cadastrarLoja(){
        System.out.println("Digite o nome da Loja:");
        lojas.setNome(entrada.next());
        System.out.println("Endereço:");
        lojas.setEndereco(endereçoView.cadastraEndereco());
        System.out.println("Contato:");
        lojas.setContatos(contatoView.cadastraContato());
        lojasController.cadastrarLojas(lojas);
    }

    public void verLojas(){

        System.out.println("Lojas cadastradas: ");
        List<Lojas> lojas = lojasController.listarTodasAsLojas();
        if(lojas.isEmpty()){
            System.out.println("Nenhuma loja cadastrada.");
        }else{
            int tamanhoLista = lojasController.listarTodasAsLojas().size();
            for(int i = 0; i < tamanhoLista; i++){
                System.out.println(lojasController.listarTodasAsLojas().get(i));
            }
        }
    }

    public void editarLojas(){
        System.out.println(lojasController.listarTodasAsLojas());
        System.out.print("Escolha a loja para editar:");
        int escolha = entrada.nextInt();
        System.out.println("Loja escolhida");
        System.out.println(lojasController.listarTodasAsLojas().get(escolha));
        System.out.println("O que deseja editar?");
        System.out.println("1 - Nome    2 - Endereço");
        System.out.println("3 - Contato");
        int editar = entrada.nextInt();
        switch (editar){
            case 1:
                lojasController.editarNomeLoja(lojasController.listarTodasAsLojas().get(escolha), lojasController.listarTodasAsLojas().get(escolha).getId());
                break;
            case 2:
                endereçoView.editarEndereco(lojasController.listarTodasAsLojas().get(escolha).getEndereco());
                break;
            case 3:
                contatoView.editarContatoLoja(lojasController.selectLojaById(escolha).getContatos());
                break;
        }
    }

    public void excluirLojas(){
        Scanner entrada = new Scanner(System.in);
        List<Lojas> listaDeLojas = lojasController.listarTodasAsLojas();
        System.out.println(listaDeLojas);
        System.out.println("Escolha  a loja a ser deletada:");
        int lojaEscolhida = entrada.nextInt();
        lojasController.deleteLoja(listaDeLojas.get(lojaEscolhida).getId());
    }

    public Lojas selectLojaById(){

        this.verLojas();

        System.out.println("Selecione uma Loja");
        Lojas loja = lojasController.selectLojaById(entrada.nextInt());

        System.out.println("A loja seleciona foi:");
        System.out.println(loja.toString());

        return loja;
    }

    public void acessarLoja() throws IOException, SQLException {

        Lojas lojas = this.selectLojaById();
        MenuView menuView = new MenuView();

        menuView.menuDeLoja(lojas);
    }
}
