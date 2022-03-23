package ui;

import conn.Sesion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Answer;
import model.GameInformation;

import java.io.IOException;

public class VentanaA {

    GameInformation game;

    Sesion sesion;

    Ventana0 ventana0;
    //AnchorPane windows0AnchorPane;

    @FXML
    private Label title;

    @FXML
    private TextField nameAnswer;

    @FXML
    private TextField animalAnswer;

    @FXML
    private TextField locationAnswer;

    @FXML
    private TextField objectAnswer;

    public VentanaA(GameInformation game, Stage stage, Sesion sesion,Ventana0 ventana0){

        this.ventana0 = ventana0;

        //this.windows0AnchorPane = windows0AnchorPane;

        this.sesion = sesion;

        this.game = game;

        Platform.runLater(()->{

            FXMLLoader fxmlA = new FXMLLoader(getClass().getResource("VentanaA.fxml"));

            Parent loadingPane;
            try {
                fxmlA.setController(this);
                loadingPane = (Parent) fxmlA.load();
                Scene scene = new Scene(loadingPane);

                stage.setScene(scene);
                stage.show();

                title.setText("Letra: " + game.getLetter() );


            } catch (IOException e) {
                e.printStackTrace();
            }

            ventana0.waitMessage();


        });

    }
    @FXML
    void stopGame(ActionEvent event) {

        String name = nameAnswer.getText();

        String animal = animalAnswer.getText();

        String city = locationAnswer.getText();

        String thing = objectAnswer.getText();

        

    }


}
