package Esercizio_Biblioteca;
public class Main {
    public static void main(String[] args) {

        Libro l1 = new Libro("Il Signore degli Anelli", "Tolkien", "ISBN1");
        Libro l2 = new Libro("1984", "Orwell", "ISBN2");
        Libro l3 = new Libro("I Promessi Sposi", "Manzoni", "ISBN3");
        Libro l4 = new Libro("Il Piccolo Principe", "Saint-Exupéry", "ISBN4");
        Libro l5 = new Libro("Harry Potter", "Rowling", "ISBN5");
        Libro l6 = new Libro("test1", "test1", "ISBN6");
        Libro l7 = new Libro("test2", "test2", "ISBN7");
        Libro l8 = new Libro("test3", "test3", "ISBN8");
        Libro[] catalogo = new Libro[10];

        Utente u1 = new Utente("Giulia", "Moretti");
        Utente u2 = new Utente("Alessandro", "Gentile");
        Utente u3 = new Utente("Francesca", "De Angelis");
        Utente u4 = new Utente("Paolo", "Conti");
        Utente u5 = new Utente("Elena", "Mariani");
        Utente u6 = new Utente("Giorgio", "Ferraro");
        Utente u7 = new Utente("Chiara", "Romano");
        Utente u8 = new Utente("Davide", "Lombardi");
        Utente u9 = new Utente("Martina", "Sartori");
        Utente u10 = new Utente("Simone", "Testa");

        Utente[] utenti = new Utente[10];

        Biblioteca biblio = new Biblioteca("Biblioteca Comunale", catalogo, utenti);
        //AGGIUNTA UTENTI
        Utente[] utentiIniziali = {u1, u2, u3, u4, u5, u6, u7, u8, u9, u10};
        for(Utente u: utentiIniziali) {
            biblio.registraUtente(u);
        }

        //AGGIUNTA LIBRI AL CATALOGO DELLA BIBLIOTECA
        Libro[] libriIniziali = { l1, l2, l3, l4, l5, l6, l7, l8 };
        for (Libro l : libriIniziali) {
            biblio.aggiungiLibro(l);
        }
        biblio.mostraCatalogo();

        biblio.mostraUtentiRegistrati();

        System.out.println();
        System.out.println("===PRESTITO LIBRI===");
        biblio.prestitoLibro(u1.getIDUtente(), "ISBN1");
        biblio.prestitoLibro(u1.getIDUtente(), "ISBN2");
        biblio.prestitoLibro(u1.getIDUtente(), "ISBN5");
        biblio.prestitoLibro(u1.getIDUtente(), "ISBN6");
        biblio.prestitoLibro(u3.getIDUtente(), "ISBN7");
        biblio.prestitoLibro(u3.getIDUtente(), "ISBN8");

        biblio.mostraCatalogo();

        System.out.println();
        System.out.println("===RESTITUZIONE LIBRI===");
        //biblio.restituzioneLibro("U1", "ISBN1");
        biblio.restituzioneLibro(u3.getIDUtente(), "ISBN8");
        biblio.restituzioneLibro(u3.getIDUtente(), "ISBN7");

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
