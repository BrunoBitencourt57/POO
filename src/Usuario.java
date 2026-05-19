import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String senha;
    private String email;
    private int nascimento;
    private Carteira carteira;
    private Biblioteca biblioteca;
    private List<Compra> historicoCompras;
    private Perfil perfil;

    public class Perfil implements Avaliavel {
        private String nickname;
        private String bio;
        private String status;
        private List<Avaliacao> avaliacoes = new ArrayList<>();

        public Perfil(String nickname) {
            this.nickname = nickname;
            this.bio = "";
            this.status = "Online";
        }

        public Perfil getPerfil() {
            return perfil;
        }

        public void setBio(String bio) {
            this.bio = (bio != null) ? bio : "";
        }

        public void setStatus(String status) {
            this.status = (status != null) ? status : "Online";
        }

        @Override
        public void adicionarAvaliacao(Avaliacao avaliacao) {
            if (avaliacao != null) {
                avaliacoes.add(avaliacao);
            }
        }

        @Override
        public double getMediaAvaliacoes() {
            if (avaliacoes.isEmpty()) return 0;

            double soma = 0;
            for (Avaliacao a : avaliacoes) {
                soma += a.getNota();
            }
            return soma / avaliacoes.size();
        }

        public void exibirPerfil() {
            System.out.println("Nickname: " + nickname);
            System.out.println("Bio: " + bio);
            System.out.println("Status: " + status);
            System.out.println("Média de avaliações: " + getMediaAvaliacoes());
        }
    }

    public Usuario(String nome, String senha, String email, int nascimento) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.nascimento = nascimento;
        this.carteira = new Carteira();
        this.biblioteca = new Biblioteca();
        this.historicoCompras = new ArrayList<>();
        this.perfil = new Perfil(nome);
    }

    public String getNome() {
        return nome;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public boolean validarSenha(String senhaDigitada) {
        return senha.equals(senhaDigitada);
    }

    public void adicionarCompra(Compra compra) {
        if (compra != null) {
            historicoCompras.add(compra);
        }
    }

    public void exibirHistoricoCompras() {
        if (historicoCompras.isEmpty()) {
            System.out.println("Nenhuma compra realizada.");
            return;
        }

        for (Compra compra : historicoCompras) {
            compra.exibirCompra();
            System.out.println("----------------------");
        }
    }

    public void avaliar(Avaliavel avaliado, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(this, avaliado, nota, comentario);
        avaliado.adicionarAvaliacao(avaliacao);
    }

    public void avaliarPerfilDe(Usuario outroUsuario, int nota, String comentario) {
        if (outroUsuario == null) {
            System.out.println("Usuário inválido.");
            return;
        }

        if (outroUsuario == this) {
            System.out.println("Você não pode avaliar seu próprio perfil.");
            return;
        }

        Avaliacao avaliacao = new Avaliacao(this, outroUsuario.getPerfil(), nota, comentario);
        outroUsuario.getPerfil().adicionarAvaliacao(avaliacao);

        System.out.println("Perfil avaliado com sucesso!");
    }

    public void exibirBiblioteca() {
        biblioteca.exibirJogos();
    }
}
