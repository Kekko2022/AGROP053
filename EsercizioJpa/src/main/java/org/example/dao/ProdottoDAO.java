package org.example.dao;

import org.example.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ProdottoDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void saveProdotto(Prodotto prodotto) {
        em.getTransaction().begin();
        em.persist(prodotto);
        em.getTransaction().commit();
    }

    public static Prodotto getProdottoById(Long id) {
        return em.find(Prodotto.class, id);
    }

    public static void removeProdotto(Prodotto prodotto) {
        em.getTransaction().begin();
        em.remove(prodotto);
        em.getTransaction().commit();
    }

    public static List<Prodotto> getAllProdotti() {
        Query q = em.createNamedQuery("Prodotto.findAll");
        return q.getResultList();
    }


}
