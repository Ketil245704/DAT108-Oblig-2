package Oppgave2;

import java.util.Random;

public class Servitor implements Runnable{

    Random random = new Random();
    private String navn;
    private Brett brett;

    public Servitor(Brett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }


    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                try {
                    Thread.sleep(random.nextInt(4000) + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            brett.taAvBurger(this.navn);
        }
    }

    public String getNavn() {
        return navn;
    }
}
