import java.util.ArrayList;
import java.util.List;

import avaliacoes.Avaliacao;
import interfaces.Avaliavel;

public class Jogo extends Produto
                  implements Avaliavel {

    private List<Avaliacao> avaliacoes =
            new ArrayList<>();

    private List<DLC> dlcs =
            new ArrayList<>();

    public Jogo(
            String nome,
            double preco,
            String desenvolvedor) {

        super(nome, preco, desenvolvedor);
    }

    @Override
    public String gerarResumo() {

        return String.format(
            "[JOGO] %s | Preço %.2f",
            getNome(),
            getPreco()
        );
    }

    public void exibirDetalhes() {

        System.out.println(
                gerarResumo());

        if (dlcs.isEmpty()) {

            System.out.println(
                    "Nenhuma DLC");

        } else {

            for (DLC dlc : dlcs) {

                System.out.println(
                        dlc.getNome());
            }
        }
    }

    public void adicionarDLC(
            DLC dlc) {

        if (dlc == null)
            throw new IllegalArgumentException();

        if (dlc.getJogoBase()
                != this) {

            throw new IllegalArgumentException();
        }

        if (!dlcs.contains(dlc)) {
            dlcs.add(dlc);
        }
    }

    @Override
    public void adicionarAvaliacao(
            Avaliacao avaliacao) {

        if (avaliacao == null)
            return;

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

        return soma /
                avaliacoes.size();
    }
}
