package org.example;

import com.github.javafaker.Faker;
import org.example.dao.ClienteDAO;
import org.example.dao.OrdineDAO;
import org.example.dao.ProdottoDAO;
import org.example.entities.Cliente;
import org.example.entities.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.Random;

public class Main {
    static Faker fake = new Faker(new Locale("it-IT"));
    static Random rand = new Random();
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();
    public static void main( String[] args ) {
        //popolaDBClienti();
        //popolaDBProdotti();
        //ClienteDAO.getAllClienti().forEach(System.out::println);
        //ProdottoDAO.getAllProdotti().forEach(System.out::println);


        //OrdineDAO.saveOrdine(ClienteDAO.getClienteById(2L), ProdottoDAO.getProdottoById(1L));

        //System.out.println(OrdineDAO.getOrdineById(2L).getDettagliOrdine());

        //ProdottoDAO.removeProdotto(ProdottoDAO.getProdottoById(1L));

        OrdineDAO.removeOrdine(OrdineDAO.getOrdineById(1L));
    }

    public static void popolaDBClienti() {
        for (int i = 0; i < 15; i++) {
            String name = fake.name().firstName().toLowerCase();
            String lastname = fake.name().lastName().toLowerCase();
            ClienteDAO.saveCliente(new Cliente(name, lastname, name.charAt(0) + "." + lastname + "@example.com", fake.phoneNumber().cellPhone()));
        }
    }

    public static void popolaDBProdotti() {
        for (int i = 0; i < 60; i++) {
            ProdottoDAO.saveProdotto(new Prodotto(fake.commerce().productName(), fake.lorem().characters(rand.nextInt(45)), fake.number().randomDouble(2, 1, 1000), rand.nextInt(100)));
        }
    }
}
