package EsercizioCollection;

import java.util.Objects;

public class Lettore {
    private int id;
    private String nome;
    private String email;

    public Lettore(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {return id;}

    public String getNome() {return nome;}

    public String getEmail() {return email;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lettore)) return false;
        Lettore lettore = (Lettore) o;
        return id == lettore.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Lettore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
