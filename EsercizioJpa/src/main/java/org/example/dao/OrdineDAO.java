package org.example.dao;

import com.github.javafaker.Faker;
import org.example.entities.Cliente;
import org.example.entities.DettagliOrdine;
import org.example.entities.Ordine;
import org.example.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;

public class OrdineDAO {
    static Faker fk = new Faker(new Locale("it-IT"));
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void saveOrdine(Cliente cliente, Prodotto prodotto) {
        int randQuantita = fk.number().numberBetween(1, 5);

        if(prodotto.getQuantita_disponibile() - randQuantita < 1){
            System.out.println("NO");
            return;
        }

        Ordine ordine = new Ordine(cliente);

        em.getTransaction().begin();
        em.persist(ordine);

        DettagliOrdine dettagliOrdine = new DettagliOrdine(ordine, prodotto, randQuantita, prodotto.getPrezzo());
        prodotto.setQuantita_disponibile((prodotto.getQuantita_disponibile() - randQuantita));

        ProdottoDAO.saveProdotto(prodotto);

        em.persist(dettagliOrdine);
        em.getTransaction().commit();
    }

    public static Ordine getOrdineById(Long id) {
        return em.find(Ordine.class, id);
    }

    public static void removeOrdine(Ordine ordine) {
        em.getTransaction().begin();
        em.remove(ordine);
        em.getTransaction().commit();
    }


}
