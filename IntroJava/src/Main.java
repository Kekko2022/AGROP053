import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIPI DI DATO PRIMITIVI
        // Classi ->  PascalCase - Prima lettera maiuscola e poi ogni ulteriore Parola con la prima lettera maiuscola (es: IntroJava)
        // Interfacce -> PascalCase
        // Enumeration -> PascalCase

        // Metodi -> CamelCase - Prima lettera è minuscola, ogni ulteriore parola la prima lettera maiuscola (es: introJava)
        // Variabili -> CamelCase
        // Package -> SnakeCase (intro_java)
        // Costanti -> SnakeCase (INTRO_JAVA)

        // TIPI DI DATO PRIMITIVO
        // boolean -> 1  bit
        // char    -> 16 bit
        // byte    -> 8  bit
        // short   -> 16 bit
        // int     -> 32 bit
        // long    -> 64 bit
        // float   -> 32 bit
        // double  -> 64 bit

        // OPERATORI ARITMETICI DI ASSEGNAMENTO
        // =

        // OPERATORI ARITMETICI
        // + - / *

        int x = 25;
        boolean y = true;
        double z = 25.5;

        int n1 = 10;
        int n2 = 3;
        int s = n1 / n2;
        int r = n1 % n2;

        int o = 5;
        int p = o++;

        // Operatori Relazionali -> Restituiscono sempre un valore booleano
        // == != < > <= >=

        // Operatori Logici
        // && || !

        // condizione1 && condizione2 --> true && true = true;
        // condizione1 && condizione2 --> true && false = false;
        // condizione1 && condizione2 --> false && true = false;
        // condizione1 && condizione2 --> false && false = false;

        // condizione1 || condizione2 --> true || true = true;
        // condizione1 || condizione2 --> true || false = true;
        // condizione1 || condizione2 --> false || true = true;
        // condizione1 || condizione2 --> false || false = false;

        // !true --> false
        // !false --> true

        // Scanner input = new Scanner (System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il tuo nome: ");
        String result = sc.nextLine();

        System.out.println("Il tuo nome è: " + result);

        System.out.println(p);
        System.out.println(o);

        String str = "Ciao a tutti";
        String strM = str.toUpperCase();
        System.out.println(strM);
        System.out.println(s);
        System.out.println(r);

        // Main m = new Main();
        // m.somma(5, 4);
        somma(5, 4);
        somma();
    }
    // Metodo di una classe
    // Modificatore - tipo di ritorno - nome del metodo (tipo del parametro e nome del parametro) { blocco di istruzione }
    public static void somma (int x, int y) {
        int result = x + y;
        System.out.println("Il risultato è: " + result);
    }
    public static void somma () {
        int result = 40 + 50;
        System.out.println("Il risultato è: " + result);
    }
}