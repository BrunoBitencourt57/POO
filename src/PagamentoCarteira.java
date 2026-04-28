public class PagamentoCarteira extends FormaDePagamento {

    private Carteira carteira;

    public PagamentoCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public boolean pagar(double valor) {
        if (carteira == null) {
            System.out.println("Carteira inválida!");
            return false;
        }

        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return false;
        }

        return carteira.debitar(valor);
    }
}
