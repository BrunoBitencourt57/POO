//Classe produto
public class Produto {
    protected String nome;
    protected double preco;

public Produto(String nome, double preco) {
    if (preco < 0) {
             throw new IllegalArgumentException("Preço não pode ser negativo");
    }

    this.nome = nome;
    this.preco = preco;
} 

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    }
}

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}









