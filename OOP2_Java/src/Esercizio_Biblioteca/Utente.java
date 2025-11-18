package Esercizio_Biblioteca;

public class Utente implements GestionePrestiti {
    private static int count = 0;
    private String nome;
    private String cognome;
    private String IDUtente;
    private Libro[] listaPrestiti;
    private int totalePrestitiUtente = 0;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.IDUtente = "U" + (++count < 10 ? "0" + count : count);
        this.listaPrestiti = new Libro[3];
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIDUtente() {
        return IDUtente;
    }

    public void prendereInPrestito(Libro libro) {
        for (int i = 0; i < listaPrestiti.length; i++) {
            if (listaPrestiti[i] == null) {
                listaPrestiti[i] = libro;
                libro.prestareLibro();
                totalePrestitiUtente++;
                System.out.println("Libro '" + libro.getDettagli() + "' preso in prestito.");
                return;
            }
        }
        System.out.println("L'utente ha già 3 libri in prestito!");
    }

    public int getTotalePrestitiUtente() {
        return totalePrestitiUtente;
    }

    public void restituireLibro(Libro libro) {
        for (int i = 0; i < listaPrestiti.length; i++) {
            if (listaPrestiti[i] != null && listaPrestiti[i].getISBN().equals(libro.getISBN())) {
                listaPrestiti[i] = null;
                libro.restituireLibro();
                System.out.println("Libro '" + libro.getDettagli() + "' restituito.");
                return;
            }
        }
        System.out.println("Errore: il libro non è tra quelli in prestito dell’utente.");
    }

    public void mostraLibriInPrestito() {
        System.out.println("Libri in prestito per " + nome + " " + cognome + ":");
        for (Libro libro : listaPrestiti) {
            if (libro != null) {
                System.out.println(" - " + libro.getDettagli());
            }
        }
    }
}
