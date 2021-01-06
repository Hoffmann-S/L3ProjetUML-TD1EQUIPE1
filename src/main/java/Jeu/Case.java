package Jeu;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Case extends JFrame {

    public void setContainPlayer(boolean containPlayer) {
        this.containPlayer = containPlayer;
    }

    public boolean getContainPlayer() {
        return containPlayer;
    }

    private boolean containPlayer = false; //si la case contiens le joueur
    private boolean isValid; //si la case est grise ou non
    public BufferedImage image; //image associé à la case (définis dans les classes)
    static int compteurCase = 0; //compteur de case, peut être utile mais pas utilisé ici
    private int x;
    private int y;
    private int numCase;

    public Case(int x, int y)
    {
        this.x = x; //position utile pour la partie graphique (afficher les cases)
        this.y = y;
        compteurCase =+1;
        this.numCase = compteurCase;
        this.isValid = true;
    }

    public Case(int x, int y, boolean b) //constructeur pour case grise
    {
        this.x = x;
        this.y = y;
        compteurCase =+1;
        this.numCase = compteurCase;
        this.isValid = b;
    }


    public int getx()
    {
        return x;
    }

    public int gety()
    {
        return y;
    }

    public boolean getIsValid() { return isValid;}

    public BufferedImage getImage()
    {
        return image;
    }

}
