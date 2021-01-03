package Jeu;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public abstract class Case extends JFrame {
    public BufferedImage image;
    static int compteurCase = 0;
    private int x;
    private int y;
    private int numCase;

    public Case(int x, int y)
    {
        this.x = x;
        this.y = y;
        compteurCase =+1;
        this.numCase = compteurCase;
    }


    public int getx()
    {
        return x;
    }

    public int gety()
    {
        return y;
    }

    public BufferedImage getImage()
    {
        return image;
    }

}
