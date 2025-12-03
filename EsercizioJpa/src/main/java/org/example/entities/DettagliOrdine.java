package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dettagli_ordini")
@NamedQuery(name = "DettagliOrdine.findAll", query = "SELECT do FROM DettagliOrdine do")
public class DettagliOrdine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dettagli_ordine", nullable = false)
    private Long id_dettagli_ordine;

    @OneToOne
    @JoinColumn(name = "id_ordine", nullable = false)
    private Ordine ordine;

    @ManyToOne
    @JoinColumn(name = "id_prodotto", nullable = true)
    private Prodotto prodotto;

    @Column(name="quantita", nullable = false)
    private int quantita;

    @Column(name="prezzo_unitario", nullable = false)
    private  double prezzo_unitario;

    public DettagliOrdine() {}
    public DettagliOrdine(Ordine ordine, Prodotto prodotto, int quantita, double prezzo_unitario) {
        this.ordine = ordine;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzo_unitario = prezzo_unitario;
    }

    public Long getId_dettagli_ordine() {
        return id_dettagli_ordine;
    }

    public void setId_dettagli_ordine(Long id_dettagli_ordine) {
        this.id_dettagli_ordine = id_dettagli_ordine;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzo_unitario() {
        return prezzo_unitario;
    }

    public void setPrezzo_unitario(double prezzo_unitario) {
        this.prezzo_unitario = prezzo_unitario;
    }

    @Override
    public String toString() {
        return "DettagliOrdine{" +
                "id_dettagli_ordine=" + id_dettagli_ordine +
                ", ordine=" + ordine +
                ", prodotto=" + prodotto +
                ", quantita=" + quantita +
                ", prezzo_unitario=" + prezzo_unitario +
                '}';
    }
}
