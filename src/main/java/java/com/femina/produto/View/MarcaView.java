//package main.java.com.femina.produto.View;
//
//import main.java.com.femina.produto.Model.Contatos;
//import main.java.com.femina.produto.Model.Endereco;
//import main.java.com.femina.produto.Model.Fornecedor;
//import main.java.com.femina.produto.Model.Marca;
//import main.java.com.femina.produto.Controller.MarcaController;
//
//import java.io.*;
//import java.util.*;
//
//public class MarcaView {
//
//    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//
//    public void cadastrarMarca() throws IOException {
//        MarcaController marcaController = new MarcaController();
//        ContatoView cv = new ContatoView();
//        EndereçoView ev = new EndereçoView();
//
//        Marca marca = new Marca();
//
//        System.out.println("Digite o nome da marca: ");
//        marca.setNome(leitor.next());
//
//        Contatos contato = cv.cadastraContato("marca");
//        marca.setContatos(contato);
//
//        Endereco endereco = ev.cadastraEndereco("marca");
//        marca.setEnderecoMarca(endereco);
//
//        List<Marca> ldm = marcaController.mostraMarcaCadastrada();
//        ldm.add(marca);
//        marcaController.cadastraMarca(ldm);
//        System.out.println("Marca cadastrada com sucesso" );
//    }
//
//    public void mostrarMarcas() throws IOException {
//
//        MarcaController mc = new MarcaController();
//
//        List<Marca> listaDeMarcas = mc.mostraMarcaCadastrada();
//
//        for (int i = 0; i < listaDeMarcas.size(); i++) {
//            System.out.println(listaDeMarcas.get(i).toMostra());
//        }
//
//    }
//
//    public void editarMarcas() throws IOException {
//
//        MarcaController mc = new MarcaController();
//        ContatoView cv = new ContatoView();
//        EndereçoView ev = new EndereçoView();
//        List<Marca> listaDeMarcas = mc.mostraMarcaCadastrada();
//
//        for(int i = 0; i < listaDeMarcas.size(); i++) {
//            System.out.println((i+1) + " - " + listaDeMarcas.get(i).toMostra());
//        }
//
//        System.out.println("Escolha qual marca você quer editar: ");
//        int opMarca = leitor.nextInt();
//        System.out.println("1 - Nome da marca;2 - Contato da marca;3 - Endereço da marca");
//        int opItem = leitor.nextInt();
//        switch (opItem) {
//            case 1:
//                listaDeMarcas.get(opMarca - 1).setNome(leitor.next());
//                break;
//            case 2:
//                cv.editContato((int) listaDeMarcas.get(opMarca-1).getContatos().getId(),"marca");
//                break;
//            case 3:
//                ev.editEndereco((int) listaDeMarcas.get(opMarca-1).getEnderecoMarca().getIdEndereco(),"marca");
//                break;
//
//            default:
//                System.out.println("Opção inválida");
//                break;
//        }
//
//        mc.editaMarca(listaDeMarcas);
//        System.out.println("Marca editada com sucesso!");
//    }
//
//    public void deletaMarca() throws IOException {
//
//        MarcaController mc = new MarcaController();
//        ContatoView cv = new ContatoView();
//        EndereçoView ev = new EndereçoView();
//        List<Marca> listaDeMarcas = mc.mostraMarcaCadastrada();
//
//        for (int i = 0; i < listaDeMarcas.size();i++) {
//            System.out.println((i+1) + " - " + listaDeMarcas.get(i).toMostra());
//        }
//
//        System.out.println("Escolha qual marca você quer deletar: ");
//        int opMarca = leitor.nextInt();
//
//        cv.deletContato(opMarca,"marca");
//        ev.deletEndereco(opMarca,"marca");
//        listaDeMarcas.remove(opMarca - 1);
//
//        mc.deletaMarca(listaDeMarcas);
//
//        System.out.println(".\nMarca deletada com sucesso!");
//
//    }
//
//}
