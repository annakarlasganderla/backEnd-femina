//package main.java.com.femina.produto.Dao;
//
//import main.java.com.femina.produto.Controller.FavoritosController;
//import main.java.com.femina.produto.Model.Contatos;
//import main.java.com.femina.produto.Model.Favoritos;
//import main.java.com.femina.produto.View.FavoritosView;
//
//import java.util.*;
//import java.io.*;
//
//public class FavoritosDao {
//
//    public void gravaFavoritos(Favoritos fav) throws IOException {
//
//        List<Favoritos> listFav = retornaFavoritos();
//
//        try {
//
//            File arquivoDeTexto = new File ("favoritos.txt");
//
//            if(!arquivoDeTexto.isFile()){
//                arquivoDeTexto.createNewFile();
//            }
//
//            FileWriter fileWriter = new FileWriter(arquivoDeTexto, true);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            listFav.add(fav);
//            for(int i = 0;i < listFav.size();i++){
//                if(listFav.get(i).getId() != i+1) {
//                    listFav.get(i).setId(i + 1);
//                    printWriter.println(listFav.get(i));
//                }
//            }
//
//            printWriter.flush();
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public List<Favoritos> retornaFavoritos() throws IOException {
//
//        File arquivo = new File ("favoritos.txt");
//
//
//        if(arquivo.isFile() ==  false){
//            arquivo.createNewFile();
//        }
//
//        FileReader arquivoTxt1 = new FileReader(arquivo);
//        BufferedReader lerArq = new BufferedReader(arquivoTxt1);
//
//        List<String> ListString = new ArrayList<>();
//        List<Favoritos> listaDeFavoritos = new ArrayList<>();
//
//        String linha = "";
//
//        while ((linha = lerArq.readLine()) != null) {
//
//            if (linha != null) {
//                ListString.add(linha);
//            }
//        }
//
//        arquivoTxt1.close();
//        lerArq.close();
//
//        for( String i : ListString){
//
//            String[] prod = i.split(";");
//            Favoritos favoritos = new Favoritos();
//
//            favoritos.setId(Long.valueOf(prod[0]));
//            favoritos.setIdCliente(Long.valueOf(prod[1]));
//            favoritos.setIdProduto(Long.valueOf(prod[2]));
//
//            listaDeFavoritos.add(favoritos);
//        }
//
//        return listaDeFavoritos;
//
//
//
//    }
//
//}
