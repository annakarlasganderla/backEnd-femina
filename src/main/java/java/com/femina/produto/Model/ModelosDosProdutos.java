package java.com.femina.produto.Model;

public class ModelosDosProdutos {


    private int id_modelo;
    private String nomeTipo;

    public ModelosDosProdutos(int id, String nomeTipo) {
        this.id_modelo = id;
        this.nomeTipo = nomeTipo;
    }

    public ModelosDosProdutos() {
    }

    public int getId() {
        return id_modelo;
    }

    public void setId(int id) {
        this.id_modelo = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    @Override
    public String toString() {
        return "MODELO: " + nomeTipo;
    }
}
