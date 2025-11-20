package EsercizioStream;

import java.util.*;
import java.util.stream.Collectors;

public class MainProdotti {
    public static void main(String[] args) {
        List<Prodotti> listaProdotti = new ArrayList<Prodotti>();
        listaProdotti.add(new Prodotti(1, "TV", "Elettronica", 1400.00, 20));
        listaProdotti.add(new Prodotti(2, "Laptop", "Elettronica", 999.99, 10));
        listaProdotti.add(new Prodotti(3, "Frullatore", "Cucina", 9.90, 50));
        listaProdotti.add(new Prodotti(4, "Microonde", "Cucina", 39.90, 50));
        listaProdotti.add(new Prodotti(5, "Frigorifero", "Cucina", 1200.99, 50));
        listaProdotti.add(new Prodotti(6, "Monitor", "Elettronica", 199.99, 15));
        listaProdotti.add(new Prodotti(7, "Tenda da Campeggio", "Campeggio", 43.99, 15));

        //STAMPA DI TUTTI I PRODOTTI
        System.out.println("***STAMPA DI TUTTI I PRODOTTI***");
        listaProdotti.forEach(System.out::println);

        System.out.println();

        // STAMPA TUTTI I PRODOTTI CHE HANNO UN PREZZO > DI 50 EURO
        System.out.println("***STAMPA TUTTI I PRODOTTI CHE HANNO UN PREZZO > DI 50 EURO***");
        listaProdotti.stream()
                .filter(p -> p.getPrezzo() > 50)
                .forEach(System.out::println);

        System.out.println();

        //STAMPA DI TUTTI I PRODOTTI CON CATEGORIA ELETTRONICA
        System.out.println("***STAMPA DI TUTTI I PRODOTTI CON CATEGORIA ELETTRONICA***");
        listaProdotti.stream()
                .filter(p -> p.getCategoria().equals("Elettronica"))
                .forEach(System.out::println);

        System.out.println();

        //STAMPA IL PREZZO MEDIO DI TUTTI I PRODOTTI
        System.out.println("***MEDIA PREZZO DI TUTTI I PRODOTTI***");
        OptionalDouble prezzoMedio = listaProdotti.stream()
                .mapToDouble(Prodotti::getPrezzo)
                .average();
        System.out.println(prezzoMedio.getAsDouble());

        System.out.println();

        //STAMPA PRODOTTI CON PREZZO < DI 10 EURO
        System.out.println("***PRODOTTI CON PREZZO < DI 10 EURO***");
        boolean prodottoEconomico = listaProdotti.stream()
                .anyMatch(p -> p.getPrezzo() < 10);
        System.out.println(prodottoEconomico);

        System.out.println();

        //ORDINARE LA LISTA IN BASE AL PREZZO (CRESCENTE)
        System.out.println("***ORDINAMENTO LISTA PRODOTTI PREZZO CRESCENTE***");
        listaProdotti.stream()
                .sorted(Comparator.comparingDouble(Prodotti::getPrezzo))
                .forEach(System.out::println);

        System.out.println();

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
