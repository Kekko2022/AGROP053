public class Dirigente extends Dipendente {
    private double bonusDirigente;

    public Dirigente(int matricola, String nomeCompleto, double stipendioBase, double bonusDirigente,Dipartimento dipartimento) {
        super(matricola, nomeCompleto, stipendioBase, dipartimento);
        this.bonusDirigente = bonusDirigente;
    }

    @Override
    public double calculateSalary() {
        return getStipendioBase() + bonusDirigente;
    }
}
