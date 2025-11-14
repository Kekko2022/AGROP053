public class Main {
    public static void main(String[] args){
        // Un linguaggio OOP si poggia su 4 concetti fondamentali
        // INCAPSULAMENTO
        // EREDITARIETA'
        // ASTRAZIONE
        // POLIMORFISMO

        Animal a1 = new Animal("Bobby", 3, "Dog", "Labrador");
        Animal a2 = new Animal("Rex", 6, "Dog", "Pastore Tedesco");

        //a1.info();
        //a2.info();
        //a1.setAge(3);
        //a1.info();
        //a2.info();

        // Modificatori di accesso
        // public -> è visibile a tutti, lo possiamo usare in qualsiasi classe e package
        // private -> si accede tramite getter/setter
        // protected -> visibile nella stessa classe - nello stesso package e nelle sottoclassi anche in altri package (NON E VISIBILE A TUTTI, SOLO TRAMITE EREDITARIETA' SE FUORI DAL PACKAGE)
        // package/default -> limitata allo stesso package, (NON VISIBILE DA UNA SOTTOCLASSE IN UN ALTRO PACKAGE)

        Automobile auto1 = new Automobile("Fiat", "Panda", 3);
        Moto moto1 = new Moto("Honda", "Hornet", true);
        Camper camper1 = new Camper("Laika", "AB123", 5);
        Camion camion1 = new Camion("Iveco", "1234", true);

        System.out.println();
        System.out.println(auto1.info());
        System.out.println(moto1.info());
        System.out.println(camper1.info());

        String txt = "SKDHGHA";
        int num = 5;

        System.out.println();

        String[] arr = new String[5];
        arr[0] = "Benvenuti Ragazzi ";
        arr[1] = "Ciao ";
        arr[2] = "a ";
        arr[3] = "tutti, ";
        arr[4] = "come state?";
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        Automobile[] arrAuto = new Automobile[3];
        arrAuto[0] = auto1;
        //arrAuto[1] = moto1; Non si può, poichè nell'array di Automobile non è possibile aggiungere un oggetto di Moto
        System.out.println();
        //ARRAY DI VEICOLI CON STAMPA TRAMITE FOR
        Veicolo[] arrVeicoli = new Veicolo[4];
        arrVeicoli[0] = auto1;
        arrVeicoli[1] = moto1;
        arrVeicoli[2] = camper1;
        arrVeicoli[3] = camion1;

        System.out.println();
        // Veicolo ve = Veicolo("",""); Non può essere istanziata una classe astratta
        for(int i = 0; i < arrVeicoli.length; i++) {
            Veicolo v = arrVeicoli[i];
            System.out.println(v.info());
            v.start();
            if(v instanceof Automobile) {
                ((Automobile) v).autoradio();
            } else if (v instanceof Moto) {
                ((Moto) v).interfono();
            } else if (v instanceof Camper) {
                Camper c = (Camper) v;
                c.cucina();
            } else if (v instanceof Camion) {
                Camion ca = (Camion) v;
            }
        }
    }
}