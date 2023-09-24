package Oppgave3;


import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

    final String[] kokker = {"Dracula", "MacD", "Bones"};
    final String[] servitorer = {"HarryP", "Cinderella"};
    final int KAPASITET = 4;
    skrivUtHeader(kokker, servitorer, KAPASITET);

    BlockingQueue<Burger> brett = new LinkedBlockingQueue<>(KAPASITET);
        for (String navn : kokker) {
            new Thread(new Chef(brett, navn)).start();
        }
        for (String navn : servitorer) {
            new Thread(new Servitør(brett, navn)).start();
        }
    }


    private static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {

        System.out.println("I denne simuleringer har vi");
        System.out.println(kokker.length + " kokker " + Arrays.toString(kokker));
        System.out.println(servitorer.length + " servitorer " + Arrays.toString(servitorer));
        System.out.println("Kapasiteten til brettet er " + kapasitet + " hamburgere");
        System.out.println("Vi starter...");
    }

}
