public abstract class Produto {
    private String nome;
    private double preco;
    private String desenvolvedor;

    public Produto(String nome, double preco, String desenvolvedor) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }

        if (desenvolvedor == null || desenvolvedor.isEmpty()) {
            throw new IllegalArgumentException("Desenvolvedor não pode ser vazio");
        }

        this.nome = nome;
        this.preco = preco;
        this.desenvolvedor = desenvolvedor;
    }

    public abstract String gerarResumo();

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return gerarResumo();
    }
}
