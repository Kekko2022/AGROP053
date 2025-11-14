public class AppDipendente {
    public static void main (String[] args) {
        Dipendente[] dipendenti = new Dipendente[5];

        dipendenti[0] = new DipendenteFullTime(101, "Marco Rossi", 1800, Dipartimento.PRODUZIONE);
        dipendenti[1] = new DipendenteFullTime(102, "Chiara Bianchi", 2000, Dipartimento.AMMINISTRAZIONE);

        dipendenti[2] = new DipendentePartTime(103, "Luca Verdi", 30,30, Dipartimento.PRODUZIONE);
        dipendenti[3] = new DipendentePartTime(104, "Sara Gialli", 40,30, Dipartimento.VENDITE);

        dipendenti[4] = new Dirigente(105, "Anna Neri", 3200, 1200, Dipartimento.VENDITE);

        for (Dipendente d : dipendenti) {
            d.updateSalary();
        }

        for (Dipendente d : dipendenti) {
            System.out.println(
                    "Matricola: " + d.getMatricola() +
                            " | Nome: " + d.getNomeCompleto() +
                            " | Stipendio: " + d.getStipendio() + "€" +
                            " | Dipartimento: " + d.getDipartimento()
            );
        }
    }
}