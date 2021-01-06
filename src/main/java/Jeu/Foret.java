package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Foret extends Case{

    {
        try {
            image = ImageIO.read(new File("src/img/Foret.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Foret(int x, int y) {
        super(x, y);
    }

    public static void tomberMalade(Personnage p)
    {
        if (Math.random() < 0.1) {
            p.vie -= 10;
            System.out.println("Vous êtes tomber malade!");
        }
    }
}
