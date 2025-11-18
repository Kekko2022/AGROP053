public class Immagine extends ElementiMultimediali{
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void aumentaLuminosita () {
        luminosita++;
    }

    public void diminuisciLuminosita () {
        if(luminosita > 0) {
            luminosita--;
        }
    }

    public void show() {
        String asterischi = "*".repeat(luminosita);
        System.out.println(titolo + asterischi);
    }

    @Override
    public void info() {
        System.out.println("Titolo: " + titolo);
        System.out.println("Luminosità: " + luminosita);
        System.out.println("show():");
        show();
    }
}
