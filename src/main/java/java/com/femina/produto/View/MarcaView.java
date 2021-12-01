package java.com.femina.produto.View;

import java.com.femina.produto.Controller.MarcaController;
import java.com.femina.produto.Dao.MarcaDao;
import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Marca;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MarcaView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public void menu() {

        Scanner leitor = new Scanner(System.in).useDelimiter("\n");
        MarcaView mv = new MarcaView();

        ContatoView cv = new ContatoView();

        mv.criaTabela();

        System.out.println("Escolha uma opção:");

        System.out.println("  1 - Cadastrar Marca ");
        System.out.println("  2 - Mostrar Marcas  ");
        System.out.println("  3 - Deletar Contatos   ");


        switch (leitor.nextInt()) {
            case 1:
                mv.cadastraMarca();
                this.menu();
                break;
            case 2:
                mv.mostraMarca();
                this.menu();
                break;
            case 3:
                mv.mostraMarca();
                mv.deletarMarca(mv.retornaById());
                this.menu();
                break;
            default:
                System.out.println("Opção invalida");
        }
    }


    public void criaTabela() {

        MarcaDao marcDao = new MarcaDao();
        marcDao.criaTabela();

    }

    public void cadastraMarca() {
        Marca marca = new Marca();

        System.out.println("Digite o Nome da Marca Cadastrada: ");
        marca.setNome(leitor.next());

        ContatoView cv = new ContatoView();
        Contatos contato = cv.cadastraContato();
        marca.setContatos(contato);

        MarcaController mc = new MarcaController();
        mc.cadastraMarca(marca);
    }

    public void mostraMarca() {

        MarcaController mc = new MarcaController();
        List<Marca> listaDeContatos = mc.mostraTabela();
        for (int i = 0; i < listaDeContatos.size(); i++) {
            System.out.println(listaDeContatos.get(i));
        }

    }

    public Marca retornaById() {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        Marca marc = new Marca();
        MarcaController mc = new MarcaController();

        System.out.println("Qual o id você quer selecionar:");

        marc = mc.seleionaById(entrada.nextInt());

        System.out.println("A marca selecionado foi:");
        System.out.println(marc);

        return marc;
    }


    public void deletarMarca(Marca marc) {

        MarcaController mc = new MarcaController();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Tem certeza que deseja deletar essa Marca?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()) {
            case 1:
                mc.deletaMarca(marc);
                break;
            case 2:
                System.out.println("Operação cancelada");
                break;
            default:
                System.out.println("Opção invalida");
        }


    }
}
