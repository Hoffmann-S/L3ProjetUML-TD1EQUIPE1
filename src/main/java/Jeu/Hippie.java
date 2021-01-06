package Jeu;

public class Hippie extends Personnage{


    public Hippie(String pseudo) {
        super(pseudo, 300, 100, 100, 100);
    }

    @Override
    public void checkBarre() {
        if(satiete > 100)
            satiete = 100;
        if(soif > 100)
            soif = 100;
        if(vie > 300)
            vie = 300;
        moral = 100;
        if(pourcentageDiplome > 100)
            pourcentageDiplome = 100;
    }

    public void seDeplacer(Plateau plateau, String direction) {
        if(Deplacement(plateau, direction)) {
            this.vie -= 2;
            this.satiete -= 2;
            this.soif -= 2;
        }
        this.checkMort();
        this.checkBarre();

        Plateau.getInstance().repaint();
    }
}
