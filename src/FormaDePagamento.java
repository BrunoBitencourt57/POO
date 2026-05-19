package pagamentos;

public abstract class FormaDePagamento {

    protected TipoPagamento tipo;

    public FormaDePagamento(TipoPagamento tipo) {
        this.tipo = tipo;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public abstract boolean pagar(double valor);
}
