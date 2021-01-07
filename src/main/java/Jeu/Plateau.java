package Jeu;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Plateau extends JPanel { //classe Singleton


    public static boolean inGame = true; //variable si game over ou non
    static Personnage p; //le personnage instancié au début du jeu
    private BufferedImage imagePersonnage; //image du personnage
    private BufferedImage imageVoiture; //image de la voiture
    {
        try {
            imagePersonnage = ImageIO.read(new File("src/img/steve.png"));
            imageVoiture = ImageIO.read(new File("src/img/Voiture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private BufferedImage image;
    static Plateau uniqueInstance = new Plateau(); //instance unique, propre au singleton
    public static int[][] generationPlateau; //array a deux dimension d'int, résultat du parsing du fichier text mapGeneration.txt
    public static Case[][] casePlateau; //array a deux dimension de case

    private Plateau() {
    }

    public static Plateau getInstance() { //classe singleton
        return uniqueInstance;
    }

    private Case getCase(int x, int y) {
        return casePlateau[x][y];
    }


    public static void generationMap(int m, int n) //méthode pour parser le .txt
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

    public static void createMap(int m, int n) //méthode pour créer la map en créant une instance particulière de case selon l'array d'int précedemment généré
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
                    case 0: // si 0 = case vide
                        casePlateau[i][j] = new Case(x,y, false);
                        break;
                    case 1: // si 1 = trottoir
                        casePlateau[i][j] = new Trottoir(x,y);
                        break;
                    case 2: //si 2..
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
                    case 7:
                        casePlateau[i][j] = new Bar(x,y);
                        break;
                    case 8:
                        casePlateau[i][j] = new Universite(x,y);
                        break;
                    case 9:
                        casePlateau[i][j] = new Maison(x,y);
                        break;
                }
                x += 30;//position importante pour la partie graphique
            }
            x=0;
            y+=30;
        }
        casePlateau[22][21].setContainPlayer(true); //case de départ
    }

    public boolean checkIsValid(int x, int y)
    {
        return casePlateau[y][x].getIsValid();
    }

    public void updateContainPlayer(int x, int y, boolean b)
    {
        Plateau.casePlateau[y][x].setContainPlayer(b);
    }

    public void paintComponent(Graphics g) { //surdéfinition de la méthode paintComponent()
        g.clearRect (0, 0, 300, 50); //Affichage des points en haut à gauche de l'écran
        g.drawString("Santé: " + p.vie, 10, 10);
        g.drawString("Satiete: " + p.satiete, 10, 30);
        g.drawString("Soif: " + p.soif, 10, 50);
        g.drawString("Moral: " + p.moral, 100, 10);
        g.drawString("Nb de diplome: " + Personnage.getNbdiplome(), 100, 30);

        if(inGame) { //Si le jeu n'est pas encore perdu
            for (Case[] i : casePlateau) { //Pour chaque case
                for (Case y : i) {
                    if (!y.getContainPlayer()) //Si la case de contiens pas le joueur
                        g.drawImage(y.getImage(), y.getx(), y.gety(), 30, 30, null); // On affiche la case et son image associé
                    else if(y.getContainPlayer() && y instanceof Route) {
                        g.drawImage(imageVoiture, y.getx(), y.gety(), 30, 30, null); // Sinon on affiche le joueur
                    }
                    else{
                        g.drawImage(imagePersonnage, y.getx(), y.gety(), 30, 30, null); // Sinon on affiche le joueur
                    }
                }
            }

        }
        else{ //Sinon la partie se términé
            gameOver(g);
        }
    }


    private void gameOver(Graphics g) { // Fin de la partie

        g.clearRect (0, 0, 950, 1200);
        String msg = "Game Over";
        int score = Personnage.getNbdiplome();
        Font small = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (950 - metr.stringWidth(msg)) / 2, 500);
        g.drawString("Vous avez obtenu " + String.valueOf(score) + " diplome.", (500 - metr.stringWidth(msg)) / 2, 600 ); // Affichage des diplomes


    }

}
