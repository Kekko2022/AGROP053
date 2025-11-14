public class App {
    public static void main(String[] args) {
        Automobile v1 = new Automobile();
        v1.marca = "Citroen";
        v1.modello = "C3";
        v1.anni = 2008;
        v1.targa = "DS711BM";
        v1.stato = false;

        Automobile v2 = new Automobile();
        v2.marca = "Renault";
        v2.modello = "Captur";
        v2.anni = 2025;
        v2.targa = "GZ616AJ";
        v2.stato = false;

        Automobile v3 = new Automobile("Fiat", "Panda", 4);
        v3.targa = "AB123CD";
        Automobile v4 = new Automobile("Renault", "Clio", 5);

        Moto m1 = new Moto("Honda", "500v");
        Camper c1 = new Camper("Laika", "AB124", 7);

        v1.info();
        v2.info();
        v3.info();
        v4.info();
        m1.info();
        c1.info();


        v1.start();
        v4.start();
        m1.start();
        c1.start();

        v1.info();
        v2.info();
        v3.info();
        v4.info();
        m1.info();
        c1.info();

    }
}
