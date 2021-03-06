package Model;

public class Fornecedor {

    private int idFornecedor;
    private String nomeFornecedor, cnpjFornecedor;
    private Contatos contatoFornecedor;
    private Endereco enderecoFornecedor;

    public Fornecedor() {
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public Contatos getContatoFornecedor() {
        return contatoFornecedor;
    }

    public void setContatoFornecedor(Contatos contatoFornecedor) {
        this.contatoFornecedor = contatoFornecedor;
    }

    public Endereco getEnderecoFornecedor() {
        return enderecoFornecedor;
    }

    public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
        this.enderecoFornecedor = enderecoFornecedor;
    }

    @Override
    public String toString() {
        return "| FORNECEDOR "+idFornecedor+":" + nomeFornecedor + " - CNPJ:" + cnpjFornecedor + " - " +
                "\n     CONTATO:" + contatoFornecedor + " - " +
                "\n     ENDEREÇO:" + enderecoFornecedor + " |\n" ;
    }
}
