public class Audio extends ElementiMultimediali implements Riproducibile{
    private int durata;
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if(volume > 0) {
            volume--;
        }
    }

    @Override
    public void play() {
        for(int i = 0; i < durata; i++) {
            String puntiEsclamativi = "!".repeat(volume);
            System.out.println(titolo + puntiEsclamativi);
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
        System.out.println("play():");
        play();
    }
}
