package EsercizioCollection;

import EsercizioCollection.Exception.LettoreException;

import java.util.*;

public class Biblioteca {
    private String nome;
    private List<Libro> libri;
    private Set<Lettore> lettori;
    private Map<Lettore, Set<Libro>> prestiti;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.libri = new ArrayList<Libro>();
        this.lettori = new HashSet<Lettore>();
        this.prestiti = new HashMap<Lettore, Set<Libro>>();
    }

    public String getNome() {return nome;}
    public List<Libro> getLibri() {return libri;}
    public Set<Lettore> getLettori() {return lettori;}
    public Map<Lettore, Set<Libro>> getPrestiti() {return prestiti;}


    public void aggiungiLibro(Libro libro){
        this.libri.add(libro);
    }

    public void registraLettore(Lettore lettore) throws LettoreException {
        if(!this.lettori.add(lettore)) {
            throw new LettoreException("L'utente è già stato registrato");
        }
    }

    public boolean prestaLibro(Lettore lettore, String isbn) {
        if(!lettori.contains(lettore)) {
            System.out.println("Il lettore non è registrato");
            return false;
        }

        Libro libroDaPrestare = null;
        for(Libro l: libri) {
            if(l.getIsbn().equals(isbn)) {
                libroDaPrestare = l;
                break;
            }
        }

        if(libroDaPrestare == null) {
            System.out.println("Errore: libro con ISBN: " + isbn + " non trovato");
            return false;
        }

        for(Set<Libro> libriInPrestito : prestiti.values()) {
            if(libriInPrestito.contains(libroDaPrestare)) {
                System.out.println("Errore il libro è già in prestito");
                return false;
            }
        }

        if(!prestiti.containsKey(lettore)) {
            prestiti.put(lettore, new HashSet<>());
        }

        prestiti.get(lettore).add(libroDaPrestare);
        System.out.println("Prestito effettuato con successo");
        return true;
    }

    public boolean restituisciLibro(Lettore lettore, String isbn) {
        if(!prestiti.containsKey(lettore)) {
            System.out.println("Il lettore non ha libri in prestito");
            return false;
        }

        Set<Libro> libriInPrestito = prestiti.get(lettore);
        Libro libroDaRestituire = null;
        for(Libro l : libriInPrestito) {
            if(l.getIsbn().equals(isbn)) {
                libroDaRestituire = l;
                break;
            }
        }

        if(libroDaRestituire == null) {
            System.out.println("Il lettore non ha questo libro in prestito");
            return false;
        }

        libriInPrestito.remove(libroDaRestituire);

        if(libriInPrestito.isEmpty()) {
            prestiti.remove(lettore);
        }
        System.out.println("Libro restituito con successo: " + libroDaRestituire.getTitolo() + " da " + lettore.getNome());
        return true;

    }

    public void restituisciTuttiLibriInPrestito() {
        System.out.println("");


    }
    public void stampaPrestiti() {
        if (prestiti.isEmpty()) {
            System.out.println("Nessun prestito registrato.");
            return;
        }

        System.out.println("--- Prestiti attuali ---");
        for (Map.Entry<Lettore, Set<Libro>> entry : prestiti.entrySet()) {
            Lettore lettore = entry.getKey();
            Set<Libro> libriInPrestito = entry.getValue();

            System.out.println(lettore + " ha preso in prestito:");
            for (Libro libro : libriInPrestito) {
                System.out.println("  - " + libro);
            }
            System.out.println();
        }
    }





}
