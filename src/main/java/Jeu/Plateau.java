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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Plateau extends JPanel {

    private BufferedImage image;
    static Plateau uniqueInstance = new Plateau();
    public static int[][] generationPlateau;
    public static Case[][] casePlateau;

    private Plateau() {

    }

    public static Plateau getInstance() {
        return uniqueInstance;
    }

    private Case getCase(int x, int y) {
        return casePlateau[x][y];
    }

    public static void generationMap(int m, int n)
    {
    generationPlateau = new int[m][n];
    File file = new File("src/ressources/mapGeneration.txt");
        try {
            Scanner sc = new Scanner(file);
            sc.useDelimiter(",");
            for(int i=0; i<m;i++)
            {
                for(int j=0; j<n;j++)
                {
                    generationPlateau[i][j] = sc.nextInt();
                }
               sc.nextLine();
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        createMap(m,n);
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
                switch(generationPlateau[i][j])
                {
                    case 0:
                        casePlateau[i][j] = new CaseGrise(x,y);
                        break;
                    case 1:
                        casePlateau[i][j] = new Trottoir(x,y);
                        break;
                    case 2:
                        casePlateau[i][j] = new Route(x,y);
                        break;
                    case 3:
                        casePlateau[i][j] = new Foret(x,y);
                        break;
                    case 4:
                        casePlateau[i][j] = new EtendueEau(x,y);
                        break;
                    case 5:
                        casePlateau[i][j] = new Bibliotheque(x,y);
                        break;
                }
                x += 30;
            }
            x=0;
            y+=30;
        }

    }

    public void paintComponent(Graphics g) {

        for(Case[] i : casePlateau)
        {
            for(Case y : i)
            {
                g.drawImage(y.getImage(), y.getx(), y.gety(), 30, 30, null);
            }
        }
    }

    /*
    private void drawCase(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Rectangle2D e = new Rectangle2D.Double(x, y, 30,30);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.black);
        g2d.draw(e);
    }
    */



}
