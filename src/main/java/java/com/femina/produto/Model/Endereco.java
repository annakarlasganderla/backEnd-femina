package java.com.femina.produto.Model;

public class Endereco {

    private long idEndereco;
    private String pais,estado,cidade,rua,cep;
    private int numCasa;

    public Endereco(String pais, String estado, String cidade, String rua, String cep, int numCasa) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.cep = cep;
        this.numCasa = numCasa;
    }

    public Endereco() {
    }

    public long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String toMostra() {
        return  "Endereco: " +
                "Pais - " + pais + "; " +
                "Estado - " + estado + "; " +
                "Cidade - " + cidade + "; " +
                "Rua - " + rua + "; " +
                "Cep - " + cep+ "; " +
                "Numero da casa - " + numCasa;
    }

    @Override
    public String toString() {
        return  ""+ idEndereco +
                ";"+ pais +
                ";" + estado +
                ";" + cidade +
                ";" + rua  +
                ";" + cep +
                ";" + numCasa;
    }
}
