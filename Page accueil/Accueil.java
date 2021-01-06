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
import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;
public class Accueil {

    Label label1= new Label("Jeu : Quand on arrive en ville");
    label1.setTextFill(Color.web("#FF1493"));
    label1.setFont(new Font("Arial", 18));
    label1.setStyle("-fx-background-color:#FFFFFF");
    // Ajouter champs taille plateau , pseudo et choix personnage
    Button button1= new Button("Commencer à jouer ");
    button1.setStyle("-fx-background-color: #FFFFFF");
}

    public static void choixUtilisateur()
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String Pseudo;
        System.out.println("Choissisez pseudo:");
        Pseudo = myObj.nextLine();
        System.out.println("Choissisez personnage:");
        switch(myObj.nextInt())
        {
            case 0:
                Plateau.p = new Standard(Pseudo);
                break;
            case 1:
                Plateau.p = new Hippie(Pseudo);
                break;
            case 2:
                Plateau.p = new HommePresse(Pseudo);
                break;
        }
    }

    public static void main(String[] args)
    {
        choixUtilisateur();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Taille du plateau:");
        int taillePlateau = myObj.nextInt();
