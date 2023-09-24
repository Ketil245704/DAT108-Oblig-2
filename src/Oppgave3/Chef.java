package Oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class Chef implements Runnable {

    private BlockingQueue<Burger> board;
    private Random random = new Random();
    private String navn;
    private int antallBurgere = 1;


    public Chef(BlockingQueue<Burger> board, String navn) {
        this.board = board;
        this.navn = navn;
    }


    private void printBoard() {
        System.out.print("[");
        boolean first = true;
        for (Burger burger : board) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(burger.getId());
            first = false;
        }
        System.out.println("]");
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(random.nextInt(4000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (board.size() >= 4) {
                try {
                    Thread.sleep(random.nextInt(4000) + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Burger burger = new Burger(antallBurgere); // Dette blir burger #1
            board.offer(burger);
            antallBurgere++;
            System.out.println(this.getName() + " legger paa burger nr " + antallBurgere);
            return;
        }
    }

    public String getName() {
        return navn;
    }

    @Override
    public String toString() {
        return "Kokk " + navn;
    }
}

