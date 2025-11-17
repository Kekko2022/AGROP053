package Esercizio_Biblioteca;
public class Main {
    public static void main(String[] args) {

        Libro l1 = new Libro("Il Signore degli Anelli", "Tolkien", "ISBN1");
        Libro l2 = new Libro("1984", "Orwell", "ISBN2");
        Libro l3 = new Libro("I Promessi Sposi", "Manzoni", "ISBN3");
        Libro l4 = new Libro("Il Piccolo Principe", "Saint-Exupéry", "ISBN4");
        Libro l5 = new Libro("Harry Potter", "Rowling", "ISBN5");
        Libro l6 = new Libro("test", "test", "ISBN5");
        Libro[] catalogo = new Libro[5];

        Utente u1 = new Utente("Mario", "Rossi", "U1");
        Utente u2 = new Utente("Luca", "Verdi", "U2");
        Utente u3 = new Utente("Sara", "Bianchi", "U3");
        Utente[] utenti = new Utente[3];

        Biblioteca biblio = new Biblioteca("Biblioteca Comunale", catalogo, utenti);
        //AGGIUNTA UTENTI
        Utente[] utentiIniziali = {u1, u2, u3};
        for(Utente u: utentiIniziali) {
            biblio.registraUtente(u);
        }

        //AGGIUNTA LIBRI AL CATALOGO DELLA BIBLIOTECA
        Libro[] libriIniziali = { l1, l2, l3, l4, l5 };
        for (Libro l : libriIniziali) {
            biblio.aggiungiLibro(l);
        }
        biblio.mostraCatalogo();

        biblio.mostraUtentiRegistrati();

        System.out.println();
        System.out.println("===PRESTITO LIBRI===");
        biblio.prestitoLibro("U1", "ISBN1");
        biblio.prestitoLibro("U1", "ISBN2");
        biblio.prestitoLibro("U3", "ISBN2");
        biblio.prestitoLibro("U3", "ISBN3");

        biblio.mostraCatalogo();

        System.out.println();
        System.out.println("===RESTITUZIONE LIBRI===");
        //biblio.restituzioneLibro("U1", "ISBN1");
        biblio.restituzioneLibro("U3", "ISBN3");
        biblio.restituzioneLibro("U3", "ISBN4");

        biblio.mostraCatalogo();
        System.out.println();

        System.out.println("===LIBRI IN PRESTITO===");
        for(Utente u: utenti) {
            if(u != null) {
                u.mostraLibriInPrestito();
            }
        }

        System.out.println("\n=== STATISTICHE ===");
        System.out.println("Totale libri nel catalogo: " + biblio.getTotaleLibriCatalogo());
        for(Utente u : utenti) {
            if(u != null) {
                System.out.println("Totale prestiti effettuati da " + u.getNome() + " " + u.getCognome() + ": " + u.getTotalePrestitiUtente());
            }
        }
    }
}
