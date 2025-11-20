package EsercizioCollection;

import EsercizioCollection.Exception.LettoreException;

public class Main {
    private static Biblioteca b = new Biblioteca("Biblioteca Centrale");

    public static void main(String[] args) {
        System.out.println("Avvio App Biblioteca");


        Libro l1 = new Libro("111", "Il Signore degli Anelli", "Tolkien", 1954);
        Libro l2 = new Libro("222", "1984", "Orwell", 1949);
        Libro l3 = new Libro("333", "1984", "Orwell2", 1949);
        Libro l4 = new Libro("333", "1984", "Orwell2", 1949);

        Lettore r1 = new Lettore(1, "Mario Rossi", "mario@mail.com");
        Lettore r2 = new Lettore(2, "Claudia Bianchi", "claudia@mail.com");
        Lettore r3 = new Lettore(2, "Claudia Bianchi", "claudia@mail.com");

        b.aggiungiLibro(l1);
        b.aggiungiLibro(l2);
        b.aggiungiLibro(l3);
        b.aggiungiLibro(l4);

        try {
            b.registraLettore(r1);
            b.registraLettore(r2);
            b.registraLettore(r3);
        } catch (LettoreException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        stampaLibriDisponibili();

        System.out.println();

        System.out.println("Lettori registrati: ");
        for(Lettore lettori: b.getLettori()) {
            System.out.println("   -> " + lettori);
        }

        System.out.println();

        //b.prestaLibro(r1, "111");
        b.prestaLibro(r1, "222");
        b.prestaLibro(r2, "111");

        b.stampaPrestiti();

        b.restituisciLibro(r2, "111");
        b.restituisciLibro(r2, "222");
        b.restituisciLibro(r1, "333");

        b.stampaPrestiti();

    }

    public static void stampaLibriDisponibili () {
        System.out.println("Libri in biblioteca: ");
        for(Libro libri : b.getLibri()) {
            System.out.println("   -> " + libri);
        }
    }
}
