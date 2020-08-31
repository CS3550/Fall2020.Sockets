import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockets {

    public static void main(String[] args) {
        try {
            System.out.println("Started the program.");
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {

                Socket clientSocket = serverSocket.accept(); //Blocking method call...It won't return until
                //A client socket connects
                
                System.out.println("A client connected.");

                ThreadedSocket threadedSocket = new ThreadedSocket(clientSocket);
                Thread thread = new Thread(threadedSocket);
                thread.start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

}
