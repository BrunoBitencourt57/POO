public class PagamentoPix extends FormaDePagamento {

    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return false;
        }

        System.out.println("Pagamento via PIX realizado com sucesso!");
        return true;
    }
}
