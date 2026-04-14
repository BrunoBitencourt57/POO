public class Main {
    public static void main(String[] args) {

        Usuario u1 = new Usuario("Bruno");

        Jogo j1 = new Jogo("GTA V", 99.90);
        Jogo j2 = new Jogo("Minecraft",59.90);

        System.out.println(u1.getNome());
        System.out.println(j1.getNome());
    }
}
