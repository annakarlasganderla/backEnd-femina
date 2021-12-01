
package Controller;

import Dao.CorDao;
import Model.Cor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CorController {

    CorDao corDao = new CorDao();

    public void criaCor (Cor cor)throws IOException, SQLException{
        corDao.criaTabelaCor(cor);
    }
    public void cadastraCor(Cor cor)throws IOException,SQLException{
        corDao.cadastraCor(cor);
    }
    public List<Cor> listarCores()throws SQLException,IOException{
        return corDao.listarCores();

    }
    public Cor selecionaCor(int  id){
        return corDao.selectCorById(id);
    }
    public void editarCor(Cor cor){
        corDao.editarCor(cor);
    }
    public void deletaCor(Cor cor){
        corDao.deletaProduto(cor);
    }
}
