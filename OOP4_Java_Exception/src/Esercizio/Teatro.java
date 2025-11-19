package Esercizio;

public class Teatro {
    private String nome;
    private Persona posti[];

    public Teatro(String nome, int numeroPosti) {
        this.nome = nome;
        this.posti = new Persona[numeroPosti];
    }

    public String getNome() {return nome;}

    public Persona[] getPosti() {return posti;}

    public void prenotaPosto(int numeroPosto, Persona persona) throws postoNonValidoException, postoGiaOccupatoException, postiTerminatiException{
        //Teatro Pieno
        if(!postiDIsponibili()) {
            throw new postiTerminatiException("Il teatro: " + this.nome + " è SOLD OUT");
        }
        //Posto fuori range
        if(numeroPosto <= 0 || numeroPosto-1 > posti.length) {
            throw new postoNonValidoException("Valore non valido, devi inserire un valore compreso tra 1 e " + this.posti.length);
        }
        //Posto occupato
        if(posti[numeroPosto-1] != null) {
            throw new postoGiaOccupatoException("Posto " + numeroPosto + " occupato");
        }
        this.posti[numeroPosto - 1] = persona;
        System.out.println("Prenotazione posto: " + numeroPosto + " effettuata correttamente da " + persona.getNome() + " " + persona.getCognome());
    }

    public boolean postiDIsponibili() {
        for(int i = 0; i< posti.length; i++) {
          if(posti[i] == null) {
              return true;
          }
        }
        return false;
    }
}
