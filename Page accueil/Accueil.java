package Jeu;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Accueil {

    Label label1= new Label("Jeu : Quand on arrive en ville");
    label1.setTextFill(Color.web("#FF1493"));
    label1.setFont(new Font("Arial", 18));
    label1.setStyle("-fx-background-color:#FFFFFF");
    // Ajouter champs taille plateau , pseudo et choix personnage
    Button button1= new Button("Commencer à jouer ");
    button1.setStyle("-fx-background-color: #FFFFFF");
}
