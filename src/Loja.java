import java.util.ArrayList;
import java.util.List;

public class Loja {
    
    private List<Jogo> jogosDisponiveis = new ArrayList<>();

    public void venderJogo(Usuario usuario, Jogo jogo) {

        if (!jogosDisponiveis.contains(jogo)) {
            System.out.println("Jogo não disponível!");
            return;
        }

        if (usuario.getCarteira().debitar(jogo.getPreco())) {
            usuario.getBiblioteca().adicionarJogo(jogo);

            Compra compra = new Compra(usuario, jogo); 
            compra.exibirCompra();

            System.out.println("Compra realizada!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
