package Oppgave2;

import java.util.LinkedList;
import java.util.Queue;

public class Brett {

    private int kapasitet = 4;
    private int antallBurgere = 0;
    private Queue<Burger> burgere = new LinkedList<>();

    public Brett(int kapasitet) {
        this.kapasitet = kapasitet;
    }
    public synchronized void leggPaaBurger(String navn) {
        while (true) {
            if(burgere.size() >= kapasitet) {
                try {
                    System.out.println(navn + " (kokk) er klar med hamburger, men brett er fullt. Venter!");
                    wait(); // Chef threads will wait here when the plate is full.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            /*
            if(burgere.size() >= kapasitet) {
                System.out.print(navn + " (kokk) er klar med hamburger, men brett er fullt. Venter!\n");
                printBoard();
                notifyAll(); // Vi har nådd kapasitet på brettet, vi vil vekke opp alle servitører samt kokkene, slik at en ny tråd kan prøve seg. Helst en servitør.
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } */
            } else {
                notifyAll();
                // Opprett en ny instans av Burger, for å så legge den til i LinkedList
                Burger burger = new Burger(antallBurgere + 1); // Dette blir burger #1
                burgere.offer(burger);
                antallBurgere++;
                notifyAll();
                System.out.print(navn + " (kokk) legger paa hamburger #" + burger.getId() + ". "+ " brett: ");
                printBoard();
                return; // Forlater metoden med return, da vi har laget ferdig en burger.
            }
        }
    }


    public synchronized void taAvBurger(String navn) {
        while (true) {
            if(burgere.isEmpty()) {
                System.out.print(navn + " (servitor) onsker aa ta hamburger, men brett tomt. Venter! Brett: ");
                notifyAll();
                try {
                    wait();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Burger burger = burgere.poll();
                System.out.print(navn + " (servitor) tar av hamburger #" + burger.getId() + ". " + " Brett: ");
                printBoard();
                notifyAll();
                return;
            }
        }
    }

    private void printBoard() {
        System.out.print("[");
        boolean first = true;
        for (Burger burger : burgere) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(burger.getId());
            first = false;
        }
        System.out.println("]");
    }
}
