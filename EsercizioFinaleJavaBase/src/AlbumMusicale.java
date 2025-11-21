public class AlbumMusicale extends MediaItem{
    private int numeroTracce;
    private String etichetta;

    public AlbumMusicale(String titolo, int anno, String autore, int numeroTracce, String etichetta) {
        super(titolo, anno, autore);
        setNumeroTracce(numeroTracce);
        this.etichetta = etichetta;
    }

    public int getNumeroTracce() {return numeroTracce;}
    public String getEtichetta() {return etichetta;}

    public void setNumeroTracce(int numeroTracce) {
        if(numeroTracce <= 0) {
            throw new IllegalArgumentException("Numero tracce non valido");
        }
        this.numeroTracce = numeroTracce;
    }

    @Override
    public boolean matches(String query) {
        return super.matches(query) || etichetta.toLowerCase().contains(query.toLowerCase());
    }

    @Override
    public String getInfoDettagliata() {
        return "[ALBUM] " + toString() +
                " | Tracce: " + numeroTracce +
                " | Etichetta: " + etichetta;
    }
}
