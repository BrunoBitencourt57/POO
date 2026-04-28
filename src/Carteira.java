public class Carteira {

    private double saldo;

    public Carteira() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }

        saldo += valor;
    }

    public boolean debitar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return false;
        }

        if (saldo < valor) {
            System.out.println("Saldo insuficiente!");
            return false;
        }

        saldo -= valor;
        return true;
    }
}
