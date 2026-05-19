import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private List<Jogo> meusJogos;

    public Biblioteca() {
        this.meusJogos = new ArrayList<>();
    }

    public void adicionarJogo(Jogo jogo) {
        if (!meusJogos.contains(jogo)) {
            meusJogos.add(jogo);
        }
    }

    public void exibirJogos() {
        if (meusJogos.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
            return;
        }

        System.out.println("Meus jogos:");
        for (int i = 0; i < meusJogos.size(); i++) {
            System.out.println((i + 1) + ". " + meusJogos.get(i));
        }
    }

    public Jogo buscarJogo(String nome) {
        for (Jogo jogo : meusJogos) {
            if (jogo.getNome().equalsIgnoreCase(nome)) {
                return jogo;
            }
        }
        return null;
    }

    public int getQuantidadeJogos() {
        return meusJogos.size();
    }

    public List<Jogo> ordenarPorNome() {
        List<Jogo> jogosOrdenados = new ArrayList<>(meusJogos);
        Collections.sort(jogosOrdenados, new Comparator<Jogo>() {
            @Override
            public int compare(Jogo j1, Jogo j2) {
                return j1.getNome().compareToIgnoreCase(j2.getNome());
            }
        });
        return jogosOrdenados;
    }

    public List<Jogo> ordenarPorPreco() {
        List<Jogo> jogosOrdenados = new ArrayList<>(meusJogos);
        Collections.sort(jogosOrdenados, new Comparator<Jogo>() {
            @Override
            public int compare(Jogo j1, Jogo j2) {
                return Double.compare(j1.getPreco(), j2.getPreco());
            }
        });
        return jogosOrdenados;
    }

    public List<Jogo> ordenarPorPrecoDecrescente() {
        List<Jogo> jogosOrdenados = new ArrayList<>(meusJogos);
        Collections.sort(jogosOrdenados, new Comparator<Jogo>() {
            @Override
            public int compare(Jogo j1, Jogo j2) {
                return Double.compare(j2.getPreco(), j1.getPreco());
            }
        });
        return jogosOrdenados;
    }

    public List<Jogo> ordenarPorAvaliacao() {
        List<Jogo> jogosOrdenados = new ArrayList<>(meusJogos);
        Collections.sort(jogosOrdenados, new Comparator<Jogo>() {
            @Override
            public int compare(Jogo j1, Jogo j2) {
                return Double.compare(j2.getMediaAvaliacoes(), j1.getMediaAvaliacoes());
            }
        });
        return jogosOrdenados;
    }

    public Jogo getJogoPorIndice(int indice) {
        if (indice < 0 || indice >= meusJogos.size()) {
            return null;
        }
        return meusJogos.get(indice);
    }

}
