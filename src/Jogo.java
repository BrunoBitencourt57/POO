import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto {

    private List<Avaliacao> avaliacoes = new ArrayList<>();
    private List<DLC> dlcs = new ArrayList<>(); 

    public Jogo(String nome, double preco) {
        super(nome, preco);
    }

    public void adicionarDLC(DLC dlc) {
        if (dlc == null) return;

        if (!dlc.getJogoBase().equals(this)) {
            System.out.println("DLC não pertence a este jogo!");
            return;
        }

        dlcs.add(dlc);
    } 

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

    public double getMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) return 0;

        double soma = 0;
        for (Avaliacao a : avaliacoes) {
            soma += a.getNota();
        }

        return soma / avaliacoes.size();
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public String toString() {
        return getNome() + " - R$ " + getPreco() + " | Média: " + getMediaAvaliacoes();
    }
}
