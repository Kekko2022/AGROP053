package org.example.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ordini")
@NamedQuery(name = "Ordine.findAll", query = "SELECT o FROM Ordine o")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordine", nullable = false)
    private Long id_ordine;

    @Column(name="data_ordine", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp data_ordine;

    @OneToOne(mappedBy = "ordine", cascade = CascadeType.ALL)
    private DettagliOrdine dettagliOrdine;

    // todo MANY TO ONE
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Ordine() {}
    public Ordine(Cliente cliente) {
        this.cliente = cliente;
        this.data_ordine = new Timestamp(System.currentTimeMillis());
    }

    public Long getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Long id_ordine) {
        this.id_ordine = id_ordine;
    }

    public Timestamp getData_ordine() {
        return data_ordine;
    }

    public DettagliOrdine getDettagliOrdine() {
        return dettagliOrdine;
    }

    public void setDettagliOrdine(DettagliOrdine dettagliOrdine) {
        this.dettagliOrdine = dettagliOrdine;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", data_ordine=" + data_ordine +
                ", dettagliOrdine=" + dettagliOrdine.getId_dettagli_ordine() +
                ", cliente=" + cliente +
                '}';
    }
}