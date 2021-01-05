package Jeu;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Plateau extends JPanel {

    public static boolean inGame = true;
    static Personnage p;
    private BufferedImage imagePersonnage;
    {
        try {
            imagePersonnage = ImageIO.read(new File("src/img/steve.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
                        casePlateau[i][j] = new Case(x,y, false);
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
                    case 6:
                        casePlateau[i][j] = new FastFood(x,y);
                        break;
                }
                x += 30;
            }
            x=0;
            y+=30;
        }

    }

    public boolean checkIsValid(int x, int y)
    {
        if(casePlateau[y][x].getIsValid())
            return true;
        else
            return false;
    }

    public void updateContainPlayer(int x, int y, boolean b)
    {
        Plateau.casePlateau[y][x].setContainPlayer(b);
    }

    public void paintComponent(Graphics g) {

        if(inGame) {
            for (Case[] i : casePlateau) {
                for (Case y : i) {
                    if (!y.getContainPlayer())
                        g.drawImage(y.getImage(), y.getx(), y.gety(), 30, 30, null);
                    else {
                        g.drawImage(imagePersonnage, y.getx(), y.gety(), 30, 30, null);
                    }
                }
            }
            Toolkit.getDefaultToolkit().sync();
        }
        else{
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (950 - metr.stringWidth(msg)) / 2, 1200 / 2);
    }

}
