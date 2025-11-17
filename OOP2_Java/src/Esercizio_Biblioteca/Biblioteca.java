package Esercizio_Biblioteca;

public class Biblioteca {
    private String nome;
    private Libro[] catalogoLibri;
    private Utente[] utentiRegistrati;

    public Biblioteca(String nome, Libro[] catalogoLibri, Utente[] utentiRegistrati) {
        this.nome = nome;
        this.catalogoLibri = catalogoLibri;
        this.utentiRegistrati = utentiRegistrati;
    }

    public void aggiungiLibro(Libro libro) {
        for(int i = 0; i < catalogoLibri.length; i++) {
            if(catalogoLibri[i] == null) {
                catalogoLibri[i] = libro;
                return;
            }
            if(catalogoLibri[i].getISBN().equals(libro.getISBN())) {
                System.out.println("Il libro è già presente nel catalogo");
                return;
            }
        }
        System.out.println("Catalogo pieno, impossibile aggiungere il libro.");
    }

    public void registraUtente(Utente utente) {
        for (int i = 0; i < utentiRegistrati.length; i++) {
            if (utentiRegistrati[i] == null) {
                utentiRegistrati[i] = utente;
                return;
            }
            if (utentiRegistrati[i].getIDUtente().equals(utente.getIDUtente())) {
                System.out.println("Utente già registrato.");
                return;
            }
        }
        System.out.println("Impossibile registrare altri utenti.");
    }

    private Utente trovaUtente(String idUtente) {
        for (Utente u : utentiRegistrati) {
            if (u != null && u.getIDUtente().equals(idUtente))
                return u;
        }
        return null;
    }

    private Libro trovaLibro(String ISBN) {
        for (Libro l : catalogoLibri) {
            if (l != null && l.getISBN().equals(ISBN))
                return l;
        }
        return null;
    }

    public void prestitoLibro(String idUtente, String ISBN) {
        Utente utente = trovaUtente(idUtente);
        Libro libro = trovaLibro(ISBN);

        if (utente == null) {
            System.out.println("Utente non trovato.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro non trovato.");
            return;
        }
        if (!libro.isDisponibile()) {
            System.out.println("Il libro non è disponibile.");
            return;
        }

        utente.prendereInPrestito(libro);
    }

    public void restituzioneLibro(String idUtente, String ISBN) {
        Utente utente = trovaUtente(idUtente);
        Libro libro = trovaLibro(ISBN);

        if (utente == null) {
            System.out.println("Utente non trovato.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro non trovato.");
            return;
        }

        utente.restituireLibro(libro);
    }

    public void mostraCatalogo() {
        System.out.println("\n=== CATALOGO BIBLIOTECA ===");
        for (Libro libro : catalogoLibri) {
            if (libro != null) {
                System.out.println(libro.getDettagli());
            }
        }
    }

    public void mostraUtentiRegistrati() {
        System.out.println("\n=== UTENTI REGISTRATI ===");
        for (Utente u : utentiRegistrati) {
            if (u != null) {
                System.out.println("Utente: " + u.getIDUtente() + " - " + u.getNome() + " " + u.getCognome());
            }
        }
    }

    public int getTotaleLibriCatalogo() {
        int count = 0;
        for (Libro l : catalogoLibri) {
            if (l != null) count++;
        }
        return count;
    }
}
