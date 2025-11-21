package EsercizioStream;

import java.util.*;
import java.util.stream.Collectors;

public class MainProdotti {
    private static List<Prodotti> listaProdotti = new ArrayList<Prodotti>();
    public static void main(String[] args) {

        creaProdotti();

        filtraStampaProdotti50();

        catElettronica("Campeggio");

        mediaPrezzoProdotti();

        prodottiEconomici();

        ordCrescenteProdotti();

        groupByCatProdotti();
    }

    public static void creaProdotti() {
        listaProdotti.add(new Prodotti("TV", "Elettronica", 1400.00, 20));
        listaProdotti.add(new Prodotti( "Laptop", "Elettronica", 999.99, 10));
        listaProdotti.add(new Prodotti( "Frullatore", "Cucina", 9.90, 50));
        listaProdotti.add(new Prodotti( "Microonde", "Cucina", 39.90, 50));
        listaProdotti.add(new Prodotti( "Frigorifero", "Cucina", 1200.99, 50));
        listaProdotti.add(new Prodotti( "Monitor", "Elettronica", 199.99, 15));
        listaProdotti.add(new Prodotti( "Tenda da Campeggio", "Campeggio", 43.99, 15));
        //STAMPA DI TUTTI I PRODOTTI
        System.out.println("***STAMPA DI TUTTI I PRODOTTI***");
        listaProdotti.forEach(System.out::println);
        System.out.println();
    }

    public static void filtraStampaProdotti50() {
        // STAMPA TUTTI I PRODOTTI CHE HANNO UN PREZZO > DI 50 EURO
        System.out.println("***STAMPA TUTTI I PRODOTTI CHE HANNO UN PREZZO > DI 50 EURO***");
        listaProdotti.stream()
                .filter(p -> p.getPrezzo() > 50)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void catElettronica(String categoria) {
        //STAMPA DI TUTTI I PRODOTTI PER CATEGORIA
        System.out.println("***STAMPA DI TUTTI I PRODOTTI PER CATEGORIA***");
        listaProdotti.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .map(Prodotti::getNome)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void mediaPrezzoProdotti() {
        //STAMPA IL PREZZO MEDIO DI TUTTI I PRODOTTI
        System.out.println("***MEDIA PREZZO DI TUTTI I PRODOTTI CON OPTIONAL DOUBLE***");
        OptionalDouble prezzoMedio = listaProdotti.stream()
                .mapToDouble(Prodotti::getPrezzo)
                .average();
        System.out.println(prezzoMedio.getAsDouble());
        System.out.println();

        //OPPURE
        System.out.println("***MEDIA PREZZO DI TUTTI I PRODOTTI CON OR-ELSE(0)***");
        double prezzoMedio1 = listaProdotti.stream()
                .mapToDouble(Prodotti::getPrezzo)
                .average()
                .orElse(0);
        System.out.println(prezzoMedio1);
        System.out.println();
    }

    public static void prodottiEconomici() {
        //STAMPA PRODOTTI CON PREZZO < DI 10 EURO
        System.out.println("***PRODOTTI CON PREZZO < DI 10 EURO***");
        boolean prodottoEconomico = listaProdotti.stream()
                .anyMatch(p -> p.getPrezzo() < 10);
        System.out.println(prodottoEconomico);
        System.out.println();
    }

    public static void ordCrescenteProdotti() {
        //ORDINARE LA LISTA IN BASE AL PREZZO (CRESCENTE)
        System.out.println("***ORDINAMENTO LISTA PRODOTTI PREZZO CRESCENTE***");
        listaProdotti.stream()
                .sorted(Comparator.comparingDouble(Prodotti::getPrezzo))
                .forEach(System.out::println);

        System.out.println();
    }

    public static void groupByCatProdotti() {
        //RAGGRUPPARE I PRODOTTI PER CATEGORIA E VISUALIZZARLI
        Map<String, List<Prodotti>> prodottiPerCategoria = listaProdotti.stream()
                .collect(Collectors.groupingBy(p -> p.getCategoria()));

        prodottiPerCategoria.forEach((categoria, lista) ->
        {
            System.out.println("Categoria: " + categoria);
            lista.forEach(System.out::println);
        });
    }

}
