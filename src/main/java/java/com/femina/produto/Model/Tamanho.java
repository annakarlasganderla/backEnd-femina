package java.com.femina.produto.Model;

public class Tamanho {

    private int id;
    private String tam;

    public Tamanho(String tam, int id) {
        this.tam = tam;
        this.id = id;
    }

    public Tamanho() {
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TAMANHO: " + tam;
    }
}
