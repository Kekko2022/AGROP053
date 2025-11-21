import Interface.Ricercabile;

public abstract class MediaItem implements Ricercabile {
    protected String titolo;
    protected int anno;
    protected String autore;

    public MediaItem(String titolo, int anno, String autore) {
        setTitolo(titolo);
        setAutore(autore);
        setAnno(anno);
    }

    public String getTitolo() {return titolo;}
    public int getAnno() {return anno;}
    public String getAutore() {return autore;}

    public void setTitolo(String titolo) {
        if(titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto");
        }
        this.titolo = titolo;
    }

    public void setAnno(int anno) {
        if(anno < 0 || anno > 2025) {
            throw new IllegalArgumentException("L'anno inserito non è valido");
        }
        this.anno = anno;
    }

    public void setAutore(String autore) {
        if(autore == null || autore.isBlank()) {
            throw new IllegalArgumentException("L'autore non può essere vuoto");
        }
        this.autore = autore;
    }

    public abstract String getInfoDettagliata();

    @Override
    public boolean matches(String query) {
        String q = query.toLowerCase();
        return titolo.toLowerCase().contains(q) ||
                autore.toLowerCase().contains(q);
    }

    @Override
    public String toString() {
        return titolo + " (" + anno + "), di " + autore;
    }
}
