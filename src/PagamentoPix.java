public class PagamentoPix implements FormaDePagamento {

    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
            return false;
        }

        if (chavePix == null || chavePix.isEmpty()) {
            throw new IllegalArgumentException("Chave PIX inválida!");
            return false;
        }

        System.out.println("Pagamento via PIX realizado com sucesso!");
        return true;
    }
}
