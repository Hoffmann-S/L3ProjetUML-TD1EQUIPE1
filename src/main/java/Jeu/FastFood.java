package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FastFood extends Batiment{

    {
        try {
            image = ImageIO.read(new File("src/img/FastFood.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FastFood(int x, int y) {
        super(x, y);
    }

    public static void Manger(Personnage p)
    {
        p.satiete += 25;
        p.moral += 10;
        p.soif += 10;
        p.vie -= 5;
    }

}
