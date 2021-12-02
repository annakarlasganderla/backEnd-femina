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

    public void menuCargo() {
        int op = 0;
        char control = 's';

        do {
            do {
                System.out.println("-------------------------------------");
                System.out.println("|        0 - Sair                   |");
                System.out.println("|        1 - Cadastrar              |");
                System.out.println("|        2 - Visualizar             |");
                System.out.println("|        3 - Deletar                |");
                System.out.println("-------------------------------------");
                System.out.println("|     Digite aqui a sua opção:      |");
                System.out.println("-------------------------------------");
                op = entrada.nextInt();
            } while (op == 5);

            switch (op) {

                case 0:
                    break;

                case 1:
                    do {
                        this.cadastrarCargo();

                        System.out.println("Deseja continuar cadastrando? digite s ou S para sim");
                        control = entrada.next().charAt(0);

                    } while (control == 's' || control == 'S');

                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 2:
                    this.listarCargos();
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                case 3:
                    this.deletarCargo();
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida");
                    System.out.println("5 - Voltar");
                    op = entrada.nextInt();
                    break;
            }

        } while (op != 0);

    }
}
