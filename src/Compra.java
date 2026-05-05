import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Compra {


    private Usuario usuario;
    private Produto produto;
    private double valorPago;
    private LocalDateTime dataCompra;


    public Compra(Usuario usuario, Produto produto) {
        if (usuario == null || produto == null) {
            throw new IllegalArgumentException("Usuário e produto não podem ser nulos");
        }


        this.usuario = usuario;
        this.produto = produto; // ✅ CORRIGIDO AQUI
        this.valorPago = produto.getPreco();
        this.dataCompra = LocalDateTime.now();
    }


    public void exibirCompra() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


        System.out.println("COMPROVANTE DE COMPRA");
        System.out.println("Cliente: " + usuario.getNome());
        System.out.println("Produto adquirido: " + produto.getNome());
        System.out.println("Valor: R$ " + String.format("%.2f", valorPago));
        System.out.println("Data: " + dataCompra.format(formato));
    }


    public Usuario getUsuario() { return usuario; }
    public Produto getProduto() { return produto; }
    public double getValorPago() { return valorPago; }
    public LocalDateTime getDataCompra() { return dataCompra; }


    @Override
    public String toString() {
        return produto.getNome() + " - R$ " + String.format("%.2f", valorPago);
    }
}
