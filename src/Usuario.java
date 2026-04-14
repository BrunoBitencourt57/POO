public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private int nascimento;
    private Carteira carteira;
    private Biblioteca biblioteca;

    public Usuario(String nome, String senha, String email, int nascimento){
        this.nome = nome;
        this.senha = password;
        this.email = email;
        this.nascimento = nascimento;
        this.biblioteca = new Biblioteca();
        this.carteira = new Carteira();
    }
        
    public void comprarJogo(Jogo jogo, Loja loja){
       loja.venderJogo(this, jogo);
    }
    
    public void listarBiblioteca(){
       biblioteca.listarJogos();
   }
}
