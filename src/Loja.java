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

        if (produto instanceof Jogo) {
            if (usuario.getBiblioteca().buscarJogo(produto.getNome()) != null) {
                System.out.println("Você já possui esse jogo!");
                return false;
            }
        }

        if (produto instanceof DLC) {
            DLC dlc = (DLC) produto;

            Jogo jogoBase = dlc.getJogoBase();
            Jogo jogoDoUsuario = usuario.getBiblioteca().buscarJogo(jogoBase.getNome());

            if (jogoDoUsuario == null) {
                System.out.println("Você precisa ter o jogo base!");
                return false;
            }
        }

        if (pagamento.pagar(produto.getPreco())) {

            if (produto instanceof Jogo) {
                usuario.getBiblioteca().adicionarJogo((Jogo) produto);
            }

            if (produto instanceof DLC) {
                DLC dlc = (DLC) produto;

                Jogo jogoDoUsuario =
                        usuario.getBiblioteca().buscarJogo(dlc.getJogoBase().getNome());

                jogoDoUsuario.adicionarDLC(dlc);
            }

            Compra compra = new Compra(usuario, produto);
            compra.exibirCompra();

            usuario.adicionarCompra(compra);

            System.out.println("Compra realizada com sucesso!");
            return true;
        }

        return false;
    }

    public void exibirProdutos() {
        if (produtosDisponiveis.isEmpty()) {
            System.out.println("Loja vazia.");
            return;
        }

        for (int i = 0; i < produtosDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + produtosDisponiveis.get(i));
        }
    }

    public Produto getProdutoPorIndice(int indice) {
        if (indice < 0 || indice >= produtosDisponiveis.size()) {
            return null;
        }

        return produtosDisponiveis.get(indice);
    }
}
