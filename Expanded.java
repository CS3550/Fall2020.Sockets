import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Expanded {

    public static void main(String[] args) {
        new Expanded();
    }

    public Expanded() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for a client");
            while (true) {
                Socket clientSocket = serverSocket.accept();

                Runnable runnable = () -> {
                    System.out.println("A client connected");
                    PrintStream out;
                    DataInputStream in;
                    try {
                        in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
                        String string = new String(in.readLine());
                        System.out.println(string);
                        out = new PrintStream(clientSocket.getOutputStream());
                        if (string.contains("happy"))
                            out.println("HTTP/1.0 200 OK\n\nHello, Im' happy, too");
                        else
                            out.println("HTTP/1.0 200 OK\n\nHello, <b>internet</b>");
                        clientSocket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                };

                Thread thread = new Thread(runnable);

                thread.start();

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
