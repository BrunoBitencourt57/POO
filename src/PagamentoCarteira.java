public class PagamentoCarteira implements FormaDePagamento {

    private Carteira carteira;

    public PagamentoCarteira(Carteira carteira) {
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

        return carteira.debitar(valor);
    }
}
