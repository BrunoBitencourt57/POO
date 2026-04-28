public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private int nascimento;
    private Carteira carteira;
    private Biblioteca biblioteca;

    public Usuario(String nome, String senha, String email, int nascimento){
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (senha == null || senha.length() < 3) {
            throw new IllegalArgumentException("Senha inválida");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.nascimento = nascimento;
        this.biblioteca = new Biblioteca();
        this.carteira = new Carteira();
    }

    public String getNome() {
        return nome;
    }

    public Carteira getCarteira(){
        return carteira;
    }

    public Biblioteca getBiblioteca(){
        return biblioteca;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        }
    }

    public void setSenha(String senha) {
        if (senha != null && senha.length() >= 3) {
            this.senha = senha;
        }
    }

    public void comprarProduto(Produto produto, Loja loja, FormaDePagamento pagamento) {
        loja.venderProduto(this, produto, pagamento);
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
