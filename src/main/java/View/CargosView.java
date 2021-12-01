package View;

import Controller.CargoController;
import Model.Cargo;
import java.util.Scanner;

public class CargosView {

    Scanner entrada = new Scanner(System.in);
    Cargo cargo = new Cargo();
    CargoController cargoController = new CargoController();

    public void cadastrarCargo(){
        System.out.println("Digite o cargo:");
        String nomeCargo =  entrada.next().toUpperCase();
        cargo.setCargo(nomeCargo);
        cargoController.cadastrarCargo(cargo);
    }

    public void deletarCargo(){
        listarCargos();
        System.out.println("Escolha o cargo que deseja deletar:");
        int idDelete = entrada.nextInt();
        cargoController.deletarCargo(idDelete-1);
    }

    public void listarCargos(){
        int tamanhoDaLista = cargoController.listarCargos().size();
        for(int i=0;i<tamanhoDaLista;i++){
            System.out.println((i+1) + " "+cargoController.listarCargos().get(i));
        }
    }
}
