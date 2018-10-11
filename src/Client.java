import Game.GsonReceiver;
import Game.Principal;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String [] args) {
        Socket socket = null;
        int Turn = 0;



        System.out.println("Vamos a conectornos");

        //Se abre una conexión en el puertp 1234
        try {
            socket = new Socket("localhost" , 1234);
            System.out.println("Conectado");
            BufferedReader inRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outWriter = new PrintWriter(socket.getOutputStream(),true);

            //Leer campo de juego
            String jsonInput = inRead.readLine();
            Gson gson = new Gson();
            GsonSendServer gsonSendServer;
            gsonSendServer = gson.fromJson(jsonInput,GsonSendServer.class);
            Principal principal = new Principal(gsonSendServer.matrix, gsonSendServer.Turn, gsonSendServer.Turn);
            Turn = gsonSendServer.Turn;

            String jsonOutputLast = "";
            String jsonOutput = "";

            while (true){
                jsonOutputLast = jsonOutput;
                jsonOutput = gson.toJson(principal.getWindow().getSheet().getGsonReceiver(), GsonReceiver.class);

                if (!jsonOutputLast.equals(jsonOutput) & jsonOutput != null){
                    outWriter.println(jsonOutput);
                }

            }



        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
