package Jeu;

public class Standard extends Personnage{

    public Standard(String s){
        super(s, 75, 75, 75, 75);
    }

    public void seDeplacer(Plateau plateau) {
        this.vie -= 1;
    }
}
