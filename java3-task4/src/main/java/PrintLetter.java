/**
 * Created by thetekst on 03.06.17.
 */
public class PrintLetter implements Runnable {

    private final Object monitor;
    private Thread thread;
    private static volatile char letter = 'A';
    private char letter1;
    private char letter2;

    public PrintLetter(Object monitor, char letter1, char letter2) {
        this.monitor = monitor;
        this.letter1 = letter1;
        this.letter2 = letter2;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != letter1) {
                        monitor.wait();
                    }

                    System.out.print(letter1);
                    letter = letter2;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
