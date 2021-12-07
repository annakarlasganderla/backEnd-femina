package Controller;

import Dao.CargoDAO;
import Model.Cargo;
import java.util.List;

public class CargoController {

    CargoDAO cargoDAO = new CargoDAO();

    public void criaTabelaCargos() {
        cargoDAO.createTable();
    }

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
