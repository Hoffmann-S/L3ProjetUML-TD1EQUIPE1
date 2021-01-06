package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Maison extends Batiment{

    {
        try {
            image = ImageIO.read(new File("src/img/Maison.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Maison(int x, int y) {
        super(x, y);
    }

    public static void ressourcerPersonnage(Personnage p)
    {
        p.moral += 10;
        p.satiete += 10;
        p.soif += 10;
    }
}
