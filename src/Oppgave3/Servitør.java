package Oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Servitør implements Runnable{

    private BlockingQueue<Burger> board;
    private Random random = new Random();
    private String navn;

    public Servitør(BlockingQueue<Burger> board, String navn) {
        this.board = board;
        this.navn = navn;
    }


    @Override
    public void run() {
        while (true) {
            while (board.size() == 0) {
                try {
                    Thread.sleep(random.nextInt(4000) + 2000);
                } catch (InterruptedException e) {
                }
            }
            try {
                Burger burger = board.poll();
                System.out.println(this.navn + " tar av hamburger " + burger.getId());
                Thread.sleep(random.nextInt(4000) + 2000);
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public String toString() {
        return "Servitor" + navn;
    }

}

