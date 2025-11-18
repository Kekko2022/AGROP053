public abstract class ElementiMultimediali {
    protected String titolo;

    public ElementiMultimediali(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public abstract void info();
}
