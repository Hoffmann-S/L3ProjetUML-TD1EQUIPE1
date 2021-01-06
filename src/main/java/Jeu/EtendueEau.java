package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class EtendueEau extends Case{

    {
        try {
            image = ImageIO.read(new File("src/img/EtendueEau.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public EtendueEau(int x, int y) {
        super(x, y);
    }

    public boolean checkMaillotDeBain()
    {
        return true;
    }
}
