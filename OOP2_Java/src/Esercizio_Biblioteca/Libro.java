package Esercizio_Biblioteca;

public class Libro {
    private String titolo;
    private String autore;
    private String ISBN;
    private static int totaleLibri = 0;
    private boolean disponibile;

    public Libro(String titolo, String autore, String ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.disponibile = true;
        totaleLibri++;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public String getDettagli() {
        return "Titolo Libro: " + this.titolo + " - Autore: " + this.autore + " - ISBN: " + this.ISBN + " - Disponibilità: " + this.disponibile;
    };
    public void prestareLibro() {
        if(disponibile) {
            disponibile = false;
        } else {
            System.out.println("Il libro " + titolo + " non è disponibile");
        }
    };

    public void restituireLibro() {
        if(!disponibile) {
            disponibile = true;
        } else {
            System.out.println("Errore: il libro '" + titolo + "' non era in prestito");
        }
    };

    public static int getTotaleLibri() {
        return totaleLibri;
    }
}
