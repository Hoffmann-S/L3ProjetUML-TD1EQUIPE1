package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Trottoir extends Case{

    {
        try {
            image = ImageIO.read(new File("src/img/Trottoir.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public Trottoir(int x, int y) {
        super(x, y);
    }
}
