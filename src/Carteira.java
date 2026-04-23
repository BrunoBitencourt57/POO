class Carteira {
    private double saldo;

    public Carteira() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public boolean debitar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }else{
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }
}
