package org.example.dao;

import org.example.entities.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    public static void saveCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public static Cliente getClienteById(Long id) {
        return em.find(Cliente.class, id);
    }

    public static void removeCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }

    public static List<Cliente> getAllClienti() {
        Query q = em.createNamedQuery("Cliente.findAll");
        return q.getResultList();
    }

    public static Cliente getUserByEmail(String e) {
        Query q = em.createNamedQuery("Cliente.findByEmail");
        q.setParameter("email", e);
        return (Cliente) q.getSingleResult();
    }

}
