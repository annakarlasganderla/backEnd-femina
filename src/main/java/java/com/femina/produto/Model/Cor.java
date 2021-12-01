package java.com.femina.produto.Model;

public class Cor {

    private int id;
    private String nome, hexadecimal;


    public Cor() {
    }

    public Cor(String nome, String hexadecimal) {
        this.nome = nome;
        this.hexadecimal = hexadecimal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public String toMostra() {
        return  "Cor: \n" +
                "Id - " + id + "; " +
                "Nome - " + nome +  "; " +
                "Hexadecimal - " + hexadecimal +
                "\n";
    }

    @Override
    public String toString() {
        return "COR: "+
                nome + "-" +
                hexadecimal;
    }
}
