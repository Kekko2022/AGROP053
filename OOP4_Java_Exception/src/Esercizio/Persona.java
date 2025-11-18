package Esercizio;

public abstract class Persona {
    protected String nome;
    protected String cognome;
    protected String cf;

    public Persona(String nome, String cognome, String cf) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
    }

    public String getNome() {return nome;}
    public String getCognome() {return cognome;}
    public String getCf() {return cf;}

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", cf='" + cf + '\'' +
                '}';
    }
}
