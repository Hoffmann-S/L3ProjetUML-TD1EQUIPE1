package Jeu;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.util.Scanner;

public class App extends JFrame {

    public App(){
        initUI();
    }
    public void initUI() {

        add(Plateau.getInstance());
        setSize(600, 600);
        setTitle("Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Taille du plateau:");
        int taillePlateau = myObj.nextInt();
        Plateau.createMap(taillePlateau,taillePlateau);
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
        });

    }


}
