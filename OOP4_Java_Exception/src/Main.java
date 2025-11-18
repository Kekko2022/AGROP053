import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {}
    public static int calcolaDivisione() {
        int num1 = inserisciValore();
        int num2 = inserisciValore();

        try {
            int div = num1 / num2;
            if (div % 2 == 0) {
                throw new CustomException("Non voglio numeri pari!!!");
            }
            return div;
        } catch (ArithmeticException e) {
            System.out.println("Non puoi dividere per 0");
            return 0;
        }
    }

    public static int inserisciValore() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Inserisci un numero: ");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valore errato!!!");
        }
        return 0;
    }
}
