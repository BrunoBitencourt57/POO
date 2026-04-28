import java.time.LocalDateTime;

public class Avaliacao {

    private Usuario usuario;
    private Jogo jogo;
    private int nota;
    private String comentario;
    private LocalDateTime data;

    public Avaliacao(Usuario usuario, Jogo jogo, int nota, String comentario) {
        if (usuario == null || jogo == null) {
            throw new IllegalArgumentException("Usuário e jogo não podem ser nulos");
        }
        
        this.usuario = usuario;
        this.jogo = jogo;
        setNota(nota);
        this.comentario = (comentario != null) ? comentario : ""; 
        this.data = LocalDateTime.now();
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setNota(int nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("Nota deve ser entre 1 e 5");
        }
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Jogo: " + jogo.getNome() +
               " | Nota: " + nota +
               " | Comentário: " + comentario +
               " | Usuário: " + usuario.getNome();
    }
}
