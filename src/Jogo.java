import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto implements Avaliavel {

    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private List<DLC> dlcs = new ArrayList<>();

    public Jogo(String nome, double preco, String desenvolvedor) {
        super(nome, preco, desenvolvedor);
    }

    @Override
    public String gerarResumo() {
        return String.format(
                "[JOGO] %s | Preço: R$ %.2f | Desenvolvedor: %s | Média: %.1f",
                getNome(), getPreco(), getDesenvolvedor(), getMediaAvaliacoes()
        );
    }

    public void exibirDetalhes() {
        System.out.println(gerarResumo());

        if (dlcs.isEmpty()) {
            System.out.println("DLCs compradas: nenhuma");
        } else {
            System.out.println("DLCs compradas:");
            for (DLC dlc : dlcs) {
                System.out.println("- " + dlc.getNome());
            }
        }
    }

    public void adicionarDLC(DLC dlc) {
        if (dlc == null) {
            throw new IllegalArgumentException("DLC não pode ser nula");
        }

        if (dlc.getJogoBase() != this) {
            throw new IllegalArgumentException("DLC não pertence a este jogo");
        }

        if (!dlcs.contains(dlc)) {
            dlcs.add(dlc);
        }
    }


    @Override
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) return;

        for (Avaliacao a : avaliacoes) {
            if (a.getUsuario().equals(avaliacao.getUsuario())) {
                System.out.println("Usuário já avaliou esse jogo!");
                return;
            }
        }

        avaliacoes.add(avaliacao);
    }

    @Override
    public double getMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) return 0;

        double soma = 0;
        for (Avaliacao a : avaliacoes) {
            soma += a.getNota();
        }

        return soma / avaliacoes.size();
    }
}
