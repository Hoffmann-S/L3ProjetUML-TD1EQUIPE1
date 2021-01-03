package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CaseGrise extends Case {


    {
        try {
            image = ImageIO.read(new File("src/img/CaseGrise.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;

    public CaseGrise(int x, int y) {
        super(x, y);
    }
}
