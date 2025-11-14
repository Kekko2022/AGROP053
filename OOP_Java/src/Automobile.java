public class Automobile extends Veicolo{
    private int numPorte;

    public Automobile (String marca, String modello, int numPorte){
        super(marca, modello);
        this.numPorte = numPorte;
    }

    @Override
    public void start() {
        System.out.println("Start Automobile");
    }

    public void autoradio() {
        System.out.println("L' autoradio si è accesa");
    }

    @Override
    public String info() {
        return super.info() + " NumPorte: " + this.numPorte;
    }
}
