package java.com.femina.produto.Controller;

import java.com.femina.produto.Dao.CargoDAO;
import java.com.femina.produto.Model.Cargo;
import java.util.List;

public class CargoController {

    CargoDAO cargoDAO = new CargoDAO();

    public void cadastrarCargo(Cargo cargo){
        cargoDAO.cadastrarCargo(cargo);
    }

    public void deletarCargo(int idDelete){
        cargoDAO.deletarCargo(idDelete);
    }

    public List<Cargo> listarCargos(){
        return cargoDAO.listarCargos();
    }

}
