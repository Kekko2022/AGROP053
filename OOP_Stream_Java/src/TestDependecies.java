import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDependecies {
    public static void main(String[] args) {
        Faker fk = new Faker(new Locale("it-IT"));

        for (int i = 0; i < 10; i++) {
            String name = fk.name().firstName();
            String lastName = fk.name().lastName();
            String country = fk.country().name();

            System.out.println("Ciao " + name + " " + lastName + " - Città: " + country);
        }
    }
}
