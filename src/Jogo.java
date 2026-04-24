import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private String nome;
    private double preco;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Jogo(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
    for (Avaliacao a : avaliacoes) {
        if (a.getUsuario().equals(avaliacao.getUsuario())) {
            System.out.println("Usuário já avaliou esse jogo!");
            return;
        }
    }
    avaliacoes.add(avaliacao);
}

    public double getMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) return 0;
    
        double soma = 0;
        for (Avaliacao a : avaliacoes) {
            soma += a.getNota();
        }
    
        return soma / avaliacoes.size();
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco + " | Média: " + getMediaAvaliacoes();
    }
}
