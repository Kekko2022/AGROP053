import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // lo stream è un interfaccia che restituisce un flusso di dati
        // su cui è possibile fare delle operazioni

        // La sorgente di uno stream è l'elemento che lo genera -> Collection, Array, Stream

        Collection<String> c = new ArrayList<>();
        c.add("JAVA");
        c.add("JAVASCRIPT");
        c.add("PYTHON");
        c.add("C#");
        c.add("NODE.JS");
        c.add("PHP");

        String[] arr = {
                "JAVA",
                "JAVASCRIPT",
                "PYTHON",
                "C#",
                "NODE.JS",
                "PHP"
        };

        List<String> lista = Arrays.asList(arr);
        List<String> listaString = Arrays.asList("JAVA", "JAVASCRIPT", "PYTHON", "C#", "NODE.JS", "PHP");

        Random rand = new Random();
        int num = rand.nextInt();
        int da0A9 = rand.nextInt(10);
        double decimale = rand.nextDouble();

        // Sorgente di tipo Stream
        Stream<String> myStream1 = c.stream();
        Stream<String> myStream2 = lista.stream();
        Stream<String> myStream3 = listaString.stream();
        Stream<Integer> myStream5 = Stream.iterate(0, n -> n+2).limit(20);
        Stream<Double> myStream6 = Stream.generate(new Random()::nextDouble).limit(10);
        Stream<String> myStream7 = Stream.<String>builder().add("JAVA").add("JAVASCRIPT").add("PYTHON").build();

        // Posso operare su uno Stream in due modi:
        //  -> tramite operazioni Intermedie
        //  -> tramite operazioni Finali

        // OPERAZIONI INTERMEDIE
        // Sono tutte quelle operazioni che effettuano delle trasformazioni allo Stream
        // e restituiscono uno Stream modificato
        // Le operazioni intermedie possono essere concatenate
        // e la concatenazione di operazioni intermedie viene chiamata pipeline
        // Le operazioni intermedie si dividono in:
        // --> iteration
        // --> filtering
        // --> mapping

        Stream<String> myStream = Stream.of("JAVA", "JAVASCRIPT", "PYTHON", "C#","JAVA", "NODE.JS", "PHP");

        //myStream = myStream.distinct();
        //myStream = myStream.filter(str -> str.length() > 3);
        //myStream = myStream.sorted();
        //myStream.forEach(str -> System.out.println(str));
//        myStream.distinct()
//                .filter(str -> str.length() > 3)
//                .map(str -> str.toLowerCase() + "!!!")
//                .sorted()
//                .limit(2)
//                .forEach(str -> System.out.println(str));

        List<String> listaModificata = myStream.distinct()
                .filter(str -> str.length() > 3)
                .map(str -> str.toLowerCase() + "!!!")
                .sorted()
                .limit(2)
                .toList();

        listaModificata.forEach(e -> System.out.println(e));

        testLambdaFunction();

    }

    public static void testLambdaFunction(){
        List<String> listaString = Arrays.asList("JAVA", "JAVASCRIPT", "PYTHON", "C#","JAVA", "NODE.JS", "PHP");
        System.out.println("****************************");
        for(int i = 0; i< listaString.size(); i++) {
            System.out.println(listaString.get(i));
        }
        System.out.println("****************************");
        for(String l: listaString) {
            System.out.println(l);
        }
        System.out.println("****************************");

        listaString.forEach(e -> System.out.println(e));
    }
}

// function() {blocco di istruzione}

// () -> {blocco di istruzione};