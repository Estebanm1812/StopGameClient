package conn;

import events.OnMessageReceived;
import events.OnMessageWaiting;
import events.OnSearchingListener;
import javafx.application.Platform;
import model.Player;
import ui.Ventana0;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Sesion extends Thread implements OnMessageWaiting {

    private Player player;

    private static Sesion instance;

    private String ip = "127.0.0.1";

    private int port = 6000;

    private Socket socket;

    private BufferedWriter bw;

    private OnSearchingListener searching;

    private BufferedReader br;

    private Ventana0 windows0;

    private OnMessageReceived received;

    public String msg;

    public static synchronized Sesion getInstance(Player player){


        if(instance==null){

            instance = new Sesion(player);
        }
        return instance;

    }

    private Sesion(Player player){

        this.player = player;

        msg = null;
    }

    @Override
    public void run() {

        try {

            socket = new Socket(ip,port);



            OutputStream os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os));


            InputStream is = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));


            //bwListener.bufferedWritterReady(option);


            //String msg = br.readLine();


            Platform.runLater(()->{

                searching.OnSearching();

            });



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void sendMessage(String line) {

        new Thread(() -> {

            try {
                //rtt.onNotificationSend();
                bw.write(line + "\n");

                // System.out.println(line);
                bw.flush();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
        ;

    }

    public void setOnSerchinglistener(OnSearchingListener  searching){

        this.searching = searching;
    }

    @Override
    public void waitingMessage() {


        new Thread(() -> {

            try {
                while(msg==null || msg.isEmpty() ) {

                    //System.out.println("Espera en el readLine");
                    msg = br.readLine();

                    windows0.msgMain=msg;
                    System.out.println(msg);

                }
                received.onMessageReceived();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();



    }

    public void setWindows0(Ventana0 windows0) {
        this.windows0 = windows0;
    }

    public Player getPlayer() {
        return player;
    }

    public void setReceived(OnMessageReceived received) {
        this.received = received;
    }

    public void resetSesion(){

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setInstance() {
        instance = null;
    }
}
