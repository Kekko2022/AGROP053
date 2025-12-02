package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name="prodotti")
@NamedQuery(name = "Prodotto.findAll", query = "SELECT p FROM Prodotto p")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto", nullable = false)
    private Long id_prodotto;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "descrizione", nullable = false, length = 45)
    private String descrizione;

    @Column(name = "prezzo", nullable = false, length = 45)
    private Double prezzo;

    @Column(name = "quantita_disponibile", nullable = false, length = 45)
    private int quantita_disponibile;

    public Prodotto() {}
    public Prodotto(String nome, String descrizione, Double prezzo, int quantita_disponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita_disponibile = quantita_disponibile;
    }

    public Long getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(Long id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita_disponibile() {
        return quantita_disponibile;
    }

    public void setQuantita_disponibile(int quantita_disponibile) {
        this.quantita_disponibile = quantita_disponibile;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_prodotto=" + id_prodotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantita_disponibile=" + quantita_disponibile +
                '}';
    }
}
