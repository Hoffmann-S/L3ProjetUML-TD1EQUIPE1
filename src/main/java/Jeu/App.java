package Jeu;
import java.awt.EventQueue;
import javax.swing.JFrame;

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
        Plateau.createMap(5,5);
        EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
        });
        for(Case[] i : Plateau.getInstance().casePlateau)
        {
            for(Case y : i)
            {
                System.out.println(y.getx());
            }
        }
    }


}
