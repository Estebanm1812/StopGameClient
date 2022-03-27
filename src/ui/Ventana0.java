package ui;

import com.google.gson.Gson;
import conn.Sesion;
import events.OnMessageReceived;
import events.OnMessageWaiting;
import events.OnSearchingListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class Ventana0 implements OnSearchingListener, OnMessageReceived {

    private OnMessageWaiting waiting;

    private static Sesion sesion;

    private GameInformation game;

    private VentanaA windowsA;

    private Stage stageToShare;

    //private Player playerOWN;

    @FXML
    public AnchorPane windows0AnchorPane;

    @FXML
    private TextField nameField;

    @FXML
    public AnchorPane loadingAnchorPane;

    public String msgMain = "";

    @FXML
    void searchGame(ActionEvent event) {

        String name = nameField.getText();


        if(name.trim().isEmpty()==false){
            Player player = new Player(name);
            //playerOWN = player;

            sesion = Sesion.getInstance(player);

            setOnMessageWaiting(sesion);
            sesion.setOnSerchinglistener(this);
            sesion.setWindows0(this);
            sesion.setReceived(this);


            sesion.start();


        }


    }
    /*
    public void searchAgain(Player player){

        sesion = Sesion.getInstance(player);

        setOnMessageWaiting(sesion);
        sesion.setOnSerchinglistener(this);
        sesion.setWindows0(this);
        sesion.setReceived(this);


        sesion.start();
    }
    */

    @Override
    public void OnSearching(){

       // System.out.println("Entra");
        FXMLLoader fxmload = new FXMLLoader(getClass().getResource("VentanaDeCargar.fxml"));

        Parent loadingPane;
        try {
            loadingPane = (Parent) fxmload.load();
            Scene scene = new Scene(loadingPane);
            Stage stage = (Stage) windows0AnchorPane.getScene().getWindow();

            stageToShare = stage;
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

        Platform.runLater(()->{

            waitMessage();

        });

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

    public void finishProgram(Stage stage){



         //Player own = sesion.getPlayer();

        //sesion.resetSesion();
        stage.close();

        //sesion.start();
    }
    public void returnToSearchin(Stage stage){


        System.out.println("Tiene que entrar a aqui");

        FXMLLoader fxmload = new FXMLLoader(getClass().getResource("VentanaDeCargar.fxml"));

        Parent loadingPane;
        try {
            loadingPane = (Parent) fxmload.load();
            Scene scene = new Scene(loadingPane);
           // Stage stage = (Stage) windows0AnchorPane.getScene().getWindow();

            //stageToShare = stage;
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

        Platform.runLater(()->{

            waitMessage();

        });

    }

    private void setOnMessageWaiting(OnMessageWaiting waiting){

        this.waiting = waiting;
    }

    public void waitMessage(){



        Platform.runLater(()->{

            waiting.waitingMessage();




        });



    }

    @Override
    public void onMessageReceived() {


        sesion.msg = null;

        System.out.println(msgMain);

            Gson gson = new Gson();

            String[] parts = msgMain.split("//");

            if(parts[0].startsWith("{")) {

                Generic generic = gson.fromJson(parts[0], Generic.class);

                switch (generic.type) {

                    case "Message":

                    Message m = gson.fromJson(parts[0], Message.class);

                    switch (m.getMessage()) {

                        case "sendPlayer":
                            Player p = sesion.getPlayer();

                            Gson g = new Gson();

                            String message = gson.toJson(p);

                            sesion.sendMessage(message);

                            waiting.waitingMessage();

                            break;

                    }
                    break;

                    case "Player":

                        Player rival = gson.fromJson(parts[0], Player.class);

                        game = new GameInformation(rival, parts[1],sesion.getPlayer());

                        //System.out.println(parts[0]);

                        new Thread(() -> {


                            Platform.runLater( ()->{

                                waitMessage();



                            });


                        }).start();

                        loadGame();

                        break;
                    case "Answer":{


                        System.out.println("Entra al answer");
                        Answer answerRival = gson.fromJson(parts[0], Answer.class);
                        System.out.println("Paso del gson");

                        game.setRivalAnswer(answerRival);

                        System.out.println(game.getRivalAnswer().getAnimal());

                        Answer own = windowsA.getCurrentAnswers();

                        String toSend = gson.toJson(own);

                        sesion.sendMessage(toSend);

                        game.setOwnAnswer(own);

                        Platform.runLater(()->{


                            VentanaB windowsB = new VentanaB(game,stageToShare,this,sesion);
                            windowsB.updateScreen();

                        });

                    }
                }

            }
    }

    public void loadGame() {

        windowsA = new VentanaA(game,stageToShare,sesion,this);

    }
}
