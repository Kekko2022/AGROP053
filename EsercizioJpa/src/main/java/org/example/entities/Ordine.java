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

    @ManyToMany(mappedBy = "ordini")
    private List<Cliente> listaCliente;

    @Column(name="data_ordine", nullable = false)
    private Timestamp data_ordine;

    public Ordine() {}
    public Ordine(Timestamp data_ordine) {
        this.data_ordine = data_ordine;
        this.listaCliente = new ArrayList<>();
    }

    public Long getId_ordine() {
        return id_ordine;
    }

    public void setId_ordine(Long id_ordine) {
        this.id_ordine = id_ordine;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Timestamp getData_ordine() {
        return data_ordine;
    }

    public void setData_ordine(Timestamp data_ordine) {
        this.data_ordine = data_ordine;
    }



    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", listaCliente=" + listaCliente +
                ", data_ordine=" + data_ordine +
                '}';
    }
}