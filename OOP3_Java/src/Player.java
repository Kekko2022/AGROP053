import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementiMultimediali[] elementi = new ElementiMultimediali[5];

        elementi[0] = new Audio("MiaCanzone", 3, 5);
        elementi[1] = new Video("MioVideo", 3, 5, 0);
        elementi[2] = new Immagine("MiaImmagine", 3);
        elementi[3] = new Audio("MiaCanzone 2", 4, 3);
        elementi[4] = new Video("MioVideo 2", 2, 4, 4);

        int scelta;

        do {
            System.out.println("\nScegli un elemento da eseguire (1-5) oppure 0 per uscire:");
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                ElementiMultimediali elemento = elementi[scelta - 1];
                elemento.info();

                if (elemento instanceof Audio audio) {
                    System.out.println("\nAumento il volume di 1");
                    audio.alzaVolume();

                    System.out.println("Volume dopo aumento:");
                    audio.play();

                    System.out.println("\nAbbasso il volume di 2");
                    audio.abbassaVolume();
                    audio.abbassaVolume();

                    System.out.println("Volume dopo abbassamento:");
                    audio.play();
                }

                if (elemento instanceof Video video) {
                    System.out.println("\nAumento il volume di 1 e luminosità di 1");
                    video.alzaVolume();
                    video.aumentaLuminosita();
                    video.play();

                    System.out.println("\nAbbasso il volume di 2 e luminosità di 1");
                    video.abbassaVolume();
                    video.abbassaVolume();
                    video.diminuisciLuminosita();
                    video.play();
                }

                if (elemento instanceof Immagine img) {
                    System.out.println("\nAumento luminosità di 2");
                    img.aumentaLuminosita();
                    img.aumentaLuminosita();
                    img.show();

                    System.out.println("\nAbbasso luminosità di 1");
                    img.diminuisciLuminosita();
                    img.show();
                }
            }

        } while (scelta != 0);
        System.out.println("Il programma è terminato");
        scanner.close();
    }
}
