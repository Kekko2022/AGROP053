public abstract class Veicolo {
    protected String marca;
    protected String modello;

    public Veicolo(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
    }

    public abstract void start();

    public String info() {
        return this.marca + " " + this.modello;
    }

}
