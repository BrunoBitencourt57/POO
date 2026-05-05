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
       
            jogoDoUsuario.adicionarDLC(dlc);
        }


        if (pagamento.pagar(produto.getPreco())) {


            if (produto instanceof Jogo) {
                usuario.getBiblioteca().adicionarJogo((Jogo) produto);
            }


            Compra compra = new Compra(usuario, produto);
            compra.exibirCompra();


            System.out.println("Compra realizada com sucesso!");
            return true;
        }


        return false;
    }
}
