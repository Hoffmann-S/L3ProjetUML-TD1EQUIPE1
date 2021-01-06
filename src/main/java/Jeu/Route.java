package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Route extends Case{


    {
        try {
            image = ImageIO.read(new File("src/img/Route.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public Route(int x, int y) {
        super(x, y);
    }
}
