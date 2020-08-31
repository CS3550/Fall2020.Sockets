import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    try {
      ServerSocket serverSocket = new ServerSocket(5000);
      while (true) {
        System.out.println("Waiting for a new client");
        Socket clientSocket = serverSocket.accept();

        Runnable runnable = () -> {
          PrintStream out;
          try {
            out = new PrintStream(clientSocket.getOutputStream());
            out.println("Hello, World");
            out.close();
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
