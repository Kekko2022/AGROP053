public class Libro extends MediaItem{
    private int numeroPagine;
    private String genere;

    public Libro(String titolo, int anno, String autore, int numeroPagine, String genere) {
        super(titolo, anno, autore);
        setNumeroPagine(numeroPagine);
        setGenere(genere);
    }

    public int getNumeroPagine() {return numeroPagine;}
    public String getGenere() {return genere;}

    public void setNumeroPagine(int numeroPagine) {
        if(numeroPagine <= 0) {
            throw new IllegalArgumentException("Numero pagine non valido");
        }
        this.numeroPagine = numeroPagine;
    }

    public void setGenere(String genere) {
        if(genere == null || genere.isBlank()) {
            throw new IllegalArgumentException("Genere non valido");
        }
        this.genere = genere;
    }

    @Override
    public boolean matches(String query) {
        return super.matches(query) || genere.toLowerCase().contains(query.toLowerCase());
    }

    @Override
    public String getInfoDettagliata() {
        return "[LIBRO] " + toString() +
                " | Pagine: " + numeroPagine +
                " | Genere: " + genere;
    }
}
