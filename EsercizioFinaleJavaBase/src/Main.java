import Eccezioni.ElementoNonTrovatoException;
import com.github.javafaker.Faker;

import java.util.Locale;
//import java.util.Random;

public class Main {

    private static Faker fk = new Faker(new Locale("it-IT"));
    private static Catalogo catalogo = new Catalogo();

    //private static Random random = new Random();

    public static void main(String[] args) {
        aggiuntaDinamica();
        ricerca();
        ordinamentoTitolo();
        ordinamentoAnno();
        raggruppamentoAutore();
        raggruppamentoCategoriaFilm();
        statistiche();
    }

    public static void aggiuntaDinamica() throws IllegalArgumentException{
        try {
            //int randLibri = random.nextInt(1, 11);
            int randLibri = fk.number().numberBetween(1, 11);
            for(int i = 0; i < randLibri; i++) {
                //AGGIUNTA DI LIBRI
                catalogo.aggiungi(new Libro(
                        fk.book().title(),
                        fk.number().numberBetween(1900, 2025),
                        fk.book().author(),
                        fk.number().numberBetween(50, 1000),
                        fk.book().genre()
                ));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE LIBRI: ");
            System.out.println(e.getMessage());
        }

        //int randFilm = random.nextInt(1, 11);
        try {
            int randFilm = fk.number().numberBetween(1, 11);
            for(int j = 0; j < randFilm; j++) {
                //AGGIUNTA CON OPTION DI UN ARRAY DI GENERI, SUPPORTATO CON OPTION DALLA LIBRERIA FAKER
                String[] generi = {"Action", "Comedy", "Drama", "Horror", "Fantasy", "Thriller", "Romance"};
                String genre = fk.options().option(generi);
                //AGGIUNTA DI FILM
                catalogo.aggiungi(new Film(
                        fk.book().title(),
                        fk.number().numberBetween(1900, 2025),
                        fk.book().author(),
                        fk.number().numberBetween(60, 180),
                        fk.artist().name(),
                        genre
                ));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE FILM: ");
            System.out.println(e.getMessage());
        }

        //int randAlbum = random.nextInt(1, 11);
        try {
            int randAlbum = fk.number().numberBetween(1, 11);
            for(int k = 0; k < randAlbum; k++) {
                //AGGIUNTA DI ALBUM MUSICALI
                catalogo.aggiungi(new AlbumMusicale(
                        fk.music().genre(),
                        fk.number().numberBetween(1900, 2025),
                        fk.artist().name(),
                        fk.number().numberBetween(1, 5),
                        fk.music().instrument()
                ));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE ALBUM: ");
            System.out.println(e.getMessage());
        }
        System.out.println("=== CATALOGO COMPLETO ===");
        catalogo.stampaDettagli();
    }

    public static void ricerca() {
        // Ricerca
        try {
            System.out.println("\n=== RISULTATI RICERCA ===");
            catalogo.cerca("the").forEach(System.out::println);
        } catch (ElementoNonTrovatoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ordinamentoTitolo() {
        // Ordinamento titolo
        System.out.println("\n=== ORDINATI PER TITOLO ===");
        catalogo.ordinaPerTitolo().forEach(System.out::println);
    }

    public static void ordinamentoAnno() {
        // Ordinamento anno
        System.out.println("\n=== ORDINATI PER ANNO ===");
        catalogo.ordinaPerAnno().forEach(System.out::println);
    }

    public static void raggruppamentoAutore() {
        // Raggruppamento
        System.out.println("\n=== RAGGRUPPATI PER AUTORE ===");
        catalogo.raggruppaPerAutore().forEach((autore, items) -> {
            System.out.println("\nAutore: " + autore);
            items.forEach(System.out::println);
        });
    }

    public static void raggruppamentoCategoriaFilm() {
        // Raggruppamento
        System.out.println("\n=== FILM RAGGRUPPATI PER CATEGORIA ===");
        catalogo.raggruppaCatFilm().forEach((categoria, items) -> {
            System.out.println("\nCategoria: " + categoria);
            items.forEach(System.out::println);
        });
    }

    public static void statistiche() {
        // Statistiche
        System.out.println("\n=== STATISTICHE ===");
        System.out.println("\nAnno medio pubblicazioni: " + catalogo.mediaAnno());
        System.out.println("Somma elementi per tipo: " + catalogo.sommaElementiPerTipo());
        System.out.println("Totale pagine di tutti i libri: " + catalogo.sommaPagineLibri());
        System.out.println("Totale numero tracce di tutti gli Album: " + catalogo.sommaTracceAlbum());
        System.out.println("Media durata di tutti i film: " + catalogo.mediaMinutiFilm() + " minuti");
        System.out.println("Esistono film usciti negli anni 2000: " + catalogo.film2000());
    }
}