public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private int nascimento;
    private Carteira carteira;
    private Biblioteca biblioteca;

    public Usuario(String nome, String senha, String email, int nascimento){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.nascimento = nascimento;
        this.biblioteca = new Biblioteca();
        this.carteira = new Carteira();
    }

    public Biblioteca getBiblioteca(){
        return biblioteca;
    }

    public Carteira getCarteira(){
        return carteira;
    }
        
    public void comprarJogo(Jogo jogo, Loja loja){
       loja.venderJogo(this, jogo);
    }
    
    public void exibirBiblioteca(){
       biblioteca.exibirJogos();
   }

    public void avaliarJogo(Jogo jogo, int nota, String comentario) {
        if (biblioteca.buscarJogo(jogo.getNome()) != null) {
            Avaliacao avaliacao = new Avaliacao(this, jogo, nota, comentario);
            jogo.adicionarAvaliacao(avaliacao);
        } else {
            System.out.println("Você não possui esse jogo!");
        }
    }
}
