package main.java.com.femina.produto.View;

import main.java.com.femina.produto.Controller.ContatoController;
import main.java.com.femina.produto.Model.Contatos;
import java.io.*;
import java.util.*;

public class ContatoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public Contatos cadastraContato(String arq) throws IOException {

        System.out.println("Digite o Numero de contato: ");
        String telefone = leitor.next();

        System.out.println("Digite o e-mail de contato: ");
        String email  = leitor.next();

        Contatos contato = new Contatos(telefone, email);

        ContatoController contatoController = new ContatoController();

        List<Contatos> listaDeContatos  = contatoController.mostraContato(arq);
        listaDeContatos.add(contato);

        contatoController.cadastraContato(listaDeContatos,arq);

        return contato;
    }

    public void mostraContato(String arq) throws IOException {

        ContatoController cc = new ContatoController();
        List<Contatos> listaDeContatos  = cc.mostraContato(arq);
        for(int i = 0; i < listaDeContatos.size(); i++) {
            System.out.println(listaDeContatos.get(i));
        }

    }

    public void editContato(int opProduto,String arq) throws IOException {

        ContatoController contatoController = new ContatoController();

        List<Contatos> listaContato = contatoController.mostraContato(arq);

        System.out.println(" 1 - telefone");
        System.out.println(" 2 - email");

        int opAtributo = leitor.nextInt();

        switch (opAtributo) {
            case 1:
                listaContato.get(opProduto - 1).setTel(leitor.next());
                break;

            case 2:
                listaContato.get(opProduto - 1).setEmail(leitor.next());
                break;

            default:
                System.out.println("Opção inválida");
        }

        contatoController.editaContato(listaContato,arq);

    }

    public void deletContato(int opDelete, String arq) throws IOException {

        ContatoController contatoController = new ContatoController();

        List<Contatos> listaContatos = contatoController.mostraContato(arq);

        listaContatos.remove(opDelete - 1);

        contatoController.deletaContatos(listaContatos,arq);
        System.out.print(".");
    }

}