public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(int matricola, String nomeCompleto, double stipendioBase, Dipartimento dipartimento) {
        super(matricola, nomeCompleto, stipendioBase, dipartimento);
    }

    @Override
    public double calculateSalary() {
        return getStipendioBase();
    }
}