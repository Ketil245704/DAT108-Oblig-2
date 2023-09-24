package Oppgave3;

public class Burger {

    private int id;

    public Burger(int count) {

        this.id = count++;
    }

    public int getId() {
        return id;
    }
}
