package View;

import Controller.ContatoController;
import Model.Contatos;

import java.util.*;

public class ContatoView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);


    public void menuContato(){

        Scanner leitor = new Scanner(System.in).useDelimiter("\n");
        ContatoView cv = new ContatoView();

        cv.criaTabela();

        System.out.println("Escolha uma opção:");

        System.out.println("  1 - Cadastrar Contato ");
        System.out.println("  2 - Mostrar Contatos  ");
        System.out.println("  3 - Editar Contatos   ");
        System.out.println("  4 - Deletar Contatos   ");


        switch (leitor.nextInt()){
            case 1:
                cv.cadastraContato();
                this.menuContato();
                break;
            case 2:
                cv.mostraContato();
                this.menuContato();
                break;
            case 3:
                cv.mostraContato();
                cv.editarContatos(cv.retornaById());
                this.menuContato();
                break;
            case 4:
                cv.mostraContato();
                cv.deletarProduto(cv.retornaById());
                this.menuContato();
                break;
            default:
                System.out.println("Opção invalida");
        }
    }

    public void criaTabela(){

        ContatoController cc = new ContatoController();
        cc.criaTabela();

    }

    public Contatos cadastraContato() {

        System.out.println("Digite o Numero de contato: ");
        String telefone = leitor.next();

        System.out.println("Digite o e-mail de contato: ");
        String email  = leitor.next();

        Contatos contato = new Contatos(telefone, email);

        ContatoController contatoController = new ContatoController();
        contatoController.cadastraContato(contato);

        return contato;

    }

    public void mostraContato()  {

        ContatoController cc = new ContatoController();
        List<Contatos> listaDeContatos  = cc.mostraTabela();
        for(int i = 0; i < listaDeContatos.size(); i++) {
            System.out.println(listaDeContatos.get(i));
        }

    }

    public Contatos retornaById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        ContatoController pc = new ContatoController();

        System.out.println("Qual o id você quer selecionar:");

        Contatos cont = pc.seleionaById(entrada.nextInt());

        System.out.println("O produto selecionado foi:");
        System.out.println(cont);

        return cont;
    }

    public Contatos editarContatos(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        ContatoController cc = new ContatoController();

        System.out.println("Escolha o que você quer editar: ");

        Contatos cont = new Contatos();
        ContatoController pc = new ContatoController();

        System.out.println("Qual o id você quer selecionar:");

        cont = pc.seleionaById(entrada.nextInt());

        System.out.println("O produto selecionado foi:");
        System.out.println(cont);

        return cont;
    }

    public void editarContatoLoja(Contatos contatos){
        Contatos contatos1 = new Contatos();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        ContatoController contatoController = new ContatoController();
        System.out.println("O que deseja editar?");
        System.out.println("1 - Telefone    2 - Email");
        int oqueEditar = entrada.nextInt();
        if(oqueEditar == 1){
            System.out.println("Digite o novo telefone:");
            String novoTelefone = entrada.next();
            contatos1.setTel(novoTelefone);
        }else if(oqueEditar == 2){
            System.out.println("Digite o novo email:");
            String novoEmail = entrada.next();
            contatos1.setEmail(novoEmail);
        }else{
            System.out.println("Valor invalido");
            editarContatoLoja(contatos);
        }
        contatoController.editarContato(contatos1);
    }

    public void editarContatos(Contatos cont){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        ContatoController cc = new ContatoController();

        System.out.println("Escolha o que você quer editar: ");

        System.out.println("1-Telefone-----2-Mail;");

        switch (entrada.nextInt()){
            case 1:
                cont.setTel(entrada.next());
                break;
            case 2:
                cont.setEmail(entrada.next());
                break;
            default:
                System.out.println("error");
        }

        cc.editarContato(cont);

        System.out.println("Contato Editado!");
        System.out.println("Deseja Continuar?");
        System.out.println("1-Sim;2-Não;");

        System.out.println("Contato Editado!");
        System.out.println("Deseja Continuar?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                this.editarContatos(cont);
                break;
            case 2:
                System.out.println("Retornando ao Menu");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }


    public void deletarProduto(Contatos contatos){

        ContatoController cc = new ContatoController();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Tem certeza que deseja deletar o contato?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                cc.deletaContato(contatos);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }

    }

}