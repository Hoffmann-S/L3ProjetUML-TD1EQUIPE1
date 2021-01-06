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

    public static void trouverLivre(Personnage p)
    {
        p.moral += 20;
        if (Math.random() < 0.05)
        {
            System.out.println("Vous avez trouvez un livre sur le génie logiciel! +10% de chance d'obtenir un diplome");
            p.pourcentageDiplome += 10;
        }
    }
}
