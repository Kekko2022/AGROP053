public abstract class Dipendente {
    private int matricola;
    private String nomeCompleto;
    private double stipendioBase;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(int matricola, String nomeCompleto, double stipendioBase, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.nomeCompleto = nomeCompleto;
        this.stipendioBase = stipendioBase;
        this.dipartimento = dipartimento;
    }

    public int getMatricola() {
        return matricola;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public abstract double calculateSalary();

    public void updateSalary() {
        this.stipendio = calculateSalary();
    }
}
