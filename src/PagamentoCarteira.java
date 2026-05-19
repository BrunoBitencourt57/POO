public class PagamentoCarteira extends FormaDePagamento {

    private Carteira carteira;

    public PagamentoCarteira(Carteira carteira) {
        super(TipoPagamento.CARTEIRA);
        this.carteira = carteira;
    }

    @Override
    public boolean pagar(double valor) {
        if (carteira == null) {
            throw new IllegalArgumentException("Carteira inválida!");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        System.out.println("Tipo: " + tipo);

        return carteira.debitar(valor);
    }
}