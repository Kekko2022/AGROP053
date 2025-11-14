public class Moto extends Veicolo {
    private boolean bauletto;

    public Moto (String marca, String modello, boolean bauletto){
        super(marca, modello);
        this.bauletto = bauletto;
    }

    @Override
    public void start() {
        System.out.println("Start Moto");
    }

    public void interfono() {
        System.out.println("Start Interfono");
    }

    @Override
    public String info() {
        return super.info() + " Bauletto: " + this.bauletto;
    }
}
