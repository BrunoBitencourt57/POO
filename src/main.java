public class Main {
    public static void main(String[] args) {

        Usuario user = new Usuario("Brayan", "1234", "brayan@email.com", 2000);

        Loja loja = new Loja();

        Jogo fifa = new Jogo("FIFA 24", 100);
        Jogo gta = new Jogo("GTA V", 80);

        DLC dlcFifa = new DLC("Ultimate Team Pack", 30, fifa);

        loja.adicionarProduto(fifa);
        loja.adicionarProduto(gta);
        loja.adicionarProduto(dlcFifa);

        user.getCarteira().adicionarSaldo(200);

        FormaDePagamento pagamentoCarteira = new PagamentoCarteira(user.getCarteira());
        FormaDePagamento pagamentoCartao = new PagamentoCartao("1234-5678");
        FormaDePagamento pagamentoPix = new PagamentoPix("brayan@email.com");

        System.out.println("\n--- Comprando FIFA com carteira ---");
        loja.venderProduto(user, fifa, pagamentoCarteira);

        System.out.println("\n--- Comprando GTA com cartão ---");
        loja.venderProduto(user, gta, pagamentoCartao);

        System.out.println("\n--- Tentando comprar DLC sem lógica de ordem ---");
        loja.venderProduto(user, dlcFifa, pagamentoPix);

        System.out.println("\n--- Biblioteca do usuário ---");
        user.exibirBiblioteca();

        System.out.println("\n--- Avaliando jogo ---");
        user.avaliarJogo(fifa, 5, "Muito bom!");

        System.out.println("\nMédia de avaliações do FIFA: " + fifa.getMediaAvaliacoes());

        System.out.println("\nSaldo restante: R$ " + user.getCarteira().getSaldo());
    }
}
