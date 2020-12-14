package Jeu;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;



public class Plateau extends JPanel{

    static Plateau uniqueInstance = new Plateau();
    public static Case[][] casePlateau;

    private Plateau(){

    }

    public static Plateau getInstance()
    {
        return uniqueInstance;
    }


    public static void createMap(int m, int n)
    {
        int x = 0;
        int y = 0;
        casePlateau = new Case[m][n];
        for(int i=0; i<m;i++)
        {
            for(int j=0; j<n;j++)
            {
                casePlateau[i][j] = new Case(x,y);
                x += 50;
            }
            x=0;
            y+=50;
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Case[] i : casePlateau)
        {
            for(Case y : i)
            {
                drawCase(g,y.getx(), y.gety());
            }
        }
    }

    private void drawCase(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Rectangle2D e = new Rectangle2D.Double(x, y, 50,50);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.black);
        g2d.draw(e);
    }


}
