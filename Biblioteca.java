package POO;

import java.util.ArrayList;
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

}
