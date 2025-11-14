public class DipendentePartTime extends Dipendente {
    private int oreLavorate;

    public DipendentePartTime(int matricola, String nomeCompleto, double stipendioBase, int oreLavorate, Dipartimento dipartimento) {
        super(matricola, nomeCompleto, stipendioBase, dipartimento);
        this.oreLavorate = oreLavorate;
    }

    @Override
    public double calculateSalary() {
        return getStipendioBase() * oreLavorate;
    }
}