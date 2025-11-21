import java.util.*;
import java.util.stream.Collectors;
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

        // OPERAZIONI FINALI
        // sono tutte quelle operazioni che restituiscono un valore finle
        // Terminando la manipolazione dello stream

        // Matching
        // Reduction
        // Collection

        Stream<Integer> myStreamNum = Stream.iterate(0, n -> n+2).limit(10);
        //myStreamNum.forEach(System.out::println);

        //Reduction
        int numRed = myStreamNum.reduce(0, (acc, val) -> acc + val);
        System.out.println(numRed);

//        EQUIVALENTE A:
//        int[] arrNum = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
//        int acc = 0;
//        for(int i = 0; i<arrNum.length; i++) {
//            acc += arrNum[i];
//        }
//        System.out.println(acc);

        // Matching -> VEDERE ANCHE MAIN USER
        Stream<Integer> myStreamNumMatch = Stream.iterate(0, n -> n+2).limit(10);
        boolean trovato = myStreamNumMatch.anyMatch(num -> num.equals(18));
        Stream<Integer> myStreamNumMatch1 = Stream.iterate(0, n -> n+2).limit(10);
        boolean magg18 = myStreamNumMatch1.allMatch(num -> num > 18);
        Stream<Integer> myStreamNumMatch2 = Stream.iterate(0, n -> n+2).limit(10);
        boolean min0 = myStreamNumMatch2.noneMatch(num -> num < 0);
        System.out.println(trovato);
        System.out.println(magg18);
        System.out.println(min0);

        //Collection
        //.collect(Collectors.toSet()) -> Set<E>
        //.collect(Collectors.toList()) -> List<E>
        //.collect(Collectors.toMap()) -> Map<K, V>

        Stream<Double> myStreamRand = Stream.generate(new Random()::nextDouble).limit(10);
        Set<Long> num = myStreamRand
                .map(n -> n * 100)
                .map(Math::round)
                .collect(Collectors.toSet());
        num.forEach(System.out::println);

        //Collectors
        //Collectors.toSet() -> Raccoglie tutti i dati manipolati dello Stream in un Set
        //Collectors.toList() -> Raccoglie tutti i dati manipolati dello Stream in una List
        //Collectors.toMap() -> Raccoglie tutti i dati manipolati dello Stream in un Map
        //Collectors.groupingBy() -> Raggruppa gli elementi di uno Stream in una mappa in cui la Chiave
        //                           sarà la proprietà per il qualle voglio raggruppare
        //                           il Valore sarà una lista di elementi raggruppati
        //Collectors.summingInt() -> Calcola la somma di valori INT in uno stream e mi restituisce il valore
        //Collectors.summingLong() -> Calcola la somma di valori LONG in uno stream e mi restituisce il valore
        //Collectors.summingDouble() -> Calcola la somma di valori DOUBLE in uno stream e mi restituisce il valore
        //Collectors.averageInt() -> Calcola la media di valori INT in uno stream e mi restituisce il valore
        //Collectors.averageLong() -> Calcola la media di valori LONG in uno stream e mi restituisce il valore
        //Collectors.averageDouble() -> Calcola la media di valori DOUBLE in uno stream e mi restituisce il valore

        //Comparators
        //Comparator è un metodo per la gestione avanzata degli ordinamenti in uno stream
        // .sorted(Comparator.comparing(Oggetto::Proprietà)
        // .sorted(Comparator.comparingInt(Oggetto::ProprietàInt)
        // .sorted(Comparator.comparingLong(Oggetto::ProprietàLong)
        // .sorted(Comparator.comparingDouble(Oggetto::ProprietàDouble)

        // Mapping
        // .mapToInt(Oggetto::Proprietà) -> trasforma uno stream di oggetti in uno stream di Interi
        // .mapToLong(Oggetto::Proprietà) -> trasforma uno stream di oggetti in uno stream di Long
        // .mapToDouble(Oggetto::Proprietà) -> trasforma uno stream di oggetti in uno stream di Double
        // .flatMap(obj -> obj.prop.stream()) -> trasforma uno stream di oggetti in uno stream di
        //                                       valori letti da una lista contenuta in una proprietà dell'oggetto


    }
}

// function() {blocco di istruzione}

// () -> {blocco di istruzione};