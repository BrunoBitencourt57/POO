import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {

    private Usuario usuario;
    private Jogo jogo;
    private double valorPago;
    private LocalDateTime dataCompra;

    // O construtor recebe o usuário e o jogo, capturando os dados no momento da venda.
    public Compra(Usuario usuario, Jogo jogo) {
        this.usuario = usuario;
        this.jogo = jogo;
        this.valorPago = jogo.getPreco();              // Armazenamos o preço do jogo no momento da compra.
        this.dataCompra = LocalDateTime.now();         // Registra o momento exato da transação.
    }

    // Método solicitado pela classe Loja.
    public void exibirCompra() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //Para imprimir um molde de data com hora e minutos da compra.

        System.out.println("COMPROVANTE DE COMPRA");
        System.out.println("Cliente: " + usuario.getNome());
        System.out.println("Jogo: " + jogo.getNome());
        System.out.println("Valor: R$ " + valorPago);
        System.out.println("Data: " + dataCompra.format(formato));
    }

    // Para que outra parte do sistema consulte os dados da última compra.
    public Usuario getUsuario() { return usuario; }
    public Jogo getJogo() { return jogo; }
    public double getValorPago() { return valorPago; }
    public LocalDateTime getDataCompra() { return dataCompra; }
}
