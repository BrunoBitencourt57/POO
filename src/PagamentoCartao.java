package pagamentos;

public class PagamentoCartao extends FormaDePagamento {

    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        super(TipoPagamento.CARTAO);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }

        System.out.println("Tipo: " + tipo);
        System.out.println("Pagamento de R$ " + valor + " no cartão aprovado!");

        return true;
    }
}
