public class Main {
    public static void main(String[] args) {
        Automobile a1 = new Automobile("Fiat", "Panda", "Bianco", 4);
        Moto m1 = new Moto("Honda", "Hornet", "Rosso", true);
        Camper c1 = new Camper("Leika", "AB124", "Grigio", 6);
        Automobile a2 = new Automobile("Ford", "Fiesta", "Giallo", 4);
        Automobile a3 = new Automobile("Renault", "Clio", "Grigio Cassiopea", 3);
        Smartphone s1 = new Smartphone("Apple", "Iphone", "argento", 8);
        Veicolo.getCount();

        Veicolo[] veicoli = new Veicolo[10];
        veicoli[0] = a1;
        veicoli[1] = m1;
        veicoli[2] = c1;
        veicoli[3] = a2;
        veicoli[4] = a3;

        for(Veicolo v: veicoli) {
            if(v != null) {
                v.start();
                System.out.println(v);
            }
        }

        Navigatore[] nav = new Navigatore[10];
        nav[0] = a1;
        nav[1] = s1;
        nav[2] = c1;
        // nav[3] = m1; LA MOTO NON POSSIEDE L'INTERFACCIA NAVIGATORE

        for(int i = 0; i < nav.length; i++) {
            if(nav[i] != null) {
                nav[i].aggiornaNavigatore();
            }
        }
    }
}