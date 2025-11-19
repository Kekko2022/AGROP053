package Esercizio;

public class GestioneTeatro {
    static Teatro t = new Teatro("Topolino", 10);

    public static void main(String[] args) {
        try {
            t.prenotaPosto(8, new Uomo("Luca", "Rossi", "123ABC"));
            t.prenotaPosto(3, new Uomo("Mario", "Rossi", "456ABC"));
            t.prenotaPosto(5, new Donna("Maria", "Bianchi", "789ABC"));
            t.prenotaPosto(2, new Donna("Sara", "Neri", "111ABC"));
            t.prenotaPosto(8, new Uomo("Paolo", "Gialli", "222ABC"));

        } catch (postoNonValidoException | postoGiaOccupatoException | postiTerminatiException  e) {
            System.out.println(e.getMessage());
            stampaPostiDisponibili();
        }
    }

    public static void stampaPostiDisponibili() {
        System.out.println("===POSTI DISPONIBILI===");
        for (int i = 0; i < t.getPosti().length; i++) {
            if(t.getPosti()[i] == null) {
                System.out.println(i + 1 + " - LIBERO");
            }
        }
    }
}
