import java.time.LocalDateTime;

import usuarios.Usuario;
import interfaces.Avaliavel;

public class Avaliacao {

    private Usuario autor;
    private Avaliavel avaliado;
    private int nota;
    private String comentario;
    private LocalDateTime data;

    public Avaliacao(
            Usuario autor,
            Avaliavel avaliado,
            int nota,
            String comentario) {

        if (autor == null || avaliado == null) {
            throw new IllegalArgumentException(
                "Autor e avaliado não podem ser nulos");
        }

        this.autor = autor;
        this.avaliado = avaliado;
        setNota(nota);
        this.comentario = (comentario != null)
                ? comentario
                : "";

        this.data = LocalDateTime.now();
    }

    public Usuario getUsuario() {
        return autor;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {

        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException(
                "Nota deve ser entre 1 e 5");
        }

        this.nota = nota;
    }

    @Override
    public String toString() {

        return "Nota: " + nota +
               " | Comentário: " + comentario +
               " | Por: " + autor.getNome();
    }
}
