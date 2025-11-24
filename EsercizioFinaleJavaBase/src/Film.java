public class Film extends MediaItem{
    private int durata;
    private String regista;
    private String classificazione;

    public Film(String titolo, int anno, String autore, int durata, String regista, String classificazione) {
        super(titolo, anno, autore);
        setDurata(durata);
        setRegista(regista);
        this.classificazione = classificazione;
    }

    public int getDurata() {return durata;}
    public String getRegista() {return regista;}
    public String getClassificazione() {return classificazione;}

    public void setDurata(int durata) {
        if(durata<=0) {
            throw new IllegalArgumentException("La durata deve essere maggiore di 0");
        }
        this.durata = durata;
    }

    public void setRegista(String regista) {
        if(regista == null || regista.isBlank()) {
            throw new IllegalArgumentException("Regista non valido");
        }
        this.regista = regista;
    }

    @Override
    public boolean matches(String query) {
        String q = query.toLowerCase();
        return super.matches(query) || regista.toLowerCase().contains(q) || classificazione.toLowerCase().contains(q);
    }

    @Override
    public String getInfoDettagliata() {
        return "[FILM] " + toString() +
                " | Durata: " + durata + " min" +
                " | Regista: " + regista +
                " | Classificazione: " + classificazione;
    }
}
