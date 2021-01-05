package Jeu;

public class Hippie extends Personnage{

    public Hippie(String pseudo) {
        super(pseudo, 50, 50, 50, 100);
    }

    public void seDeplacer(Plateau plateau) {
        this.vie -= 2;
    }
}
