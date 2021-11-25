//package main.java.com.femina.produto.View;
//
//import main.java.com.femina.produto.Controller.MarcaController;
//import main.java.com.femina.produto.Model.Cor;
//import main.java.com.femina.produto.Controller.CorController;
//import main.java.com.femina.produto.Model.Marca;
//
//import java.io.IOException;
//import java.util.*;
//
//public class CorView {
//    public Cor cadastro(long idProd) throws IOException {
//
//        Cor cor = new Cor();
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);;
//        CorController cc = new CorController();
//
//        System.out.println("Informe a cor:");
//        cor.setNome(entrada.next());
//
//        System.out.println("Informe o Hexadecimal:");
//        cor.setHexadecimal(entrada.next());
//
//        cor.setIdProduto(idProd);
//
//        List<Cor> ldc = cc.mostraCorCadastrada();
//        ldc.add(cor);
//
//        cc.cadastraCor(ldc);
//
//        return cor;
//    }
//    public void mostrarCor() throws IOException {
//
//        CorController cd = new CorController();
//
//        List<Cor> listaCores = cd.mostraCorCadastrada();
//
//        for (int i = 0; i < listaCores.size(); i++) {
//            System.out.println(listaCores.get(i).toMostra());
//        }
//
//    }
//    public void editaCor(Long idProd)  throws IOException {
//
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//        CorController cd = new CorController();
//
//        List<Cor> coresId = cd.listarCoresPeloId(idProd);
//
//        List<Cor> cores = cd.mostraCorCadastrada();
//
//        for(int i = 0;i < coresId.size();i++){
//            System.out.println((i+1) + " - " + coresId.get(i).toMostra());
//        }
//
//        System.out.println("Escolha qual cor quer editar");
//        int select = entrada.nextInt();
//        System.out.println("Selecione: 1-cor;2-hexadecimal");
//        int selectItem = entrada.nextInt();
//        switch (selectItem) {
//            case 1:
//                cores.get((int)coresId.get(select-1).getId()-1).setNome(entrada.next());
//                break;
//            case 2:
//                cores.get((int)coresId.get(select-1).getId()-1).setHexadecimal(entrada.next());
//                break;
//            default:
//                System.out.println("Opção inválida");
//        }
//
//        cd.editaCores(cores);
//
//    }
//
//    public void removeCor(Long idProd) throws IOException {
//
//        Scanner entrada = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
//        CorController cd = new CorController();
//
//        List<Cor> cores = cd.mostraCorCadastrada();
//        List<Cor> coresNew = new ArrayList<>();
//
//        for(int i = 0;i < cores.size();i++) {
//            if (cores.get(i).getIdProduto() != idProd) {
//                coresNew.add(cores.get(i));
//            }
//        }
//
//        cd.apagaCores(coresNew);
//
//    }
//
//    public List<Cor> listaCorDoProduto(Long idProd) throws IOException {
//        CorController cd = new CorController();
//        return cd.listarCoresPeloId(idProd);
//    }
//
//}
