package ui;

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

    private GameInformation game;

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


    public VentanaB(GameInformation game, Stage stageToShare){

        this.game = game;

        FXMLLoader fxmlA = new FXMLLoader(getClass().getResource("VentanaB.fxml"));

        Parent loadingPane;
        try {
            fxmlA.setController(this);
            loadingPane = (Parent) fxmlA.load();
            Scene scene = new Scene(loadingPane);

            stageToShare.setScene(scene);
            stageToShare.show();

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


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
