//package main.java.com.femina.produto.Controller;
//
//import main.java.com.femina.produto.Dao.DestaquesDao;
//import main.java.com.femina.produto.Model.Destaques;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DestaquesController {
//
//    List<Destaques> listaDeDestaques = new ArrayList<Destaques>();
//    DestaquesDao destaquesDao = new DestaquesDao();
//
//    public void cadastraDestaque(Destaques destaques) throws IOException {
//        listaDeDestaques.add(destaques);
//        destaquesDao.cadastraDestaque(listaDeDestaques);
//    }
//
//    public List<Destaques> mostraListaDeDestaques() throws IOException {
//        listaDeDestaques = destaquesDao.mostraListaDeDestaques();
//        return listaDeDestaques;
//    }
//
//    public void removeDestaque(List<Destaques> destaques) throws IOException {
//        destaquesDao.removeDestaque(destaques);
//    }
//
//
//}
