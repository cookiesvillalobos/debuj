import Game.GsonReceiver;
import Lists.*;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerWorker extends Thread{

    private final Socket clientSocket;
    private final Server server;
    private Matrix2 matrix = new Matrix2();
    private int Turn = 0;
    private int Player = 1;
    private Lot lot = new Lot();



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
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String jsonInput = "";
        String jsonInputLast = "";

        while (true){
            // Enviar matriz
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
            //Recibir la línea
            jsonInputLast = jsonInput;
            jsonInput = in.readLine();
            String test = jsonInput.substring(0,1);

            if (!jsonInput.equals(jsonInputLast) && test.equals("{")){
                Gson gson = new Gson();
                GsonReceiver gsonReceiver;
                gsonReceiver = gson.fromJson(jsonInput, GsonReceiver.class);
            }
        }
    }
}
