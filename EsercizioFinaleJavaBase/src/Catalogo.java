import Eccezioni.ElementoNonTrovatoException;

import java.util.*;
import java.util.stream.Collectors;

public class Catalogo {
    private List<MediaItem> elem = new ArrayList<>();

    public void aggiungi(MediaItem item) {
        elem.add(item);
    }

    public List<MediaItem> cerca(String query) throws ElementoNonTrovatoException {
        List<MediaItem> risultati = elem.stream()
                .filter(e -> e.matches(query))
                .toList();

        if(risultati.isEmpty()) {
            throw new ElementoNonTrovatoException("Nessun elemento trovato");
        }
        return risultati;
    }

    public void stampaDettagli() {
        elem.forEach(e -> System.out.println(e.getInfoDettagliata()));
    }

    public List<MediaItem> ordinaPerTitolo() {
        return elem.stream()
                    .sorted(Comparator.comparing(MediaItem::getTitolo))
                    .toList();
    }

    public List<MediaItem> ordinaPerAnno() {
        return elem.stream()
                .sorted(Comparator.comparing(MediaItem::getAnno))
                .toList();
    }

    public Map<String, List<MediaItem>> raggruppaPerAutore() {
        return elem.stream()
                .collect(Collectors.groupingBy(MediaItem::getAutore));
    }

    public Map<String, List<Film>> raggruppaCatFilm() {
        return elem.stream()
                .filter(e -> e instanceof Film)
                .map(e -> (Film) e)
                .collect(Collectors.groupingBy(Film::getClassificazione));
    }

    public double mediaAnno() {
        return elem.stream()
                    .mapToInt(MediaItem::getAnno)
                    .average()
                    .orElse(0);
    }

    public Map<String, Long> sommaElementiPerTipo()  {
        return elem.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getClass().getSimpleName(),
                        Collectors.counting()
                ));
    }

    public int sommaPagineLibri() {
        return elem.stream()
                .filter(e -> e instanceof Libro)
                .mapToInt(e -> ((Libro) e).getNumeroPagine())
                .sum();
    }

    public int sommaTracceAlbum() {
        return elem.stream()
                .filter(e -> e instanceof AlbumMusicale)
                .mapToInt(e -> ((AlbumMusicale) e).getNumeroTracce())
                .sum();
    }

    public double mediaMinutiFilm() {
        return elem.stream()
                .filter(e -> e instanceof Film)
                .mapToInt(e -> ((Film) e).getDurata())
                .average()
                .orElse(0);
    }

    public boolean film2000() {
        return  elem.stream()
                .anyMatch(e -> e.getAnno() == 2000);

    }
}
