import java.util.*;

public class Main {
    public static void main(String[] args) {
        //COLLECTIONS
        // Contenitori dinamici di elementi. A differenza degli array che hanno una dimensione fissa
        // Una collection può essere ordinata o non ordinata, può ammettere duplicato o no.
        // L'interfaccia Collection non specifica nulla di quanto detto sopra

        // -> List
        //      Gli elementi sono indicizzati e può contenere duplicati
        //      I valori inseriti sono memorizzati in base all'ordine di inserimento
        //      Consente di leggere, aggiungere, rimuovere e modificare gli elementi in base a un indice
        //      La classe principale che implementa List è ArrayList
        // -> Set
        //      Non ammette duplicati, ma gli elementi non sono indicizzati
        //      I valori inseriti non sono memorizzati in base all'ordine di inserimento
        //      La classe principale che implementa Set è HashSet
        // -> SortedSet
        //      Non ammette duplicati, ma a differenza di Set gli elementi sono indicizzati
        //      La classe principale che implementa SortedSet è TreeSet
        //      I valori inseriti non sono memorizzati in base all'ordine di inserimento
        // -> Queue
        //      Crea una coda che ha dei metodi per leggere, inserire elementi a inizio o alla fine della coda
        //      La classe principale che implementa Queue è LinkedList
        // -> Map
        //      Definisce una funzione composta da elementi di tipo chiave/valore
        // -> SortedMap
        //


        Collection c;
        int x = 25;
        String s = new String("Ciao a tutti");
        System.out.println(s);

        Integer n = new Integer(13);
        Integer n1 = 24;
        Double d;
        Character ch;
        Boolean b;
        System.out.println(n);
        System.out.println("Avvio App");
        testCollection();

    }

    public static void testCollection() {
        Collection<String> c = new ArrayList<String>();
        System.out.println("Collection Size: " + c.size());

        c.add("Primo Elemento");
        c.add("Secondo Elemento");
        c.add("Terzo Elemento");
        System.out.println(c.add("Terzo Elemento"));

        for(int i = 0; i < c.size(); i++) {
            System.out.println("ABC");
        }

        for ( String str: c) {
            System.out.println(str);
        }

        System.out.println("Collection Size: " + c.size());
        System.out.println();
        testMap();
    }
    // TESTO COLLECTION()
    // TEST LIST()
    // TEST SET()
    // TEST QUEUE()
    // TEST MAP()

    public static void testMap() {
        Map<String, String> m = new HashMap<String, String>();
        m.put("A", "Primo Elemento");
        m.put("B", "Secondo Elemento");
        m.put("C", "Terzo Elemento");

        boolean key = m.containsKey("D");
        boolean key1 = m.containsKey("B");
        System.out.println("Contains key 'D': " + key);
        System.out.println("Contains key 'B': " + key1);

        boolean val = m.containsValue("Secondo Elemento");
        System.out.println("Contains value 'Secondo Elemento': " + val);

        String elem = m.get("B");
        System.out.println("Element key 'B': " + elem);

        int size = m.size();
        System.out.println("Map size: " + size);

        boolean isEmpty = m.isEmpty();
        System.out.println("Map isEmpty: " + isEmpty);

        Set<String> keyList = m.keySet();
        System.out.println("Lista Valore delle chiavi: ");
        for(String k: keyList) {
            System.out.println(k + ": " + m.get(k));
        }
        System.out.println("");
        Collection<String> values = m.values();
        System.out.println(values);
        System.out.println("");
        for (String v : values) {
            System.out.println(v);
        }

        m.clear();
        isEmpty = m.isEmpty();
        System.out.println("Map isEmpty: " + isEmpty);
        size = m.size();
        System.out.println("Map size: " + size);
        //System.out.println(m.values());
    }


}