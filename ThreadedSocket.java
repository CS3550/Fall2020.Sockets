import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadedSocket implements Runnable {

    private final Socket clientSocket;

    public ThreadedSocket(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        PrintStream out = null;
        try {
            out = new PrintStream(clientSocket.getOutputStream());
            out.println("HTTP/1.0 200 OK\n\nHello, internet");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            out.close();
        }
    }
}
