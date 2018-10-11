import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private final int serverPort;

    public Server(int serverPort){
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true){
                Socket clientSocket = serverSocket.accept();
                ServerWorker serverWorker = new ServerWorker(this,clientSocket);
                serverWorker.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}