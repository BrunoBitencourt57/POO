public class PagamentoCartao implements FormaDePagamento {

    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        if (numeroCartao == null || numeroCartao.isEmpty()) {
            throw new IllegalArgumentException("Cartão inválido!");
        }

        System.out.println("Pagamento de R$ " + valor + " no cartão aprovado!");
        return true;
    }
}
