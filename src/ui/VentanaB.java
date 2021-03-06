package ui;

import com.google.gson.Gson;
import conn.Sesion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Answer;
import model.GameInformation;
import model.Message;

import java.io.IOException;

public class VentanaB {

    private Answer ownAnswer;

    private Answer rivalAnswer;

    private Stage stage;

    private GameInformation game;

    private Ventana0 windows0;

    private Sesion sesion;

    @FXML
    private Label youLabel;

    @FXML
    private Label opponentLabel;

    @FXML
    private Label ownNameResult;

    @FXML
    private Label opponentNameResult;

    @FXML
    private Label ownAnimalResult;

    @FXML
    private Label opponentAnimalResult;

    @FXML
    private Label ownLocationResult;

    @FXML
    private Label opponentLocationResult;

    @FXML
    private Label ownObjectResult;

    @FXML
    private Label opponentObjectResult;

    @FXML
    private Label ownPoints;

    @FXML
    private Label rivalPoints;


    public VentanaB(GameInformation game, Stage stage, Ventana0 windows0,Sesion sesion){

        this.game = game;
        this.stage = stage;
        this.windows0 = windows0;
        this.sesion = sesion;

    }
    public void updateScreen(){

        FXMLLoader fxmlA = new FXMLLoader(getClass().getResource("VentanaB.fxml"));

        Parent loadingPane;
        try {
            fxmlA.setController(this);
            loadingPane = (Parent) fxmlA.load();
            Scene scene = new Scene(loadingPane);

            stage.setScene(scene);
            stage.show();
            game.calculatePoints();

            ownNameResult.setText(game.getOwnAnswer().getName_lastName() + " (" + game.getOwnNamePoints() + ")");
            ownAnimalResult.setText(game.getOwnAnswer().getAnimal() + " (" + game.getOwnAnimalPoints() + ")");
            ownLocationResult.setText(game.getOwnAnswer().getCity_country() + " (" + game.getOwnCountryPoints() + ")");
            ownObjectResult.setText(game.getOwnAnswer().getThing() + " (" + game.getOwnThingPoint() + ")");

            opponentAnimalResult.setText(game.getRivalAnswer().getAnimal() + " (" + game.getRivalNamePoints() + ")");
            opponentNameResult.setText(game.getRivalAnswer().getName_lastName() + " (" + game.getRivalAnimalPoints() + ")");
            opponentLocationResult.setText(game.getRivalAnswer().getCity_country() + " (" + game.getRivalCountryPoints() + ")");
            opponentObjectResult.setText(game.getRivalAnswer().getThing() + " (" + game.getRivalThingPoints() + ")");

            youLabel.setText(game.getSelf().getName());
            opponentLabel.setText(game.getRival().getName());

            ownPoints.setText(String.valueOf(game.getOwnPoints()));
            rivalPoints.setText(String.valueOf(game.getRivalPoints()));

            if(game.getOwnPoints()>game.getRivalPoints()) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("winnerScreen.fxml"));
                fxmlLoader.setController(this);
                Parent root = fxmlLoader.load();
                Scene scene2 = new Scene(root);
                Stage stage2 = new Stage();
                stage2.initModality(Modality.WINDOW_MODAL);
                //stage2.initOwner(windows0.loadingAnchorPane.getScene().getWindow());
                stage2.setScene(scene2);
                stage2.show();
            }else if(game.getOwnPoints()<game.getRivalPoints()){

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("looserScreen.fxml"));
                fxmlLoader.setController(this);
                Parent root = fxmlLoader.load();
                Scene scene2 = new Scene(root);
                Stage stage2 = new Stage();
                stage2.initModality(Modality.WINDOW_MODAL);
                //stage2.initOwner(windows0.loadingAnchorPane.getScene().getWindow());
                stage2.setScene(scene2);
                stage2.show();


            }else{

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tieScreen.fxml"));
                fxmlLoader.setController(this);
                Parent root = fxmlLoader.load();
                Scene scene2 = new Scene(root);
                Stage stage2 = new Stage();
                stage2.initModality(Modality.WINDOW_MODAL);
                //stage2.initOwner(windows0.loadingAnchorPane.getScene().getWindow());
                stage2.setScene(scene2);
                stage2.show();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void finishGame(ActionEvent event) {

        Message m = new Message("gameEnded");

        Gson gson = new Gson();

        String msg = gson.toJson(m);

        sesion.sendMessage(msg);



        //Platform.exit();

        Platform.runLater(()-> {

           // windows0.returnToSearchin(stage);

            //stage.close();
            windows0.returnToSearchin(stage);
        });



        //System.out.println("Prueba");

    }

    @FXML
    void leaveGame(ActionEvent event)   {

        Message m = new Message("leave");

        Gson gson = new Gson();

        String msg = gson.toJson(m);

        //sesion.sendMessage(msg);

        sesion.sendMessage(msg);
        Platform.exit();

    }
}
