import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by thetekst on 03.06.17.
 */
public class FileWriterApp implements Runnable {

    private Thread thread;
    private Object monitor;
    private char letter;
    private static final String FILE_PATH = "java3-task4/src/main/resources";

    public FileWriterApp(Object monitor, char letter) {
        this.letter = letter;
        this.monitor = monitor;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                try (FileWriter fw = new FileWriter(FILE_PATH + "/readme.txt", true); BufferedWriter bw =
                        new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {

                    for (int j = 0; j < 4; j++) {
                        out.print(letter);
                    }

                    out.println();
                    Thread.sleep(20);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
