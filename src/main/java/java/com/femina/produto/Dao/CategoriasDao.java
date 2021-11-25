//package main.java.com.femina.produto.Dao;
//
//import main.java.com.femina.produto.Model.Categoria;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoriasDao {
//
//        public void cadastrarCategoria(List<Categoria> categorias) throws IOException {
//
//            FileWriter categoriaFile = new FileWriter("categorias.txt",true);
//            PrintWriter printaCategoria = new PrintWriter(categoriaFile);
//
//            for(int i = 0; i < categorias.size();i++) {
//                categorias.get(i).setNome();
//                printaCategoria.println(categorias.get(i));
//
//            }
//
//            printaCategoria.flush();
//            printaCategoria.close();
//        }
//
//        public List<Categoria> mostrarListaDeCategoria () throws IOException {
//
//            FileReader fileReader = new FileReader("categorias.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            List<String> transformToString = new ArrayList<>();
//
//            List<Categoria> listaDeDescontos = new ArrayList<>();
//
//            String linha = " ";
//
//            while((linha = bufferedReader.readLine()) != null) {
//                if (linha != null) {
//                    transformToString.add(linha);
//                }
//            }
//
//            fileReader.close();
//            bufferedReader.close();
//
//            for (String i: transformToString) {
//                String[] cat = i.split(";");
//
//                Categoria categoria = new Categoria();
//
//                categoria.setNome(cat[1]);
//                categoria.setIdProduto(Long.valueOf(cat[1]));
//
//                mostrarListaDeCategoria().add(categoria);
//            }
//            return listaDeDescontos;
//        }
//
//        public void editaDeletaCategorias(List<Categoria> categorias) throws IOException {
//            FileWriter fileWriter = new FileWriter("categorias.txt",false);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            for (int listCategoria = 0; listCategoria < categorias.size(); listCategoria++) {
//                printWriter.println(categorias.get(listCategoria));
//            }
//
//            printWriter.flush();
//            printWriter.close();
//            fileWriter.close();
//        }
//
//
//    }
//
//
