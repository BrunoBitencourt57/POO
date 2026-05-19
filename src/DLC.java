package produtos;

import java.util.ArrayList;
import java.util.List;

import avaliacoes.Avaliacao;
import interfaces.Avaliavel;

public class DLC extends Produto implements Avaliavel {

    private final Jogo jogoBase;
    private List<Avaliacao> avaliacoes =
            new ArrayList<>();

    public DLC(
            String nome,
            double preco,
            String desenvolvedor,
            Jogo jogoBase) {

        super(nome, preco, desenvolvedor);

        if (jogoBase == null) {
            throw new IllegalArgumentException(
                    "Jogo base não pode ser nulo");
        }

        this.jogoBase = jogoBase;
    }

    public Jogo getJogoBase() {
        return jogoBase;
    }

    @Override
    public void adicionarAvaliacao(
            Avaliacao avaliacao) {

        if (avaliacao == null) return;

        avaliacoes.add(avaliacao);
    }

    @Override
    public double getMediaAvaliacoes() {

        if (avaliacoes.isEmpty())
            return 0;

        double soma = 0;

        for (Avaliacao a : avaliacoes) {
            soma += a.getNota();
        }

        return soma / avaliacoes.size();
    }

    @Override
    public String gerarResumo() {

        return String.format(
            "[DLC] %s | Requer: %s | Preço: %.2f",
            getNome(),
            jogoBase.getNome(),
            getPreco()
        );
    }
}
