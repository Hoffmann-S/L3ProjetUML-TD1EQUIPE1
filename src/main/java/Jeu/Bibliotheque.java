package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bibliotheque extends Batiment {

    {
        try {
            image = ImageIO.read(new File("src/img/Bibliotheque.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public Bibliotheque(int x, int y) {
        super(x, y);
    }

    public void trouverLivre()
    {

    }
}
