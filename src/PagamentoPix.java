public class PagamentoPix extends FormaDePagamento {


    private String chavePix;


    public PagamentoPix(String chavePix) {
        super(TipoPagamento.PIX);
        this.chavePix = chavePix;
    }


    @Override
    public boolean pagar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }


        if (chavePix == null || chavePix.isEmpty()) {
            throw new IllegalArgumentException("Chave PIX inválida!");
        }


        System.out.println("Tipo: " + tipo);
        System.out.println("Pagamento via PIX realizado com sucesso!");


        return true;
    }
}
