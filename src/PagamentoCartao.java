public class PagamentoCartao extends FormaDePagamento {

    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return false;
        }

        if (numeroCartao == null || numeroCartao.isEmpty()) {
            System.out.println("Cartão inválido!");
            return false;
        }

        System.out.println("Pagamento de R$ " + valor + " no cartão aprovado!");
        return true;
    }
}
