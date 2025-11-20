public class MainGenerics {
    public static void main(String[] args) {
        // Generics -> Metodi che mi consentono di scrivere classi, interfacce, o semplici metodi generici
        // utilizzabili con diversi tipi di dato, senza dover specificare in anticipo il tipodi dato esatto

        MiaClasseStringa ms = new MiaClasseStringa();
        MiaClasseIntero mi = new MiaClasseIntero();
        MiaClasseGenerics<String, Integer> mgs = new MiaClasseGenerics<>("ABC", 20);
        mgs.messaggio();
    }
}
