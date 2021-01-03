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

    public void tomberMalade()
    {

    }
}
