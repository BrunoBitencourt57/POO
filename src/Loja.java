import java.util.ArrayList;
import java.util.List;

public class Loja {
    
    private List<Produto> produtosDisponiveis = new ArrayList<>(); 

    public void adicionarProduto(Produto produto) {
        if (produto != null && !produtosDisponiveis.contains(produto)) {
            produtosDisponiveis.add(produto);
        }
    } 

    public boolean venderProduto(Usuario usuario, Produto produto, FormaDePagamento pagamento) {

        if (usuario == null || produto == null || pagamento == null) {
            return false;
        }

        if (!produtosDisponiveis.contains(produto)) {
            return false;
        }

        if (produto instanceof DLC) {
            DLC dlc = (DLC) produto;

            if (usuario.getBiblioteca().buscarJogo(dlc.getJogoBase().getNome()) == null) {
                System.out.println("Você precisa ter o jogo base!");
                return false;
            }
        }

        if (pagamento.pagar(produto.getPreco())) {

            if (produto instanceof Jogo) {
                usuario.getBiblioteca().adicionarJogo((Jogo) produto);
            }

            Compra compra = new Compra(usuario, produto);
            usuario.adicionarCompra(compra);

            System.out.println("Compra realizada com sucesso!");
            return true;
        }

        return false;
    }
}
