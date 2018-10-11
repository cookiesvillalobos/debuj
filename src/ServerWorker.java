import Lists.Dot;
import Lists.Matrix1;
import Lists.Matrix2;
import Lists.Persona;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class ServerWorker extends Thread{

    private final Socket clientSocket;
    private final Server server;
    private Matrix2 matrix = new Matrix2();
    private int Turn = 0;
    private int Player = 1;



    public ServerWorker (Server server, Socket clientSocket){
        this.server = server;
        this.clientSocket = clientSocket;
        matrix.Create();
    }

    @Override
    public void run() {
        try{
            handleClientSocket();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleClientSocket() throws IOException{
        while (true){
            try {
                PrintWriter outWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                Gson gson = new Gson();
                GsonSendServer gsonSendServer = new GsonSendServer(matrix, Turn, Player);
                String jsonOutput = gson.toJson(gsonSendServer, GsonSendServer.class);
                //String jsonOutput = gson.toJson(persona, Persona.class);

                System.out.println(jsonOutput);
                outWriter.println(jsonOutput);
                outWriter.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
