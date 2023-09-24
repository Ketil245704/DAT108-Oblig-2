import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {


        Printer printer = new Printer();
        Dialog dialog = new Dialog(printer);

        new Thread(printer).start();
        new Thread(dialog).start();


    }
}
