public class Video extends ElementiMultimediali implements Riproducibile{
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if(volume > 0) {
            volume--;
        }
    }

    public void aumentaLuminosita () {
        luminosita++;
    }

    public void diminuisciLuminosita () {
        if(luminosita > 0) {
            luminosita--;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            String puntiEsclamativi = "!".repeat(volume);
            String asterischi = "*".repeat(luminosita);
            System.out.println(titolo + puntiEsclamativi + asterischi);
        }
    }

    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public void info() {
        System.out.println("Titolo: " + titolo);
        System.out.println("Durata: " + durata);
        System.out.println("Volume: " + volume);
        System.out.println("Luminosità: " + luminosita);
        System.out.println("play():");
        play();
    }
}
