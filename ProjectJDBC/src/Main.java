import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Locale;

public class Main {

    static Faker fk = new Faker(new Locale("it-IT"));
    public static void main(String[] args) {
        try {
            DBConnection db = DBConnection.getInstance();
            System.out.println(db);
            // CREAZIONE UTENTE SENZA FAKER
            //User u = new User("Mario", "Rossi", 25, "Roma", "1DF2ADBCAD234SDF", "m.rossi@example.com");
            //User u = new User("Claudia", "Bianchi", 32, "Napoli", "DRASDFG123ASSDF4", "c.bianchi@example.com");

            // RICHIAMA LA CREATE USER APPUNTO PER CREARE L'UTENTE
            //db.createUser(u);

            // RICHIAMA IL FIND PER RICERCARE L'UTENTE TRAMITE ID
            //User u = db.findUser(1);
            // RICHIAMA IL FIND ALL PER RICERCARE TUTTI GLI UTENTI DELLA TABELLA
            //db.findAllUsers().forEach(System.out::println);

            // VIENE USATO IL SET PER CAMBIARE IL VALORE (QUALSIASI) DI UN UTENTE E VIENE
            //u.setEmail("m.rossi@test.it");
            //db.updateUser(u);

            // RIMOZIONE UTENTE PER ID
            //db.removeUser(u);

            // RICHIAMA IL METODO PER POPOLARE IL DBB
            popolaDB(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void popolaDB(int num) throws SQLException {
        DBConnection db = DBConnection.getInstance();
        System.out.println(db);
        for (int i = 0; i < num; i++) {
            String name = fk.name().firstName();
            String lastname = fk.name().lastName();
            int age = fk.number().numberBetween(18, 80);
            String city = fk.address().city();
            String fiscal_code = fk.lorem().characters(16);
            String email = name.charAt(0) + "." + lastname + "@" + fk.internet().domainName();
            User u = new User(name, lastname, age, city, fiscal_code.toUpperCase(), email.toLowerCase());
            db.createUser(u);
        }
    }
}