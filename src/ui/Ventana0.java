package ui;

import com.google.gson.Gson;
import conn.Sesion;
import events.OnMessageWaiting;
import events.OnSearchingListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Generic;
import model.Message;
import model.Player;

import java.io.IOException;

public class Ventana0 implements OnSearchingListener {

    private OnMessageWaiting waiting;

    private static Sesion sesion;

    @FXML
    public AnchorPane windows0AnchorPane;

    @FXML
    private TextField nameField;

    @FXML
    public AnchorPane loadingAnchorPane;

    @FXML
    void searchGame(ActionEvent event) {

        String name = nameField.getText();


        if(name.trim().isEmpty()==false){
            Player player = Player.getInstance(name);

            sesion = Sesion.getInstance(player);

            setOnMessageWaiting(sesion);
            sesion.setOnSerchinglistener(this);
            sesion.setWindows0(this);



            sesion.start();


        }


    }


    @Override
    public void OnSearching(){

       // System.out.println("Entra");
        FXMLLoader fxmload = new FXMLLoader(getClass().getResource("VentanaDeCargar.fxml"));

        Parent loadingPane;
        try {
            loadingPane = (Parent) fxmload.load();
            Scene scene = new Scene(loadingPane);
            Stage stage = (Stage) windows0AnchorPane.getScene().getWindow();

            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

        waitMessage();
        /*
        String msg = waiting.waitingMessage();

        Gson gson = new Gson();

        if(msg.startsWith("{")){

            Generic generic = gson.fromJson(msg,Generic.class);

            Message m = gson.fromJson(msg,Message.class);

            if(m.getMessage().equals("sendPlayer")){

                Player p = sesion.getPlayer();

                Gson g = new Gson();

                String message = gson.toJson(p);

                sesion.sendMessage(message);


            }

        }
        */

    }

    private void setOnMessageWaiting(OnMessageWaiting waiting){

        this.waiting = waiting;
    }

    public void waitMessage(){

        String msg = waiting.waitingMessage();

        Gson gson = new Gson();

        if(msg.startsWith("{")){

            Generic generic = gson.fromJson(msg,Generic.class);

            Message m = gson.fromJson(msg,Message.class);

            if(m.getMessage().equals("sendPlayer")){

                Player p = sesion.getPlayer();

                Gson g = new Gson();

                String message = gson.toJson(p);

                sesion.sendMessage(message);


            }

        }

    }

}
