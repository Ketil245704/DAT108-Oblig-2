public class Printer implements Runnable{

    private String message = "Hello Worldz!";
    private boolean running = true;


    @Override
    public void run() {
        printing();
    }

    public void printing() {

        while(running){
            System.out.println(message);
            synchronized (this) {
                try {
                    wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // The loop has been ended, we will print a message letting the user know.
        System.out.println("The program has been exited.");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public synchronized void shutDown() {
        running = false;
    }
}
