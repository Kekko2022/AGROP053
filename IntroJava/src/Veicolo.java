public class Veicolo {

    public String marca;
    public String modello;
    public String targa;
    public int anni;
    public boolean stato;

    public Veicolo(){};
    public Veicolo(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
        this.anni = 0;
        this.stato = false;
    }

    public void start () {
        stato = true;
        System.out.println("Veicolo start");
    }

    public void stop () {
        stato = false;
        System.out.println("Veicolo stop");
    }

    public void info () {
        System.out.println("Veicolo: " + marca + " " + modello + " (" + targa + ") start: " + stato );
    }
}
