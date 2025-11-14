public class Camper extends Veicolo{
    private int numLetti;

    public Camper (String marca, String modello, int numLetti){
        super(marca, modello);
        this.numLetti = numLetti;
    }

    @Override
    public void start() {
        System.out.println("Start Camper");
    }

    public void cucina() {
        System.out.println("La cucina si è accesa");
    }

    @Override
    public String info() {
        return super.info() + " NumLetti: " + this.numLetti;
    }
}
