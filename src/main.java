public class Main {
    public static void main(String[] args) {

        // Criando usuário
        Usuario usuario = new Usuario("Bruno", "123", "bruno@email.com", 2000);

        // Criando jogos
        Jogo gta = new Jogo("GTA V", 99.90);
        Jogo minecraft = new Jogo("Minecraft", 59.90);

        // Criando loja
        Loja loja = new Loja();

        // (IMPORTANTE) adicionando jogos na loja
        loja.adicionarJogo(gta);
        loja.adicionarJogo(minecraft);

        // Adicionando saldo
        usuario.getCarteira().adicionarSaldo(200);

        // Comprando jogo
        usuario.comprarJogo(gta, loja);

        // Ver biblioteca
        usuario.exibirBiblioteca();

        // Avaliar jogo
        usuario.avaliarJogo(gta, 5, "Muito bom!");

        // Mostrar média
        System.out.println("Média do jogo: " + gta.getMediaAvaliacoes());
    }
}
