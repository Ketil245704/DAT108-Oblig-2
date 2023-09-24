package Oppgave2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;
        skrivUtHeader(kokker, servitorer, KAPASITET);
        Brett brett = new Brett(KAPASITET);
        for (String navn : kokker) {
            new Thread(new Kokk(brett, navn)).start();
        }
        for (String navn : servitorer) {
            new Thread(new Servitor(brett, navn)).start();
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
