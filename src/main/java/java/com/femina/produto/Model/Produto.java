package java.com.femina.produto.Model;

public class Produto {

    private int id;
    private String nome;
    private Double preco;
    private int codigo, qtd;
    private Categoria categoria;
    private Marca marca;
    private FornecedorProduto fornecedor;
    private ModeloProduto modelo;
    private CorProduto cores;
    private TamanhoProduto tamanhos;

    public Produto() {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public FornecedorProduto getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorProduto fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ModeloProduto getModelo() {
        return modelo;
    }

    public void setModelo(ModeloProduto modelo) {
        this.modelo = modelo;
    }

    public CorProduto getCores() {
        return cores;
    }

    public void setCores(CorProduto cores) {
        this.cores = cores;
    }

    public TamanhoProduto getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(TamanhoProduto tamanhos) {
        this.tamanhos = tamanhos;
    }

    @Override
    public String toString() {
        return "PRODUTO: \n" +
                "|  Código: " + codigo + "\n" +
                "|  Nome: " + nome + "\n" +
                "|  Valor: " + preco + "\n" +
                "|  Quantidade: " + qtd + "\n" +
                "|  Cores: " + cores + "\n" +
                "|  Categoria: " + categoria.getNome() + "\n" +
                "|  Modelos: " + modelo + "\n" +
                "|  Marca: " + marca.getNome() + "\n" +
                "|  Tamanho: " + tamanhos + "\n" +
                "|  Fornecedor: " + fornecedor +
                "|-----------------------------------------------|";
    }
}
