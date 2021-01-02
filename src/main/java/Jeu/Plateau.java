package Jeu;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Plateau extends JPanel{

    private BufferedImage image;
    static Plateau uniqueInstance = new Plateau();
    public static Case[][] casePlateau;

    private Plateau(){

    }

    public static Plateau getInstance()
    {
        return uniqueInstance;
    }

    private Case getCase(int x,int y)
    {
        return casePlateau[x][y];
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
                casePlateau[i][j] = new Route(x,y);
                x += 100;
            }
            x=0;
            y+=100;
        }

    }

    public void paintComponent(Graphics g) {

        for(Case[] i : casePlateau)
        {
            for(Case y : i)
            {
                try {
                    image = ImageIO.read(new File("src/img/"+y.getClass().getSimpleName()+".png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                drawCase(g,y.getx(), y.gety());
                g.drawImage(image, y.getx(), y.gety(), 100, 100, null);
            }
        }
    }

    private void drawCase(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Rectangle2D e = new Rectangle2D.Double(x, y, 100,100);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.black);
        g2d.draw(e);
    }


}
