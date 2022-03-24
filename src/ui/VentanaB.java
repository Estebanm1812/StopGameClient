package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Answer;
import model.GameInformation;

import java.io.IOException;

public class VentanaB {

    private Answer ownAnswer;

    private Answer rivalAnswer;

    private Stage stage;

    private GameInformation game;

    private Ventana0 windows0;

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


    public VentanaB(GameInformation game, Stage stage, Ventana0 windows0){

        this.game = game;
        this.stage = stage;
        this.windows0 = windows0;


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

            ownNameResult.setText(game.getOwnAnswer().getName_lastName());
            ownAnimalResult.setText(game.getOwnAnswer().getAnimal());
            ownLocationResult.setText(game.getOwnAnswer().getCity_country());
            ownObjectResult.setText(game.getOwnAnswer().getThing());

            opponentAnimalResult.setText(game.getRivalAnswer().getAnimal());
            opponentNameResult.setText(game.getRivalAnswer().getName_lastName());
            opponentLocationResult.setText(game.getRivalAnswer().getCity_country());
            opponentObjectResult.setText(game.getRivalAnswer().getThing());

            youLabel.setText(game.getSelf().getName());
            opponentLabel.setText(game.getRival().getName());

            ownPoints.setText(String.valueOf(game.getOwnPoints()));
            rivalPoints.setText(String.valueOf(game.getRivalPoints()));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void finishGame(ActionEvent event) {

       stage.close();


    }

}
