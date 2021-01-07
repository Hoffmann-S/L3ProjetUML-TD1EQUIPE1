package Jeu;
import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;


public class App extends JFrame {


    public App(){
        initUI();
    }


    public void initUI() {
        addKeyListener(new TAdapter()); //Ajout du détecteur d'appuis sur touche de clavier
        add(Plateau.getInstance()); //Ajout du plateau sur l'interface

        setSize(950, 1000);
        setTitle("Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void choixUtilisateur()
    {
        Scanner myObj = new Scanner(System.in);  // Creation d'un objet scanner pour détecter les inputs
        String Pseudo;
        int nb;
        System.out.println("Choissisez pseudo:");
        Pseudo = myObj.nextLine();
        System.out.println("Choissisez personnage (0: Standard, 1: Hippie, 2: Homme presse");
        nb = myObj.nextInt();
        while(nb!=0 && nb!=1 && nb!=2)
        {
            System.out.println("Choissisez personnage (0: Standard, 1: Hippie, 2: Homme presse");
            nb = myObj.nextInt();
        }
        switch(nb)
        {
            case 0: // Standard
                Plateau.p = new Standard(Pseudo);
                break;
            case 1: // Hippie
                Plateau.p = new Hippie(Pseudo);
                break;
            case 2: // Homme presse
                Plateau.p = new HommePresse(Pseudo);
                break;
        }
    }

    public static void main(String[] args)
    {
        choixUtilisateur();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Taille du plateau(30 Obligatoirement):");
        int taillePlateau = myObj.nextInt();
        while(taillePlateau!=30)
        {
            System.out.println("30 Obligatoirement");
            taillePlateau = myObj.nextInt();
        }
        Plateau.generationMap(taillePlateau,taillePlateau);
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
        });

    }


}
