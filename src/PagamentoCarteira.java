public class PagamentoCarteira extends FormaDePagamento {

    private Carteira carteira;

    public PagamentoCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public boolean pagar(double valor) {
        return carteira.debitar(valor);
    }
}
