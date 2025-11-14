public class Camion extends Veicolo {
    private boolean telonato;

    public Camion(String marca, String modello, boolean telonato) {
        super(marca, modello);
        this.telonato = telonato;
    }

    @Override
    public void start() {
        System.out.println("Start Camion");
    }

    @Override
    public String info() {
        return super.info() + " Telonato: " + this.telonato;
    }
}
