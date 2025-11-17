package Esercizio_Biblioteca;

public interface GestionePrestiti {
    void prendereInPrestito(Libro libro);
    void restituireLibro(Libro libro);
    void mostraLibriInPrestito();
}
