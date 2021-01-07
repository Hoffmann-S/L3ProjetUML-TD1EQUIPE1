package Jeu;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bar extends Batiment{

    {
        try {
            image = ImageIO.read(new File("src/img/Bar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bar(int x, int y) {
        super(x, y);
    }

    public static void Boire(Personnage p) {
        p.soif += 25;
        p.moral += 10;
        p.vie -= 3;
        if (Math.random() < 0.05) { // Probabilité de 5% (probabilité de 0.05 ou moins sur un chiffre généré entre 0 et 1
            p.pourcentageDiplome += 5;
            System.out.println("Vous avez trouvé le sujet de l'éxamen! +5% de chance d'avoir un diplôme");
        }
        if (!p.haveSwimsuit) {
            System.out.println("vous avez obtenu un maillot de bain!");
            p.haveSwimsuit = true;
        }
    }

}
