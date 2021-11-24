//package main.java.com.femina.produto.View;
//
//import main.java.com.femina.produto.Model.Contatos;
//import main.java.com.femina.produto.Model.Endereco;
//import main.java.com.femina.produto.Model.Fornecedor;
//import main.java.com.femina.produto.Controller.FornecedorController;
//
//import java.io.IOException;
//import java.util.*;
//
//public class FornecedorView {
//
//    public void cadastro() throws IOException {
//
//        FornecedorController fc = new FornecedorController();
//        ContatoView cv = new ContatoView();
//        EndereçoView ev = new EndereçoView();
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//
//        Fornecedor forn = new Fornecedor();
//
//        System.out.println("Informe o nome do fornecedor");
//        forn.setNome(entrada.next());
//
//        System.out.println("Informe o CNPJ do fornecedor");
//        forn.setCnpj(entrada.next());
//
//        Contatos contato = cv.cadastraContato("fornecedor");
//        forn.setContatos(contato);
//
//        Endereco endereco = ev.cadastraEndereco("fornecedor");
//        forn.setEndereco(endereco);
//
//        List<Fornecedor> ldf = fc.listarFornecedores();
//        ldf.add(forn);
//
//        fc.cadastrarFornecedor(ldf);
//
//        System.out.println("Fornecedor cadastrado com sucesso!\n");
//    }
//
//    public List<Fornecedor> mostrarFornecedores(){
//        FornecedorController fc = new FornecedorController();
//        List<Fornecedor> lfd = fc.listarFornecedores();
//        for(int i = 0; i < lfd.size();i++){
//            System.out.println((i+1) + " - " + lfd.get(i).toMostra());
//        }
//        return lfd;
//    }
//
//    public void alterarFornecedor() throws IOException {
//        FornecedorController fc = new FornecedorController();
//        ContatoView cv = new ContatoView();
//        EndereçoView ev = new EndereçoView();
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//
//        List<Fornecedor> lfd = fc.listarFornecedores();
//        for(int i = 0; i < lfd.size();i++){
//            System.out.println((i+1) + " - " + lfd.get(i).toMostra());
//        }
//        System.out.println("Escolha qual fornecedor quer editar");
//        int select = entrada.nextInt();
//        System.out.println("Selecione: 1-Nome;2-CNPJ;3-Contato;4-Endereço");
//        int selectItem = entrada.nextInt();
//        switch (selectItem) {
//            case 1:
//                System.out.print("Nome-" + lfd.get(select - 1).getNome() + ": ");
//                lfd.get(select-1).setNome(entrada.next());
//                break;
//            case 2:
//                System.out.print("Cnpj-" + lfd.get(select - 1).getCnpj() + ": ");
//                lfd.get(select-1).setCnpj(entrada.next());
//                break;
//            case 3:
//                cv.editContato((int) lfd.get(select-1).getContatos().getId(),"fornecedor");
//                break;
//            case 4:
//                ev.editEndereco((int) lfd.get(select-1).getEndereco().getIdEndereco(),"fornecedor");
//                break;
//            default:
//                System.out.println("Opção Inválida");
//        }
//
//        fc.editarFornecedor(lfd);
//
//        System.out.println("Fornecedor editado com sucesso!\n");
//    }
//
//    public void deletarFornecedor() throws IOException {
//        FornecedorController fc = new FornecedorController();
//        ContatoView cv = new ContatoView();
//        EndereçoView ev = new EndereçoView();
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//
//        List<Fornecedor> lfd = fc.listarFornecedores();
//        for(int i = 0; i < lfd.size();i++){
//            System.out.println((i+1) + " - " + lfd.get(i).toMostra());
//        }
//        System.out.println("Escolha qual fornecedor quer Deletar");
//        int select = entrada.nextInt();
//
//        cv.deletContato(select,"fornecedor");
//        ev.deletEndereco(select,"fornecedor");
//        lfd.remove(select - 1);
//
//        fc.removerFornecedor(lfd);
//
//        System.out.println(".\nFornecedor deletado com sucesso!");
//    }
//
//}
