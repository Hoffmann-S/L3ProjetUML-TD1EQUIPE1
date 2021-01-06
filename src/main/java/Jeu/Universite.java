package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Universite extends Batiment{

    {
        try {
            image = ImageIO.read(new File("src/img/Universite.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Universite(int x, int y) {
        super(x, y);
    }

    public static void obtenirDiplome(Personnage p)
    {
        if (Math.random() < p.pourcentageDiplome / 100)
        {
            p.nbdiplome += 1;
            p.moral +=5;
        }
    }
}
