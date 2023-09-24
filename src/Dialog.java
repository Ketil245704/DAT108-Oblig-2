import static javax.swing.JOptionPane.showInputDialog;

public class Dialog implements Runnable{

    private Printer printer;

    public Dialog(Printer printer) {
        this.printer = printer;
    }



    @Override
    public void run() {

        String dialog = "Write anything you'd like, and it'll repeat itself every 3 seconds. Write quit to terminate";
        String inputFromUser;

        while((inputFromUser = showInputDialog(dialog)) != null && !inputFromUser.equalsIgnoreCase("quit")) {
            printer.setMessage(inputFromUser);
        }
        // When we get to this part, it means one of the conditions above has changed, and we're termination the process.
        System.out.println("Shutting down the session!");
        printer.shutDown();
    }

}
