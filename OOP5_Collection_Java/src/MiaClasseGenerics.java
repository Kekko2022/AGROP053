public class MiaClasseGenerics<T, E> {
    T valore;
    E altro;


    public MiaClasseGenerics(T valore, E altro) {
        this.altro = altro;
        this.valore = valore;
    }
    public T getValore() {
        return valore;
    }
    public void setValore(T valore) {
        this.valore = valore;
    }

    public E getAltro() {
        return altro;
    }

    public void setAltro(E altro) {
        this.altro = altro;
    }

    public String messaggio () {
        return "Generics T " + this.valore + "\nGenerics E " + this.altro;

    }
}
