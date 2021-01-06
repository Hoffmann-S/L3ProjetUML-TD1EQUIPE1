package Jeu;
import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;


public class App extends JFrame {


    public App(){
        initUI();
    }


    public void initUI() {
        addKeyListener(new TAdapter());
        add(Plateau.getInstance());

        setSize(950, 1200);
        setTitle("Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
        Plateau.generationMap(taillePlateau,taillePlateau);
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
        });

    }


}
