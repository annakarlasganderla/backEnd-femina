package java.com.femina.produto.Model;

public class Cargo {

    private int idCargo;
    private String cargo;

    public Cargo() {
    }

    public Cargo(int idCargo, String cargo) {
        this.idCargo = idCargo;
        this.cargo = cargo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "idCargo=" + idCargo +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}

