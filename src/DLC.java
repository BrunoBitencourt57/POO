public class DLC extends Produto {

    private Jogo jogoBase;

    public DLC(String nome, double preco, Jogo jogoBase) {
        super(nome, preco);

        if (jogoBase == null) {
            throw new IllegalArgumentException("Jogo base não pode ser nulo");
        }

        this.jogoBase = jogoBase;
    } 

    public Jogo getJogoBase() {
        return jogoBase;
    }

    @Override
    public String toString() {
        return getNome() + " (DLC de " + jogoBase.getNome() + ") - R$ " + getPreco();
    }
}
